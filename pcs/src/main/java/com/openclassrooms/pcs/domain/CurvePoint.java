package com.openclassrooms.pcs.domain;

import jakarta.persistence.*;
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
	Double term;
	Double value;
	Timestamp creationDate;
}
