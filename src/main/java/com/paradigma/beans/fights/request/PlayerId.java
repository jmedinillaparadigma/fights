package com.paradigma.beans.fights.request;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Player request bean
 * @author jmedinilla
 */

@Data
@ApiModel(value = "Player", description = "Player description")
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PlayerId {
	
	@ApiModelProperty(value = "Player identifier", example="1", required=true)
	@NotNull
	private String id;
}
