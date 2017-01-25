package com.paradigma.repositories.mongodb.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Fighter model bean
 * @author jmedinilla
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class FighterMongo {
	
	private PlayerMongo player;
	private StrategyMongo strategy;
}
