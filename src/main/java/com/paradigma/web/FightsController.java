package com.paradigma.web;

import javax.management.InstanceNotFoundException;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.paradigma.beans.request.Player;
import com.paradigma.beans.response.Character;
import com.paradigma.beans.response.Fight;
import com.paradigma.beans.response.Fighter;
import com.paradigma.model.CharacterModel;
import com.paradigma.model.FightModel;
import com.paradigma.model.FighterModel;
import com.paradigma.model.PlayerModel;
import com.paradigma.repositories.mongodb.model.FightMongo;
import com.paradigma.services.FightsService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;

/**
 * Controller to handle the http request to this service
 * @author jmedinilla
 */
@Api(value = "Fights management service")
@RequestMapping("/fights")
@RestController
@Slf4j
public class FightsController {

	@Autowired
	private FightsService service;
	
	
	/**
	 * This method allows to a player request for a fight
	 * @return The fight containing the player
	 */
	@ApiOperation(value = "Requests a fight for a player")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Return an alredy registered fight for the provided player", response = Fight.class),
			@ApiResponse(code = 201, message = "Creates a new fight a register the provide player successfuly", response = Fight.class),
			@ApiResponse(code = 400, message = "Bad request"),
			@ApiResponse(code = 424, message = "Failed external dependecy"),
			@ApiResponse(code = 500, message = "Server error") })
	@RequestMapping(value = "/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Fight> createFight(
			@RequestHeader("Authorization") String token,
			@RequestBody(required=true) @Valid Player playerRequest) {

		log.info("POST -> /fights {}", playerRequest);
		
		//TODO: Input validations???
		
		PlayerModel playerModel = transformPlayer(playerRequest);
		FightModel fight = service.requestFight(playerModel);

		//TODO: 200 or 201
		return new ResponseEntity<Fight>(transformFightModelToReturn(fight), HttpStatus.CREATED);
	}
	
	
	/**
	 * This method gets a player by its id
	 * @return The Player with the provided id
	 * @throws InstanceNotFoundException 
	 */
//	@ApiOperation(value = "Retrieves a player by its id")
//	@ApiResponses(value = {
//			@ApiResponse(code = 200, message = "Retrieves the player with the provided id", response = Player.class),
//			@ApiResponse(code = 400, message = "Bad request"),
//			@ApiResponse(code = 404, message = "Player not found"),
//			@ApiResponse(code = 424, message = "Failed external dependecy"),
//			@ApiResponse(code = 500, message = "Server error") })
//	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
//	@ResponseStatus(HttpStatus.OK)
//	public ResponseEntity<Player> retrievePlayerById(
//			@RequestHeader("Authorization") String token,
//			@PathVariable(required=true) String id) throws InstanceNotFoundException {
//
//		log.info("GET -> /players/{id} {}", id);
//		
//		
//		PlayerModel playerModel = service.getPlayerById(id);
//		
//		return ResponseEntity.ok(transformPlayerResult(playerModel));
//	}

	
	//////////////////////////////
	// Private functions
	//////////////////////////////
	
//	private Player transformPlayerResult(PlayerModel source) {
//		Player result = new Player();
//		BeanUtils.copyProperties(source, result);
//		result.setCharacter(new Character());
//		BeanUtils.copyProperties(source.getCharacter(), result.getCharacter());
//
//		return result;
//	}
	
	private Fight transformFightModelToReturn(FightModel fightModel) {
		Character characterReturn = new Character();
		BeanUtils.copyProperties(fightModel.getHomeFighter().getPlayer().getCharacter(), characterReturn);
		
		com.paradigma.beans.response.Player playerReturn = new com.paradigma.beans.response.Player();
		BeanUtils.copyProperties(fightModel.getHomeFighter().getPlayer(), playerReturn);
		playerReturn.setCharacter(characterReturn);
		
		Fighter fighterReturn = new Fighter();
		BeanUtils.copyProperties(fightModel.getHomeFighter(), fighterReturn);
		fighterReturn.setPlayer(playerReturn);
		
		Fight fightReturn = new Fight();
		fightReturn.setId(fightModel.getId());
		fightReturn.setHomeFighter(fighterReturn);
		
		return fightReturn;
	}
	
	private PlayerModel transformPlayer(Player source) {
		PlayerModel target = new PlayerModel();
		BeanUtils.copyProperties(source, target);
		target.setCharacter(new CharacterModel());
		BeanUtils.copyProperties(source.getCharacter(), target.getCharacter());

		return target;
	}

	
}
