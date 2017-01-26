package com.paradigma.model;

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
public class StrategyModel {
	
	private List<ActionModel> offensiveSequence;
	private List<ActionModel> defensiveSequence;
	private String motto;
}
