package com.paradigma.beans.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Fighter response bean
 * @author jmedinilla
 */

@Data
@ApiModel(value = "Fighter", description = "Fighter description")
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Fighter {
	
	@ApiModelProperty(value = "Player", example="{Player}", required=true)
	private Player player;
	
	@ApiModelProperty(value = "Stretegy selected for the fight", example="{Strategy}", required=true)
	private Strategy strategy;
}
