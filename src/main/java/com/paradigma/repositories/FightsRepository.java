package com.paradigma.repositories;

import javax.management.InstanceNotFoundException;

import com.paradigma.model.FightModel;
import com.paradigma.model.PlayerModel;

public interface FightsRepository {

	/**
	 * This method allows to a player request for a fight
	 * @return The fight containing the player
	 */
	public FightModel requestFight(PlayerModel playerModel);

	/**
	 * This method gets a player by its id
	 * @return The Player with the provided id
	 * @throws InstanceNotFoundException 
	 */
	//public PlayerModel getPlayerById(String id) throws InstanceNotFoundException;
}
