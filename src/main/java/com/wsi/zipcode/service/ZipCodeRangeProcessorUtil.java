package com.wsi.zipcode.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.wsi.zipcode.model.ZipCodeRange;

/**
 * 
 * @author Prashant
 *
 *         This is a utility class which provides methods to conduct operations
 *         on a given String or given list of ZipCodeRange Objects
 */
public class ZipCodeRangeProcessorUtil {

	/**
	 * Method to retrieve ZipCodeRange Object from the input String
	 * 
	 * @param zipCodeRange String
	 * @return ZipCodeRange Object
	 */
	public static ZipCodeRange getZipCodeRangeFromInput(String zipCodeRange) {
		String[] range = zipCodeRange.split(",");
		return new ZipCodeRange(Integer.valueOf(range[0].substring(1)),
				Integer.valueOf(range[1].substring(0, range[1].length() - 1)));
	}

	/**
	 * Method to merge overlapping Zip code ranges
	 * 
	 * @param ZipCodeRange List
	 * @return merged overlapping ZipCodeRange List
	 */
	public static List<ZipCodeRange> mergeZipCodeRanges(
			List<ZipCodeRange> rangeList) {
		ZipCodeRange mergedRange;
		ZipCodeRange previousRange;
		List<ZipCodeRange> result = new ArrayList<ZipCodeRange>();

		if (rangeList == null || rangeList.size() == 0) {
			return result;
		}

		/** Alternate way :
		 * Collections.sort(rangeList, (a, b) -> Integer.compare(a.getStart(), b.getStart()));
		 */
		Collections.sort(rangeList,
				Comparator.comparing((ZipCodeRange itl) -> itl.getStart()));

		previousRange = rangeList.get(0);

		for (ZipCodeRange currentRange : rangeList) {
			/** normal scenario, no overlapping found so just add the object to the list as it is */
			if (previousRange.getEnd() < currentRange.getStart()) {
				result.add(previousRange);
				previousRange = currentRange;
			} else {
				/** found overlapping ranges, so merge the ranges together */
				mergedRange = new ZipCodeRange(previousRange.getStart(),
						Math.max(previousRange.getEnd(), currentRange.getEnd()));
				previousRange = mergedRange;
			}
		}
		result.add(previousRange);
		return result;
	}

}
