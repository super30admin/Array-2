// Time Complexity :  O(N)
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

func findDisappearedNumbers(nums []int) []int {
    if len(nums) == 0{
        return []int{}
    }
    
    result := []int{}
    
    for i:=0;i<len(nums);i++{
        index := int(math.Abs(float64(nums[i])))-1
        if nums[index] > 0{
            nums[index] = nums[index] * -1
        }
    }
    
    for key,val := range nums{
        if val > 0{
            result = append(result,key+1)
        }
    }
    
    return result
}

