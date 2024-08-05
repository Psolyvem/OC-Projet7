package com.openclassrooms.pcs.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "rating")
public class Rating {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	Integer id;
	@NotBlank(message = "Moody's Rating is mandatory")
	String moodysRating;
	@NotBlank(message = "S and P Rating mandatory")
	@Column(name = "s_and_p_rating")
	String sAndPRating;
	@NotBlank(message = "Fitch Rating is mandatory")
	String fitchRating;
	@NotNull(message = "Order is mandatory")
	@Min(value = 0, message = "Must be between 0-255")
	@Max(value = 255, message = "Must be between 0-255")
	Integer orderNumber;

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public @NotBlank(message = "Moody's Rating is mandatory") String getMoodysRating()
	{
		return moodysRating;
	}

	public void setMoodysRating(@NotBlank(message = "Moody's Rating is mandatory") String moodysRating)
	{
		this.moodysRating = moodysRating;
	}

	public @NotBlank(message = "S and P Rating mandatory") String getsAndPRating()
	{
		return sAndPRating;
	}

	public void setsAndPRating(@NotBlank(message = "S and P Rating mandatory") String sAndPRating)
	{
		this.sAndPRating = sAndPRating;
	}

	public @NotBlank(message = "Fitch Rating is mandatory") String getFitchRating()
	{
		return fitchRating;
	}

	public void setFitchRating(@NotBlank(message = "Fitch Rating is mandatory") String fitchRating)
	{
		this.fitchRating = fitchRating;
	}

	public @NotNull(message = "Order is mandatory") Integer getOrderNumber()
	{
		return orderNumber;
	}

	public void setOrderNumber(@NotNull(message = "Order is mandatory") Integer orderNumber)
	{
		this.orderNumber = orderNumber;
	}
}
