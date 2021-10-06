// Time Complexity : 0(n)
// Space Complexity : 0(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
    func findDisappearedNumbers(_ nums:  [Int]) -> [Int] {
    var nums = nums
    var output = [Int]()
       for i in 0..<nums.count {
           if nums[abs(nums[i])-1] > 0 {
               nums[abs(nums[i])-1] = -nums[abs(nums[i])-1]
           }
       }
       for i in 0..<nums.count {
           if nums[i] > 0 {
               output.append(i+1)
           }
       }
        return output
    }