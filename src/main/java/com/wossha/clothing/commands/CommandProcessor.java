package com.wossha.clothing.commands;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.jms.Queue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wossha.json.events.events.api.Event;
import com.wossha.msbase.commands.CommandResult;
import com.wossha.msbase.commands.ICommand;
import com.wossha.msbase.commands.ICommandSerializer;
import com.wossha.msbase.controllers.ControllerWrapper;
import com.wossha.msbase.exceptions.BusinessException;
import com.wossha.msbase.exceptions.TechnicalException;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
public class CommandProcessor extends ControllerWrapper{

    private Logger logger = LoggerFactory.getLogger(CommandProcessor.class);
    private final static ObjectMapper mapper = new ObjectMapper();
    
    @Autowired
    CommandSerializers commandSerializers;
    
    @Autowired
    JmsTemplate jmsTemplate;
    
    @Autowired
    Queue queue;

    @PostMapping("/commands")
    public ResponseEntity<HashMap<String, String>> processCommand(@RequestBody String json) {
        try {
        	
        	logger.debug("command generated: "+json);
        	JsonNode root = mapper.readTree(json);
            JsonNode jCommand = root.path("commandName");

            ICommandSerializer cs = commandSerializers.get(jCommand.asText());
            
            @SuppressWarnings("rawtypes")
			ICommand command = cs.deserialize(json);

            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    		String username = auth.getPrincipal().toString();
            command.setUsername(username);
            CommandResult result = command.execute();

            publishEvents(result.getEvents());

            return new ResponseEntity<HashMap<String, String>>(wrapMessaje(result.getMessage()),HttpStatus.OK);
        } catch (TechnicalException e) {
            return new ResponseEntity<HashMap<String, String>>(wrapMessaje(e.getMessage()),HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (  IOException | BusinessException e) {
        	return new ResponseEntity<HashMap<String, String>>(wrapMessaje(e.getMessage()),HttpStatus.BAD_REQUEST);
        }
    }

	private void publishEvents(List<Event> events) throws JsonProcessingException {
		for (Event event : events) {
			ObjectMapper mapper = new ObjectMapper();
			String jsonEvent = mapper.writeValueAsString(event);
			jmsTemplate.convertAndSend(queue, jsonEvent);
		}
	}
	
}
