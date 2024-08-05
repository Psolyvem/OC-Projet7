package com.openclassrooms.pcs.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity
@Table(name = "rule_name")
public class RuleName {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	Integer id;
	@NotBlank(message = "Name is mandatory")
	String name;
	@NotBlank(message = "Description is mandatory")
	String description;
	@NotBlank(message = "Json is mandatory")
	String json;
	@NotBlank(message = "Template is mandatory")
	String template;
	@NotBlank(message = "SQL is mandatory")
	String sqlStr;
	@NotBlank(message = "SQL Part is mandatory")
	String sqlPart;
}
