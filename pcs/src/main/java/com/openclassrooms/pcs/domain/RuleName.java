package com.openclassrooms.pcs.domain;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "rulename")
public class RuleName {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	Integer id;
	String name;
	String description;
	String json;
	String template;
	String sqlStr;
	String sqlPart;
}
