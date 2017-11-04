package com.github.crgz.workbook;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.Collection;
import java.util.concurrent.atomic.LongAdder;

import org.junit.Before;
import org.junit.Test;

public class WorkbookDataTest {
	private Collection<Object[]> data;

	@Before
	public void setUp() throws IOException, WorkbookDataException {
		this.data = new WorkbookData.Builder("src/test/resources/sample.xls").sheet(0).build().collection();
	}

	@Test
	public void testSum() throws IOException, WorkbookDataException {
		final LongAdder sum = new LongAdder();
		this.data.stream().map(EventStatisticsMapper::map).forEach(x -> sum.add(x.getValue().getSum()));
		assertEquals(948, sum.sum());
	}
}
