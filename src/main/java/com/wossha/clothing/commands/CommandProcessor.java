package com.wossha.clothing.commands;
import java.io.IOException;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wossha.msbase.controllers.ControllerWrapper;
import com.wossha.msbase.controllers.commands.ICommand;
import com.wossha.msbase.controllers.commands.ICommandSerializer;
import com.wossha.msbase.exceptions.BusinessException;
import com.wossha.msbase.exceptions.TechnicalException;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
public class CommandProcessor extends ControllerWrapper{

    private Logger logger = LoggerFactory.getLogger(CommandProcessor.class);
    private final static ObjectMapper mapper = new ObjectMapper();
    
    @Autowired
    CommandSerializers commandSerializers;

    @PostMapping("/commands")
    public ResponseEntity<HashMap<String, String>> processCommand(@RequestBody String json) {
        try {
        	
        	JsonNode root = mapper.readTree(json);
            JsonNode jCommand = root.path("commandName");

            ICommandSerializer cs = commandSerializers.get(jCommand.asText());
            
            @SuppressWarnings("rawtypes")
			ICommand command = cs.deserialize(json);

            String message = command.execute();
            
            logger.debug("command generated: "+json);

            return new ResponseEntity<HashMap<String, String>>(wrapMessaje(message),HttpStatus.OK);
        } catch (TechnicalException e) {
            return new ResponseEntity<HashMap<String, String>>(wrapMessaje(e.getMessage()),HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (  IOException | BusinessException e) {
        	return new ResponseEntity<HashMap<String, String>>(wrapMessaje(e.getMessage()),HttpStatus.BAD_REQUEST);
        }
    }
	
}
