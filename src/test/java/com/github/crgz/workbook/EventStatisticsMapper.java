/*******************************************************************************
 * Copyright 2017 m
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License.  You may obtain a copy
 * of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations under
 * the License.
 ******************************************************************************/
package com.github.crgz.workbook;

import java.util.AbstractMap.SimpleEntry;

/**
 * @author Conrado M.
 */
public class EventStatisticsMapper
{
	public static SimpleEntry<Event, Statistics> map(Object[] x)
	{
		final long time = ((Double) x[0]).longValue();
		final int value = ((Double) x[1]).intValue();
		final long sum = ((Double) x[3]).longValue();
		final long count = ((Double) x[4]).longValue();
		double avg = (double) sum / count;
		final long max = ((Double) x[5]).longValue();
		final long min = ((Double) x[6]).longValue();
		return new SimpleEntry<Event, Statistics>(new Event(time * 1000, value), new Statistics(sum, count, max, min, avg));
	}
}
