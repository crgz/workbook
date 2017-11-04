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

/**
 * @author Conrado M.
 */
public class Statistics
{
	private final long sum;
	private final long max;
	private final long min;
	private final long count;
	private final double avg;

	public Statistics(final long sum, final long count, final long max, final long min, final double avg)
	{
		this.sum = sum;
		this.avg = avg;
		this.max = max;
		this.min = min;
		this.count = count;
	}

	public Statistics()
	{
		this.sum = 0;
		this.avg = 0;
		this.max = 0;
		this.min = 0;
		this.count = 0;
	}

	/**
	 * @return Total sum of uploaded items
	 */
	public long getSum()
	{
		return sum;
	}

	/**
	 * @return Average amount of uploaded items per batch
	 */
	public double getAvg()
	{
		return avg;
	}

	/**
	 * @return Maximum of uploaded items per batch
	 */
	public long getMax()
	{
		return max;
	}

	/**
	 * @return Minimum amount of items per batch
	 */
	public long getMin()
	{
		return min;
	}

	/**
	 * @return the count
	 */
	public long getCount()
	{
		return count;
	}

	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("Statistics [sum=" + String.format("%3d", sum));
		sb.append(", avg=" + String.format("%6.2f", avg));
		sb.append(", max=" + String.format("%3d", max));
		sb.append(", min=" + String.format("%3d", min));
		sb.append(", count=" + String.format("%3d", count) + "]");
		return sb.toString();
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(avg);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + (int) (count ^ (count >>> 32));
		result = prime * result + (int) (max ^ (max >>> 32));
		result = prime * result + (int) (min ^ (min >>> 32));
		result = prime * result + (int) (sum ^ (sum >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
		{
			return true;
		}
		if (obj == null)
		{
			return false;
		}
		if (getClass() != obj.getClass())
		{
			return false;
		}
		Statistics other = (Statistics) obj;
		if (Double.doubleToLongBits(avg) != Double.doubleToLongBits(other.avg))
		{
			return false;
		}
		return count == other.count && max == other.max && min == other.min && sum == other.sum;
	}

}
