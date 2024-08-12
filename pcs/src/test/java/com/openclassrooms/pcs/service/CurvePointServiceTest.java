package com.openclassrooms.pcs.service;

import com.openclassrooms.pcs.domain.CurvePoint;
import com.openclassrooms.pcs.repositories.CurvePointRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class CurvePointServiceTest
{
	ICurvePointService curvePointService;
	@Mock
	CurvePointRepository curvePointRepository;
	CurvePoint curvePoint;

	@BeforeEach
	public void setUp()
	{
		this.curvePointService = new CurvePointService(this.curvePointRepository);

		this.curvePoint = new CurvePoint();
		curvePoint.setTerm(10.d);
		curvePoint.setValue(10.d);
	}

	@Test
	public void getCurvePointsTest()
	{
		curvePointService.getCurvePoints();
		verify(curvePointRepository, times(1)).findAll();
	}

	@Test
	public void getCurvePointByIdTest()
	{
		curvePointService.getCurvePointById(1);
		verify(curvePointRepository, times(1)).findById(1);
	}

	@Test
	public void createCurvePointTest()
	{
		curvePointService.createCurvePoint(curvePoint);
		verify(curvePointRepository, times(1)).save(curvePoint);
	}

	@Test
	public void updateCurvePointTest()
	{
		curvePointService.updateCurvePoint(curvePoint);
		verify(curvePointRepository, times(1)).save(curvePoint);
	}

	@Test
	public void deleteCurvePointTest()
	{
		curvePointService.deleteCurvePoint(curvePoint);
		verify(curvePointRepository, times(1)).delete(curvePoint);
	}
}
