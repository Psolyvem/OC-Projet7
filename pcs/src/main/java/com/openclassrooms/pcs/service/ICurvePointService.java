package com.openclassrooms.pcs.service;

import com.openclassrooms.pcs.domain.CurvePoint;

import java.util.Optional;

public interface ICurvePointService
{
	public Iterable<CurvePoint> getCurvePoints();

	public Optional<CurvePoint> getCurvePointById(int id);

	public void createCurvePoint(CurvePoint curvePoint);

	public void updateCurvePoint(CurvePoint curvePoint);

	public void deleteCurvePoint(CurvePoint curvePoint);
}
