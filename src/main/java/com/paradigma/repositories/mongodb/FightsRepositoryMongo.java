package com.paradigma.repositories.mongodb;

import javax.management.InstanceNotFoundException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Repository;

import com.paradigma.model.CharacterModel;
import com.paradigma.model.FightModel;
import com.paradigma.model.FighterModel;
import com.paradigma.model.PlayerModel;
import com.paradigma.repositories.FightsRepository;
import com.paradigma.repositories.mongodb.model.CharacterMongo;
import com.paradigma.repositories.mongodb.model.FightMongo;
import com.paradigma.repositories.mongodb.model.FighterMongo;
import com.paradigma.repositories.mongodb.model.PlayerMongo;

/**
 * Implementation of the Character Repository for MongoDB 
 * @author jmedinilla
 */
@Repository
public class FightsRepositoryMongo implements FightsRepository {

	@Autowired
	private MongoOperations mongoOperations;

	
	/**
	 * This method allows to a player request for a fight.
	 * This method creates a new fight or retrieves the already registered fight for this player
	 * @return A fight containing the player
	 */
	public FightModel requestFight(PlayerModel playerModel){
		
		// Case 1: Creates a new Fight
		PlayerMongo playerMongo = transformPlayerModelToMongo(playerModel);
		
		FightMongo fightMongo = new FightMongo();
		FighterMongo fighterMongo = new FighterMongo();
		fighterMongo.setPlayer(playerMongo);
		fightMongo.setHomeFighter(fighterMongo);
		
		mongoOperations.insert(fightMongo);
		
		return transformFightMongoToModel(fightMongo);
	}


	/**
	 * This method gets a player by its id
	 * @return The Player with the provided id
	 * @throws InstanceNotFoundException 
	 */	
//	@Override
//	public PlayerModel getPlayerById(String id) throws InstanceNotFoundException {
//		PlayerMongo pm = mongoOperations.findById(id, PlayerMongo.class);
//		if(pm==null){
//			throw new InstanceNotFoundException("The player with the provided id does not exist in our systems");
//		}
//		return transformPlayerModelToMongo(pm);
//	}
	
	
	
	
	
	//////////////////////////////
	// Private functions
	//////////////////////////////
	
	private FightModel transformFightMongoToModel(FightMongo fightMongo) {
		CharacterModel characterModel = new CharacterModel();
		BeanUtils.copyProperties(fightMongo.getHomeFighter().getPlayer().getCharacter(), characterModel);
		
		PlayerModel playerModel = new PlayerModel();
		BeanUtils.copyProperties(fightMongo.getHomeFighter().getPlayer(), playerModel);
		playerModel.setCharacter(characterModel);
		
		FighterModel fighterModel = new FighterModel();
		BeanUtils.copyProperties(fightMongo.getHomeFighter(), fighterModel);
		fighterModel.setPlayer(playerModel);
		
		FightModel fightModel = new FightModel();
		fightModel.setId(fightMongo.getId());
		fightModel.setHomeFighter(fighterModel);
		
		return fightModel;
	}
	
	
	private PlayerMongo transformPlayerModelToMongo(PlayerModel source) {
		PlayerMongo target = new PlayerMongo();
		BeanUtils.copyProperties(source, target);
		target.setCharacter(new CharacterMongo());
		BeanUtils.copyProperties(source.getCharacter(), target.getCharacter());
		return target;
	}
	
//	private PlayerModel transformPlayerModelToMongo(PlayerMongo source) {
//		PlayerModel target = new PlayerModel();
//		BeanUtils.copyProperties(source, target);
//		target.setCharacter(new CharacterModel());
//		BeanUtils.copyProperties(source.getCharacter(), target.getCharacter());
//		return target;
//	}



}
