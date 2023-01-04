package main

// https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/

// Time : 2xO(n)
// Space : O(1) - no auxiliary space is being used
func findDisappearedNumbers(nums []int) []int {

	// results
	result := []int{}

	// 1 pass
	for i := 0; i < len(nums); i++ {
		// get the number at index i
		n := nums[i]
		if n < 0 {
			n = n * -1 // make it positive
		}
		// n-1 is the index, I want to flip to negative
		idx := n - 1
		if nums[idx] > 0 {
			nums[idx] = nums[idx] * -1 // edge case, can be that its already negative as it has appared in the array before
		}
	}

	// 2nd pass - find which element is not negative
	for i := 0; i < len(nums); i++ {
		if nums[i] < 0 {
			continue
		}
		num := i + 1 // index plus 1 - as index for number 4 is 3 - corresponding number at a given index is index+1 in a sorted array
		result = append(result, num)
	}
	return result

}

func main() {
	findDisappearedNumbers([]int{4, 3, 2, 7, 8, 2, 3, 1})
}
