package com.paradigma.beans.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Action response bean
 * @author jmedinilla
 */

@Data
@ApiModel(value = "Action", description = "Action description")
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Action {
	
	@ApiModelProperty(value = "Action identifier", example="1")
	private String id;
	
	@ApiModelProperty(value = "Action name", example="action1")
	private String name;
	
	@ApiModelProperty(value = "Indicates if the action is offensive (true) or defensive (false)", example="true")
	private Boolean isOffensive;
	
	@ApiModelProperty(value = "Indicates if the punch is punch (true) or kick (false)", example="true")
	private Boolean isPunch;
	
	@ApiModelProperty(value = "Action points value", example="1")
	private Integer value;
}
