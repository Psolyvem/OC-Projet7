package com.openclassrooms.pcs.service;

import com.openclassrooms.pcs.domain.Rating;
import com.openclassrooms.pcs.repositories.RatingRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class RatingServiceTest
{
	IRatingService ratingService;
	@Mock
	RatingRepository ratingRepository;
	Rating rating;

	@BeforeEach
	public void setUp()
	{
		this.ratingService = new RatingService(this.ratingRepository);

		this.rating = new Rating();
		rating.setMoodysRating("Test");
		rating.setsAndPRating("Test");
		rating.setFitchRating("Test");
		rating.setOrderNumber(10);
	}

	@Test
	public void getRatingsTest()
	{
		ratingService.getRatings();
		verify(ratingRepository, times(1)).findAll();
	}

	@Test
	public void getRatingByIdTest()
	{
		ratingService.getRatingById(1);
		verify(ratingRepository, times(1)).findById(1);
	}

	@Test
	public void createRatingTest()
	{
		ratingService.createRating(rating);
		verify(ratingRepository, times(1)).save(rating);
	}

	@Test
	public void updateRatingTest()
	{
		ratingService.updateRating(rating);
		verify(ratingRepository, times(1)).save(rating);
	}

	@Test
	public void deleteRatingTest()
	{
		ratingService.deleteRating(rating);
		verify(ratingRepository, times(1)).delete(rating);
	}
}
