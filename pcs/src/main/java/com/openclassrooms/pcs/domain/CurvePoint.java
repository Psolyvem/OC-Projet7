package com.openclassrooms.pcs.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Entity
@Table(name = "curve_point")
public class CurvePoint {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	Integer id;
	Integer curveId;
	Timestamp asOfDate;
	@NotNull(message = "Term is mandatory")
	Double term;
	@NotNull(message = "Value is mandatory")
	Double value;
	Timestamp creationDate;
}
