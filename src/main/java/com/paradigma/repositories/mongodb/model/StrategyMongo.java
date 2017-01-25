package com.paradigma.repositories.mongodb.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Strategy model bean
 * @author jmedinilla
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StrategyMongo {
	
	private List<ActionMongo> offensiveSequence;
	private List<ActionMongo> defensiveSequence;
	private String motto;
}
