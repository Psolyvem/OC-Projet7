package com.openclassrooms.pcs.repositories;

import com.openclassrooms.pcs.domain.CurvePoint;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * Interface that let Spring implements all basic CRUD methods for accessing the curve_point table in the database.
 */
public interface CurvePointRepository extends JpaRepository<CurvePoint, Integer>
{

}
