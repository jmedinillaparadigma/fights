package com.paradigma.beans.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

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
@ApiModel(value = "Fight", description = "Fight description")
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Fight {
	
	@ApiModelProperty(value = "Fight identifier", example="1", required=true)
	private String id;
	
	@ApiModelProperty(value = "Home fighter of the fight", example="{Fight}", required=true)
	private Fighter homeFighter;
	
	@ApiModelProperty(value = "Away fighter of the fight", example="{Fight}", required=true)
	private Fighter awayFighter;
	
	@ApiModelProperty(value = "Character slected for the player", example="{Fight}", required=true)
	@JsonInclude(Include.NON_NULL)
	private Fighter winner;
}
