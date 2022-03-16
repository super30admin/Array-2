package main

import (
	"fmt"
)

/*
448. Find All Numbers Disappeared in an Array
Given an array nums of n integers where nums[i] is in the range [1, n],
return an array of all the integers in the range [1, n] that do not appear in nums.


Because the numbers are in the range of 1 - n(lenOfArr)

Approach #1
- We can store all nums in a set first
- then loop over 1-n while checking if this number is in set
- if not in set, add it to our output array as a missing number
- Time: O(N)
- Space: O(N) - worse case if numbers are not missing, we have allocated the same size of the array as a set

Approach #2
- Because the numbers are in the range of 1 - n(lenOfArr)
- this means we all a corresponding index in a sorted array
- For example: number 1 corresponds to index 0 in a sorted array
- We can use this to our advantage and use the input array as a way to indicate we have "seen" a number
- but how can we use input array as a set with the above negating trick?
- The idea is when we are looping over the numbers, we can get this numbers idx by $num-1
- Then we will check if this numbers corresponding idx is already a negative value
- if it is not negative, make it negative and move on
- if it is negative (leave it)
	- This means, this numbers idx has already been seen and marked negative by some other element
- if we mark i+1 number negative, when we get to i+1 idx, then we need to take abs value
	- why? because we have not yet checked whether this number has been seen yet or not, its idx may have seen by some other element
- Finally run 1 more to find all the positive numbers, their idx+1 == missing number
- Time: o(n)
- Space: o(1)
*/

func abs(n int) int {
	if n < 0 {
		return n * -1
	}
	return n
}
func findDisappearedNumbers(nums []int) []int {
	if nums == nil || len(nums) == 0 {
		return nil
	}
	var missingNumbers []int
	for i := 0; i < len(nums); i++ {
		sortedIdx := abs(nums[i]) - 1
		if nums[sortedIdx] < 0 {
			continue
		}
		nums[sortedIdx] *= -1
	}

	for i := 0; i < len(nums); i++ {
		if nums[i] > 0 {
			missingNumbers = append(missingNumbers, i+1)
		}
	}
	return missingNumbers
}

func main() {
	fmt.Println(findDisappearedNumbers([]int{4, 3, 2, 7, 8, 2, 3, 1}))
	fmt.Println(findDisappearedNumbers([]int{2, 2}))
}
