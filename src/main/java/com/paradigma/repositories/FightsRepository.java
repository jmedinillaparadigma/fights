package com.paradigma.repositories;

import com.paradigma.model.FightModel;
import com.paradigma.model.PlayerModel;

public interface FightsRepository {

	/**
	 * This method creates a new fight
	 * @return The fight containing the player
	 */
	public FightModel createFight(PlayerModel playerModel);
}
