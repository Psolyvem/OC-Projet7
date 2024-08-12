package com.openclassrooms.pcs.domain;

import org.junit.jupiter.api.Test;

public class RatingTest
{
	Rating rating;

	@Test
	void ratingTest()
	{
		this.rating = new Rating();
		rating.setId(1);
		rating.setMoodysRating("test");
		rating.setsAndPRating("test");
		rating.setFitchRating("test");
		rating.setOrderNumber(1);

		rating.getId();
		rating.getMoodysRating();
		rating.getsAndPRating();
		rating.getFitchRating();
		rating.getOrderNumber();
	}
}
