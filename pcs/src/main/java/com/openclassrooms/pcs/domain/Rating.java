package com.openclassrooms.pcs.domain;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "rating")
public class Rating {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	Integer id;
	String moodysRating;
	String sAndPRating;
	String fitchRating;
	Integer orderNumber;
}
