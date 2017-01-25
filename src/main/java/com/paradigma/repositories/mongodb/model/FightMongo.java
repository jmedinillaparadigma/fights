package com.paradigma.repositories.mongodb.model;

import org.springframework.data.mongodb.core.mapping.Document;

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
@Document(collection="fights")
public class FightMongo {
	
	private String id;
	private FighterMongo homeFighter;
	private FighterMongo awayFighter;
	private FighterMongo winner;
}
