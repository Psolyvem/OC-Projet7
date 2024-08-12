package com.openclassrooms.pcs.controller;

import com.openclassrooms.pcs.controllers.RatingController;
import com.openclassrooms.pcs.domain.Rating;
import com.openclassrooms.pcs.service.IRatingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import java.util.Optional;

import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class RatingControllerTest
{
	RatingController ratingController;
	@Mock
	IRatingService ratingService;
	@Mock
	Model model;
	@Mock
	BindingResult bindingResult;
	Rating rating;

	@BeforeEach
	public void setUp()
	{
		this.ratingController = new RatingController(this.ratingService);

		this.rating = new Rating();
		rating.setMoodysRating("Test");
		rating.setsAndPRating("Test");
		rating.setFitchRating("Test");
		rating.setOrderNumber(10);
	}

	@Test
	public void homeTest()
	{
		ratingController.home(model);
		verify(ratingService, times(1)).getRatings();
	}

	@Test
	public void validateTest()
	{
		ratingController.validate(rating, bindingResult, model);
		verify(ratingService, times(1)).createRating(rating);
	}

	@Test
	public void showUpdateFormTest()
	{
		when(ratingService.getRatingById(1)).thenReturn(Optional.of(rating));
		ratingController.showUpdateForm(1, model);
		verify(ratingService, times(1)).getRatingById(1);
	}

	@Test
	public void updateRatingTest()
	{
		when(ratingService.getRatingById(1)).thenReturn(Optional.of(rating));
		ratingController.updateRating(1, rating, bindingResult, model);
		verify(ratingService, times(1)).updateRating(rating);
	}

	@Test
	public void deleteRatingTest()
	{
		when(ratingService.getRatingById(1)).thenReturn(Optional.of(rating));
		ratingController.deleteRating(1, model);
		verify(ratingService, times(1)).deleteRating(rating);
	}
}
