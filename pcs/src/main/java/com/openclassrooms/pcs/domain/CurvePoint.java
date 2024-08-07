package com.openclassrooms.pcs.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.sql.Timestamp;

/**
 * A representation class for a curve_point object in the database.
 */
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

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public Integer getCurveId()
	{
		return curveId;
	}

	public void setCurveId(Integer curveId)
	{
		this.curveId = curveId;
	}

	public Timestamp getAsOfDate()
	{
		return asOfDate;
	}

	public void setAsOfDate(Timestamp asOfDate)
	{
		this.asOfDate = asOfDate;
	}

	public @NotNull(message = "Term is mandatory") Double getTerm()
	{
		return term;
	}

	public void setTerm(@NotNull(message = "Term is mandatory") Double term)
	{
		this.term = term;
	}

	public @NotNull(message = "Value is mandatory") Double getValue()
	{
		return value;
	}

	public void setValue(@NotNull(message = "Value is mandatory") Double value)
	{
		this.value = value;
	}

	public Timestamp getCreationDate()
	{
		return creationDate;
	}

	public void setCreationDate(Timestamp creationDate)
	{
		this.creationDate = creationDate;
	}
}
