package com.openclassrooms.pcs.service;

import com.openclassrooms.pcs.domain.Rating;
import com.openclassrooms.pcs.repositories.RatingRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Implementation of the IRatingService that gets and process information from the repositories.
 */
@Service
public class RatingService implements IRatingService
{
	RatingRepository ratingRepository;

	public RatingService(RatingRepository ratingRepository)
	{
		this.ratingRepository = ratingRepository;
	}

	/**
	 * Gets all the Rating from the database.
	 * @return an Iterable of Rating
	 */
	@Override
	public Iterable<Rating> getRatings()
	{
		return ratingRepository.findAll();
	}

	/**
	 * Gets a Rating from the database based on its ID.
	 * @return an Optional of Rating
	 */
	@Override
	public Optional<Rating> getRatingById(int id)
	{
		return ratingRepository.findById(id);
	}

	/**
	 * Save a Rating object to the database.
	 * @param rating the Rating to save.
	 */
	@Override
	public void createRating(Rating rating)
	{
		ratingRepository.save(rating);
	}

	/**
	 * Updates a Rating object in the database or create it if it doesn't exist.
	 * @param rating the Rating to update.
	 */
	@Override
	public void updateRating(Rating rating)
	{
		ratingRepository.save(rating);
	}

	/**
	 * Delete a Rating object if it exists in the database.
	 * @param rating the Rating to delete.
	 */
	@Override
	public void deleteRating(Rating rating)
	{
		ratingRepository.delete(rating);
	}
}
