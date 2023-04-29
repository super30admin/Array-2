// Time Complexity : O(n) for both approaches
// Space Complexity : O(n) for HashSet approach and O(1) for the other
// Did this code successfully run on Leetcode : Yes

/*

Approach 1:
We add all elements in the given array to a HashSet and then once again loop from 1 to N and check if any element is missing. If it is, then we add to the result array.

Approach 2:
In order to save space, we reuse the same array to "mark" each element as
present (by making them negative as there may not be negative values in the
given array). In order to mark each element as present, we consider the index
as the actual element, and the value at that index as the index to be marked.
This way, when we loop through this array a second time, indices of all
non-marked elements can be considered as the missing values.

*/

package main

// HashSet approach
func findDisappearedNumbersHashSet(nums []int) []int {
	if len(nums) == 0 {
		return []int{}
	}

	var res []int
	set := map[int]struct{}{}

	// add all elements to set for lookup later
	for _, n := range nums {
		set[n] = struct{}{}
	}

	// lookup and add elements to result if not present in set
	for i := 1; i <= len(nums); i++ {
		if _, ok := set[i]; !ok {
			res = append(res, i)
		}
	}

	return res
}

// space optimized approach
func findDisappearedNumbersSpaceOptimized(nums []int) []int {
	if len(nums) == 0 {
		return []int{}
	}

	var res []int

	// mark each element as found in the array
	for _, n := range nums {
		if n < 0 {
			n *= -1
		}
		if nums[n-1] > 0 { // if it's not already marked
			nums[n-1] *= -1 // making it negative to mark
		}
	}

	// finally, check if anything is non-negative
	for i, n := range nums {
		if n > 0 {
			res = append(res, i+1)
		}
	}

	return res
}
