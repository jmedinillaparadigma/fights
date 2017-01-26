package com.paradigma.beans.fights.response;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Strategy response bean
 * @author jmedinilla
 */

@Data
@ApiModel(value = "Strategy", description = "Stretegy description")
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Strategy {
	
	@ApiModelProperty(value = "Strategy", example="[{Action}]", required=true)
	private List<Action> offensiveSequence;

	@ApiModelProperty(value = "Strategy", example="[{Action}]", required=true)
	private List<Action> defensiveSequence;

	@ApiModelProperty(value = "Epic sentence for the fight", example="I win!", required=true)
	private String motto;
}
