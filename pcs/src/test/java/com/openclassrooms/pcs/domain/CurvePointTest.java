package com.openclassrooms.pcs.domain;

import org.junit.jupiter.api.Test;

import java.sql.Timestamp;

public class CurvePointTest
{
	CurvePoint curvePoint;
	@Test
	void curvePointTest()
	{
		this.curvePoint = new CurvePoint();
		curvePoint.setId(1);
		curvePoint.setCurveId(1);
		curvePoint.setAsOfDate(new Timestamp(2000));
		curvePoint.setTerm(1.d);
		curvePoint.setValue(1.d);
		curvePoint.setCreationDate(new Timestamp(2000));

		curvePoint.getId();
		curvePoint.getCurveId();
		curvePoint.getAsOfDate();
		curvePoint.getTerm();
		curvePoint.getValue();
		curvePoint.getCreationDate();
	}
}
