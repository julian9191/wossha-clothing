package com.wossha.clothing.commands.clothing.editClothe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wossha.clothing.WosshaClothingApplication;
import com.wossha.clothing.commands.clothing.editClothe.model.EditClothe;
import com.wossha.clothing.dto.ClotheDTO;
import com.wossha.clothing.infrastructure.mapper.MapperDozer;
import com.wossha.clothing.infrastructure.repositories.ClotheRepository;
import com.wossha.json.events.events.api.Event;
import com.wossha.json.events.events.pictures.SavePictureEvent.Message;
import com.wossha.json.events.events.pictures.SavePictureEvent.SavePictureEvent;
import com.wossha.json.events.services.UUIDGenerator;
import com.wossha.msbase.commands.CommandResult;
import com.wossha.msbase.commands.ICommand;
import com.wossha.msbase.enums.PictureTypesEnum;
import com.wossha.msbase.exceptions.BusinessException;
import com.wossha.msbase.exceptions.TechnicalException;

@Component
public class EditClotheCommand implements ICommand<EditClothe> {

	private EditClothe data;
	private String username;
	private MapperDozer map = new MapperDozer();

	@Autowired
	private ClotheRepository repo;

	@Override
	public String commandName() {
		return "CreateClothe";
	}

	@Override
	public EditClothe data() {
		return this.data;
	}

	@Override
	public void setData(EditClothe data) {
		this.data = data;
	}

	@Override
	public CommandResult execute() throws BusinessException, TechnicalException {
		CommandResult result = new CommandResult();
		ClotheDTO clothe = repo.findClotheByUuid(data.getClothe().getUuid());
		
		if(clothe == null) {
			throw new BusinessException("la prenda a modificar no existe");
		}

		try {
			data.getClothe().setType(data.getClothe().getType().toUpperCase());
			data.getClothe().setCategory(data.getClothe().getCategory().toUpperCase());
			if(data.getClothe().getBrand()!=null) {
				data.getClothe().setBrand(data.getClothe().getBrand().toUpperCase());
			}
			
			ClotheDTO clotheDTO = map.mapClotheDTOToClothe(data.getClothe());

			if (data.getClothe().getPicture() != null) {
				if (data.getClothe().getPicture().getValue() != null) {
					String uuidPicture = UUIDGenerator.generateUUID();
					clotheDTO.setPicture(uuidPicture);
	
					Event savePictureEvent = generateSavePictureEvent(uuidPicture,
							data.getClothe().getPicture().getFilename(), data.getClothe().getPicture().getFiletype(),
							data.getClothe().getPicture().getSize(), data.getClothe().getPicture().getValue(), clothe.getPicture());
					
					result.addEvent(savePictureEvent);
				}
			}

			repo.updateClothe(clotheDTO);
			result.setMessage("La prenda se ha modificado correctamente");

		} catch (Exception e) {
			e.printStackTrace();
			throw new TechnicalException("Ha ocurrido un error al intentar modificar la prenda");
		}

		return result;
	}

	private SavePictureEvent generateSavePictureEvent(String uuidPicture, String picName, String fileType,
			Integer fileSize, String value, String uuidPictureToRemove) {
		Message message = new Message(uuidPicture, picName, fileType, PictureTypesEnum.CLOTHE_PICTURE.name(), fileSize,
				value, uuidPictureToRemove);
		SavePictureEvent event = new SavePictureEvent(WosshaClothingApplication.APP_NAME, this.username, message);
		return event;
	}
	

	@Override
	public void setUsername(String username) {
		this.username = username;
	}

}
