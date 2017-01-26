package com.paradigma.model;

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
public class FighterModel {
	
	private PlayerModel player;
	private StrategyModel strategy;
}
