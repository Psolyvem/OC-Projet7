package com.openclassrooms.pcs.service;

import com.openclassrooms.pcs.domain.Rating;
import com.openclassrooms.pcs.repositories.RatingRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RatingService implements IRatingService
{
	RatingRepository ratingRepository;

	public RatingService(RatingRepository ratingRepository)
	{
		this.ratingRepository = ratingRepository;
	}

	@Override
	public Iterable<Rating> getRatings()
	{
		return ratingRepository.findAll();
	}

	@Override
	public Optional<Rating> getRatingById(int id)
	{
		return ratingRepository.findById(id);
	}

	@Override
	public void createRating(Rating rating)
	{
		ratingRepository.save(rating);
	}

	@Override
	public void updateRating(Rating rating)
	{
		ratingRepository.save(rating);
	}

	@Override
	public void deleteRating(Rating rating)
	{
		ratingRepository.delete(rating);
	}
}
