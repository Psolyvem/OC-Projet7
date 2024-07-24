package com.openclassrooms.pcs.service;

import com.openclassrooms.pcs.domain.CurvePoint;
import com.openclassrooms.pcs.repositories.CurvePointRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CurvePointService implements ICurvePointService
{
	CurvePointRepository curvePointRepository;

	public CurvePointService(CurvePointRepository curvePointRepository)
	{
		this.curvePointRepository = curvePointRepository;
	}

	@Override
	public Iterable<CurvePoint> getCurvePoints()
	{
		return curvePointRepository.findAll();
	}

	@Override
	public Optional<CurvePoint> getCurvePointById(int id)
	{
		return curvePointRepository.findById(id);
	}

	@Override
	public void createCurvePoint(CurvePoint curvePoint)
	{
		curvePointRepository.save(curvePoint);
	}

	@Override
	public void updateCurvePoint(CurvePoint curvePoint)
	{
		curvePointRepository.save(curvePoint);
	}

	@Override
	public void deleteCurvePoint(CurvePoint curvePoint)
	{
		curvePointRepository.delete(curvePoint);
	}
}
