package com.wossha.clothing.commands.clothing.createClothe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.wossha.clothing.WosshaClothingApplication;
import com.wossha.clothing.commands.clothing.createClothe.model.CreateClothe;
import com.wossha.clothing.dto.ClotheDTO;
import com.wossha.clothing.infrastructure.mapper.MapperDozer;
import com.wossha.clothing.infrastructure.repositories.ClotheRepository;
import com.wossha.json.events.events.api.Event;
import com.wossha.json.events.events.pictures.SavePictureEvent.Message;
import com.wossha.json.events.events.pictures.SavePictureEvent.PictureInfo;
import com.wossha.json.events.events.pictures.SavePictureEvent.SavePictureEvent;
import com.wossha.json.events.services.UUIDGenerator;
import com.wossha.msbase.commands.CommandResult;
import com.wossha.msbase.commands.ICommand;
import com.wossha.msbase.enums.PictureTypesEnum;
import com.wossha.msbase.exceptions.BusinessException;
import com.wossha.msbase.exceptions.TechnicalException;

@Component
public class CreateClotheCommand implements ICommand<CreateClothe> {

	private CreateClothe data;
	private String username;
	private MapperDozer map = new MapperDozer();

	@Autowired
	private ClotheRepository repo;

	@Override
	public String commandName() {
		return "CreateClothe";
	}

	@Override
	public CreateClothe data() {
		return this.data;
	}

	@Override
	public void setData(CreateClothe data) {
		this.data = data;
	}

	@Override
	public CommandResult execute() throws BusinessException, TechnicalException {
		CommandResult result = new CommandResult();

		try {
			data.getClothe().setType(data.getClothe().getType().toUpperCase());
			data.getClothe().setCategory(data.getClothe().getCategory().toUpperCase());
			if(data.getClothe().getBrand()!=null) {
				data.getClothe().setBrand(data.getClothe().getBrand().toUpperCase());
			}
			data.getClothe().setUuid(UUIDGenerator.generateUUID());

			ClotheDTO clotheDTO = map.mapClotheDTOToClothe(data.getClothe());

			if (data.getClothe().getPicture() != null) {
				if (data.getClothe().getPicture().getValue() != null) {
					String uuidPicture = UUIDGenerator.generateUUID();
					clotheDTO.setPicture(uuidPicture);

					Event savePictureEvent = generateSavePictureEvent(uuidPicture,
							data.getClothe().getPicture().getFilename(), data.getClothe().getPicture().getFiletype(),
							data.getClothe().getPicture().getSize(), data.getClothe().getPicture().getValue());
					
					result.addEvent(savePictureEvent);
				}
			}

			repo.addClothe(clotheDTO);
			result.setMessage("La prenda se ha creado correctamente");

		} catch (Exception e) {
			e.printStackTrace();
			throw new TechnicalException("Ha ocurrido un error al intentar clear la prenda");
		}

		return result;
	}

	private SavePictureEvent generateSavePictureEvent(String uuidPicture, String picName, String fileType,
			Integer fileSize, String value) {
		
		PictureInfo pictureInfo = new PictureInfo(uuidPicture, picName, fileType, PictureTypesEnum.CLOTHE_PICTURE.name(), fileSize,
				value, null);
		
		Message message = new Message();
		message.getPictures().add(pictureInfo);

		SavePictureEvent event = new SavePictureEvent(WosshaClothingApplication.APP_NAME, this.username, message);
		return event;
	}

	@Override
	public void setUsername(String username) {
		this.username = username;
	}

}
