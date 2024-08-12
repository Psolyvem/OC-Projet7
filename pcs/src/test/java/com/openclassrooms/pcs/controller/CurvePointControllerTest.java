package com.openclassrooms.pcs.controller;

import com.openclassrooms.pcs.controllers.CurveController;
import com.openclassrooms.pcs.domain.CurvePoint;
import com.openclassrooms.pcs.service.ICurvePointService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import java.util.Optional;

import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class CurvePointControllerTest
{
	CurveController curveController;
	@Mock
	ICurvePointService curvePointService;
	@Mock
	Model model;
	@Mock
	BindingResult bindingResult;
	CurvePoint curvePoint;

	@BeforeEach
	public void setUp()
	{
		this.curveController = new CurveController(this.curvePointService);

		this.curvePoint = new CurvePoint();
		curvePoint.setTerm(10.d);
		curvePoint.setValue(10.d);
	}

	@Test
	public void homeTest()
	{
		curveController.home(model);
		verify(curvePointService, times(1)).getCurvePoints();
	}

	@Test
	public void validateTest()
	{
		curveController.validate(curvePoint, bindingResult, model);
		verify(curvePointService, times(1)).createCurvePoint(curvePoint);
	}

	@Test
	public void showUpdateFormTest()
	{
		when(curvePointService.getCurvePointById(1)).thenReturn(Optional.of(curvePoint));
		curveController.showUpdateForm(1, model);
		verify(curvePointService, times(1)).getCurvePointById(1);
	}

	@Test
	public void updateCurvePointTest()
	{
		when(curvePointService.getCurvePointById(1)).thenReturn(Optional.of(curvePoint));
		curveController.updateCurvePoint(1, curvePoint, bindingResult, model);
		verify(curvePointService, times(1)).updateCurvePoint(curvePoint);
	}

	@Test
	public void deleteCurvePointTest()
	{
		when(curvePointService.getCurvePointById(1)).thenReturn(Optional.of(curvePoint));
		curveController.deleteCurvePoint(1, model);
		verify(curvePointService, times(1)).deleteCurvePoint(curvePoint);
	}
}
