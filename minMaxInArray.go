// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

/*

Approach:
This problem finds the min and max in an array. We need to do a linear search
(1 traversal is required at minimum). However, to optimize the number of
comparisons, we compare pairs of elements at a time. This will reduce the
number of comparisons from 4 to 3 for every 2 elements since we're only
comparing max with the greater of the 2 and the min with the lesser of the two.

*/

package main

import (
	"fmt"
)

func main() {
	// find min and max of array
	// follow up: try and do in 2*(n-2) comparisons
	tc := []int{4, 1, -1, 0, 0, 3, 12, 56, -42, 561, 1000}
	minV, maxV := minMax(tc)
	fmt.Printf("Min %v, Max %v", minV, maxV)
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}

func min(a, b int) int {
	if a < b {
		return a
	}
	return b
}

func minMax(a []int) (int, int) {
	n := len(a)

	if n == 0 {
		return 0, 0
	}

	if n == 1 {
		return a[0], a[0]
	}

	minV := a[0]
	maxV := a[0]

	for i := 1; i < n-1; i += 2 {
		if a[i] > a[i+1] {
			maxV = max(maxV, a[i])
			minV = min(minV, a[i+1])
		} else {
			maxV = max(maxV, a[i+1])
			minV = min(minV, a[i])
		}
	}

	if n%2 != 0 {
		minV = min(minV, a[n-1])
		maxV = max(maxV, a[n-1])
	}

	return minV, maxV
}
