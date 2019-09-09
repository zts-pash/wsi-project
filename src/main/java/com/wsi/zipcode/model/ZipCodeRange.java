package com.wsi.zipcode.model;

/**
 * 
 * @author Prashant
 *
 */
public final class ZipCodeRange {

	private final int start;
	private final int end;

	/**
	 * Parameterized Constructor
	 * 
	 * @param start
	 * @param end
	 */
	public ZipCodeRange(int start, int end) {
		this.start = start;
		this.end = end;
	}

	/**
	 * 
	 * @return int
	 */
	public int getStart() {
		return start;
	}

	/**
	 * 
	 * @return int
	 */
	public int getEnd() {
		return end;
	}

	/**
	 * 
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + end;
		result = prime * result + start;
		return result;
	}

	/**
	 * 
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ZipCodeRange other = (ZipCodeRange) obj;
		if (end != other.end)
			return false;
		if (start != other.start)
			return false;
		return true;
	}

	/**
	 * 
	 */
	@Override
	public String toString() {
		return "[" + start + "," + end + "]";
	}
}
