package com.paradigma.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Action model bean
 * @author jmedinilla
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ActionModel {
	
	private String id;
	private String name;
	private Boolean isOffensive;
	private Boolean isPunch;
	private Integer value;
}
