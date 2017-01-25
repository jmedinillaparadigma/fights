package com.paradigma.services.impl;

import javax.management.InstanceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paradigma.model.FightModel;
import com.paradigma.model.PlayerModel;
import com.paradigma.repositories.FightsRepository;
import com.paradigma.services.FightsService;

/**
 * Default implementation for the Character operations
 * @author jmedinilla
 */
@Service
public class FightsServiceDefault implements FightsService {

	@Autowired
	private FightsRepository repository;

	/**
	 * This method allows to a player request for a fight
	 * @return The fight containing the player
	 */
	@Override
	public FightModel requestFight(PlayerModel playerModel) {
		return repository.requestFight(playerModel);
	}

	/**
	 * This method gets a player by its id
	 * @return The Player with the provided id
	 * @throws InstanceNotFoundException 
	 */
//	@Override
//	public PlayerModel getPlayerById(String id) throws InstanceNotFoundException {
//		return repository.getPlayerById(id);
//	}
	
	
	

}
