package main

/*
   approach: brute force
   - We can go over all nums and store them in a set, while keeping a max available
   - Now once we have a max, we will loop over range 1 to max ( inclusive )
   - If a number does not exist in our set, thats a missing number, add to result array

   time : o(n) + o(maxNumber)
   space: o(n) for the set


   approach: sort and linear scan
   time: o(nlogn)
   space: o(1)


   approach: negative marking - space optimized
   - Since the numbers are guranteed to be within 1 to n
   - where n is len of the array
   - We can use negative marking trick.
   - we will loop over nums array, and
   - for each num, we will take its abs value and;
       - find its correct idx ( the correct sorted idx of a number is number-1)
       - then mark the value at the correct idx negative if its not already negative
       - skip changing the value if the value is already negative
   - Then loop over nums array again
   - Any number thats not marked negative, that idx position + 1 is a missing number in range 1 to maxNumber
   - Save each number like above in result array
   - return result array at the end

   time: o(n)
   space: o(1)
*/
func findDisappearedNumbers(nums []int) []int {
	for i := 0; i < len(nums); i++ {
		num := abs(nums[i])
		idx := num - 1
		if nums[idx] < 0 {
			continue
		}
		nums[idx] *= -1
	}
	out := []int{}
	for i := 0; i < len(nums); i++ {
		if nums[i] > 0 {
			out = append(out, i+1)
		}
	}
	return out
}

func abs(x int) int {
	if x < 0 {
		return x * -1
	}
	return x
}
