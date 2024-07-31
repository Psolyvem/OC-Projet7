package com.openclassrooms.pcs.repositories;

import com.openclassrooms.pcs.domain.CurvePoint;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CurvePointRepository extends JpaRepository<CurvePoint, Integer>
{

}
