package com.paradigma.services.impl;

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
		// Case 1: Creates a new Fight
		return repository.createFight(playerModel);
	}
}
