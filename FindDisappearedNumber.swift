// Time Complexity : (O)n
// Space Complexity : (O)1
// Did this code successfully run on Leetcode : yes
//get abs index value of the array and multiply by -1.
//second iteration find the positive value index to get the missing number



class Solution {
    func findDisappearedNumbers(_ nums: [Int]) -> [Int] {
        //edge
        if nums.isEmpty {
            return nums
        }
        //logic
        let length = nums.count
        var numbers = nums
        //go to index of the array and get abs value and multiply by -1 for the value
        for i in 0..<length {
            let valueIndex = (abs(numbers[i])-1)
            numbers[valueIndex] = abs(numbers[valueIndex]) * -1
        }
        //result
        var result = [Int]()
        for i in 0..<length {
            if numbers[i] > 0 {
              result.append(i+1)
            }
        }
        return result
    }
}