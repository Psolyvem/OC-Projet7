package com.openclassrooms.pcs.service;

import com.openclassrooms.pcs.domain.CurvePoint;
import com.openclassrooms.pcs.repositories.CurvePointRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Implementation of the ICurvePointService that gets and process information from the repositories.
 */
@Service
public class CurvePointService implements ICurvePointService
{
	CurvePointRepository curvePointRepository;

	public CurvePointService(CurvePointRepository curvePointRepository)
	{
		this.curvePointRepository = curvePointRepository;
	}

	/**
	 * Gets all the CurvePoint from the database.
	 * @return an Iterable of CurvePoint
	 */
	@Override
	public Iterable<CurvePoint> getCurvePoints()
	{
		return curvePointRepository.findAll();
	}

	/**
	 * Gets a CurvePoint from the database based on its ID.
	 * @return an Optional of CurvePoint
	 */
	@Override
	public Optional<CurvePoint> getCurvePointById(int id)
	{
		return curvePointRepository.findById(id);
	}

	/**
	 * Save a CurvePoint object to the database.
	 * @param curvePoint the CurvePoint to save.
	 */
	@Override
	public void createCurvePoint(CurvePoint curvePoint)
	{
		curvePointRepository.save(curvePoint);
	}

	/**
	 * Updates a CurvePoint object in the database or create it if it doesn't exist.
	 * @param curvePoint the CurvePoint to update.
	 */
	@Override
	public void updateCurvePoint(CurvePoint curvePoint)
	{
		curvePointRepository.save(curvePoint);
	}

	/**
	 * Delete a CurvePoint object if it exists in the database.
	 * @param curvePoint the CurvePoint to delete.
	 */
	@Override
	public void deleteCurvePoint(CurvePoint curvePoint)
	{
		curvePointRepository.delete(curvePoint);
	}
}
