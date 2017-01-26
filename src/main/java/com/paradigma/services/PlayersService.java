package com.paradigma.services;

import javax.management.InstanceNotFoundException;

import com.paradigma.model.PlayerModel;

/**
 * Interface for the character operations
 * @author jmedinilla
 */
public interface PlayersService {

	/**
	 * This method creates a new Player
	 * @param playerModel The input parameters to create the player
	 */
	public void createPlayer(PlayerModel playerModel);

	/**
	 * This method gets a player by its id
	 * @return The Player with the provided id
	 * @throws InstanceNotFoundException 
	 */
	public PlayerModel getPlayerById(String id) throws InstanceNotFoundException;
}