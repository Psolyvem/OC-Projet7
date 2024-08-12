package com.openclassrooms.pcs.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

/**
 * A representation class for a rule_name object in the database.
 */
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

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public @NotBlank(message = "Name is mandatory") String getName()
	{
		return name;
	}

	public void setName(@NotBlank(message = "Name is mandatory") String name)
	{
		this.name = name;
	}

	public @NotBlank(message = "Description is mandatory") String getDescription()
	{
		return description;
	}

	public void setDescription(@NotBlank(message = "Description is mandatory") String description)
	{
		this.description = description;
	}

	public @NotBlank(message = "Json is mandatory") String getJson()
	{
		return json;
	}

	public void setJson(@NotBlank(message = "Json is mandatory") String json)
	{
		this.json = json;
	}

	public @NotBlank(message = "Template is mandatory") String getTemplate()
	{
		return template;
	}

	public void setTemplate(@NotBlank(message = "Template is mandatory") String template)
	{
		this.template = template;
	}

	public @NotBlank(message = "SQL is mandatory") String getSqlStr()
	{
		return sqlStr;
	}

	public void setSqlStr(@NotBlank(message = "SQL is mandatory") String sqlStr)
	{
		this.sqlStr = sqlStr;
	}

	public @NotBlank(message = "SQL Part is mandatory") String getSqlPart()
	{
		return sqlPart;
	}

	public void setSqlPart(@NotBlank(message = "SQL Part is mandatory") String sqlPart)
	{
		this.sqlPart = sqlPart;
	}
}
