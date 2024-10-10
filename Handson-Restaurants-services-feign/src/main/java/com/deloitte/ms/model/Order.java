package com.deloitte.ms.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
	private Integer oid;
	private String orderName;
	private Double amount;
	private String type;

}
