package com.paradigma.repositories.mongodb.model;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Player model bean
 * @author jmedinilla
 */

@Data
@ApiModel(value = "Player", description = "Player description")
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PlayerMongo {
	
	private String id;
	private String userId;
	private String userName;
	private CharacterMongo character;
}
