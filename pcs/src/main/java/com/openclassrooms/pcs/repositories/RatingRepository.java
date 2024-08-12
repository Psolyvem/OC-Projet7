package com.openclassrooms.pcs.repositories;

import com.openclassrooms.pcs.domain.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interface that let Spring implements all basic CRUD methods for accessing the rating table in the database.
 */
public interface RatingRepository extends JpaRepository<Rating, Integer>
{

}
