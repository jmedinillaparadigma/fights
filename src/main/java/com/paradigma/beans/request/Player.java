package com.paradigma.beans.request;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Character response bean
 * @author jmedinilla
 */

@Data
@ApiModel(value = "Player", description = "Player description")
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Player {
	
	@ApiModelProperty(value = "Player identifier", example="1", required=true)
	@NotNull
	private String id;
	
	@ApiModelProperty(value = "User identifier", example="001", required=true)
	@NotNull
	private String userId;
	
	@ApiModelProperty(value = "User name", example="john", required=true)
	@NotNull
	private String userName;
	
	@ApiModelProperty(value = "Character slected for the player", example="{Charater}", required=true)
	@NotNull
	@Valid
	private Character character;
}
