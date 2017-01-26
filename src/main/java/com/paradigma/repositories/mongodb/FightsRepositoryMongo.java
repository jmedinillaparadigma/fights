package com.paradigma.repositories.mongodb;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Repository;

import com.paradigma.model.FightModel;
import com.paradigma.model.FighterModel;
import com.paradigma.model.PlayerModel;
import com.paradigma.repositories.FightsRepository;
import com.paradigma.repositories.mongodb.model.FightMongo;
import com.paradigma.repositories.mongodb.model.FighterMongo;

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
	public FightModel createFight(PlayerModel playerModel){
		FightMongo fightMongo = new FightMongo();
		FighterMongo fighterMongo = new FighterMongo();
		fighterMongo.setPlayerId(playerModel.getId());
		fightMongo.setHomeFighter(fighterMongo);
		
		mongoOperations.insert(fightMongo);
		
		return transformFightMongoToModel(fightMongo);
	}


	//////////////////////////////
	// Private functions
	//////////////////////////////
	
	private FightModel transformFightMongoToModel(FightMongo fightMongo) {
		
		PlayerModel playerModel = new PlayerModel();
		playerModel.setId(fightMongo.getHomeFighter().getPlayerId());
		
		FighterModel fighterModel = new FighterModel();
		BeanUtils.copyProperties(fightMongo.getHomeFighter(), fighterModel);
		fighterModel.setPlayer(playerModel);
		
		FightModel fightModel = new FightModel();
		fightModel.setId(fightMongo.getId());
		fightModel.setHomeFighter(fighterModel);
		
		return fightModel;
	}
}
