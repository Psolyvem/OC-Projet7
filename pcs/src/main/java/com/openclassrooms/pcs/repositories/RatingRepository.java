package com.openclassrooms.pcs.repositories;

import com.openclassrooms.pcs.domain.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingRepository extends JpaRepository<Rating, Integer> {

}
