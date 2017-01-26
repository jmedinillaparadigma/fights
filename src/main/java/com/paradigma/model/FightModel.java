package com.paradigma.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Character response bean
 * @author jmedinilla
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class FightModel {
	
	private String id;
	private FighterModel homeFighter;
	private FighterModel awayFighter;
	private FighterModel winner;
}
