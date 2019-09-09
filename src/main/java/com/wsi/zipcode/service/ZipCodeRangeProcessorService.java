package com.wsi.zipcode.service;

import java.util.ArrayList;
import java.util.List;
import com.wsi.zipcode.model.ZipCodeRange;

/**
 * 
 * @author Prashant
 *
 *         This class is a starting point for doing processing on the zip code
 *         ranges which calls it's utility methods to carry out the task
 */

public class ZipCodeRangeProcessorService {
	private List<ZipCodeRange> zipCodeRangeList;
	private List<ZipCodeRange> mergedList;

	/**
	 * Constructor
	 */
	public ZipCodeRangeProcessorService() {
		zipCodeRangeList = new ArrayList<ZipCodeRange>();
	}

	/**
	 * Method to process and provide final output with merged overlapping
	 * ZipCode Ranges.
	 * 
	 * @param input String
	 * @return output String
	 */

	public String processZipCodeRangeList(String input) throws Exception {
		if (input == null || input.length() == 0) {
			throw new IllegalArgumentException("Invalid input");
		}
		String[] args = input.split(" ");
		StringBuilder sb = new StringBuilder();
		for (String arg : args) {
			zipCodeRangeList.add(ZipCodeRangeProcessorUtil
					.getZipCodeRangeFromInput(arg));
		}
		mergedList = ZipCodeRangeProcessorUtil.mergeZipCodeRanges(zipCodeRangeList);
		for (ZipCodeRange zipCodeRange : mergedList) {
			sb.append(zipCodeRange.toString()).append(" ");
		}
		return sb.toString().trim();
	}
}