package com.openclassrooms.pcs.domain;

import jakarta.persistence.*;
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
	String sAndPRating;
	@NotBlank(message = "Fitch Rating is mandatory")
	String fitchRating;
	@NotNull(message = "Order is mandatory")
	Integer orderNumber;
}
