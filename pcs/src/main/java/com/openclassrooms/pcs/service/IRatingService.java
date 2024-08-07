package com.openclassrooms.pcs.service;

import com.openclassrooms.pcs.domain.Rating;

import java.util.Optional;

/**
 * An Interface defining the methods needed for an implementation of a RatingService.
 */
public interface IRatingService
{
	public Iterable<Rating> getRatings();

	public Optional<Rating> getRatingById(int id);

	public void createRating(Rating rating);

	public void updateRating(Rating rating);

	public void deleteRating(Rating rating);
}
