// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
/*
loop through elements and set the value of index-1 matching current element to negative
loop through elements again and add all the index + 1 of positive elements
return list
*/
package main

import "fmt"

func findDisappearedNumbers(nums []int) []int {
	list := []int{}
	for i:=0;i<len(nums);i++ {
		if nums[abs(nums[i]) - 1] > 0 {
			nums[abs(nums[i]) - 1] *= -1
		}
	}
	for i:=0;i<len(nums);i++ {
		if nums[i] > 0 {
			list = append(list, i + 1)
		}
	}
	return list
}

func abs(a int) int {
	if a < 0 {
		return a*-1
	}
	return a
}

func MainDisappeared() {
	fmt.Println(findDisappearedNumbers([]int {4,3,2,7,8,2,3,1})) //expected [5,6]
}
