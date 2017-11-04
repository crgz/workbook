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

import java.time.Instant;

public class Event  implements Comparable<Event>
{
	private final Instant instant;
	private final int count;
	
	public Event(long timestamp, int count)
	{
		this.instant = Instant.ofEpochMilli(timestamp);
		this.count = count;
	}

	public Event(Instant instant, int count)
	{
		this.instant = instant;
		this.count = count;
	}

	public Event()
	{
		this.instant = Instant.MAX;
		this.count = Integer.MAX_VALUE;
	}

	/**
	 * @return the instant
	 */
	public Instant getInstant()
	{
		return instant;
	}

	/**
	 * @return the count
	 */
	public int getCount()
	{
		return count;
	}

	@Override
	public String toString()
	{
		return this.instant + " ->" + String.format("%3d", getCount());
	}

	@Override
	public int compareTo(Event otherInstant)
	{
		return this.instant.compareTo(otherInstant.instant);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + count;
		result = prime * result + ((instant == null) ? 0 : instant.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
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
		Event other = (Event) obj;
		if (count != other.count)
		{
			return false;
		}
		if (instant == null)
		{
			if (other.instant != null)
			{
				return false;
			}
		}
		else if (!instant.equals(other.instant))
		{
			return false;
		}
		return true;
	}

}
