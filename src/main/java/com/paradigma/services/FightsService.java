package com.paradigma.services;

import com.paradigma.model.FightModel;
import com.paradigma.model.PlayerModel;

/**
 * Interface for the character operations
 * @author jmedinilla
 */
public interface FightsService {

	/**
	 * This method allows to a player request for a fight
	 * @return The fight containing the player
	 */
	public FightModel requestFight(PlayerModel playerModel);
}
