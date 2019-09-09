Zip Code Range Problem

Problem:

Given a collection of 5-digit ZIP code ranges (each range includes both their upper and lower bounds), 
provide an algorithm that produces the minimum number of ranges required to represent the same restrictions as the input.

This project provides the service to merge the overlapping zip code ranges which are stored for restrictions purposes.

EXAMPLES:
If the input = [94133,94133] [94200,94299] [94600,94699]
Then the output should be = [94133,94133] [94200,94299] [94600,94699]

If the input = [94133,94133] [94200,94299] [94226,94399] 
Then the output should be = [94133,94133] [94200,94399]

SOLUTION:

First converted the input string into ZipCodeRange Objects by breaking it into start of the range and end of the range and then done sorting on the list of the collected objects using comparator. After sorting is done, then comparing if the end of the first range is greater than the start of the second range then it means there is a overlap. So merge the overlap by taking the maximum of the end of the first range and end of the second range.
