//
//  Untitled 2.swift
//  DSA-Practice
//
//  Created by Paridhi Malviya on 1/6/26.
//

/*
trick - Check if we can group numbers in pair.
 */

class MinAndMaxInArray {
    init() {
        findMinAndMax(nums: [100, -100, 3, 1, 8, -4, 6, 7, 9])
        findMinAndMaxByReducingComparisons(nums: [100, -100, 3, 1, 8, -4, 6, 7, 9])
    }
    
    //2n - comparisons
    func findMinAndMax(nums: [Int]) {
        var minimum = Int.max
        var maximum = Int.min
        
        for i in 0..<nums.count {
            if (nums[i] < minimum) {
                minimum = nums[i]
            }
            if (nums[i] > maximum) {
                maximum = nums[i]
            }
        }
        print("min \(minimum) **** max \(maximum)")
    }
    
    //to significantly reducing the no of comparisons from 2n
    //Since we are comparing in pairs, the no of comparisons become 3n/2.
    func findMinAndMaxByReducingComparisons(nums: [Int]) {
        var minimum = Int.max
        var maximum = Int.min
        //compare in pairs. Maximum comparisons per pair is 3
        for i in stride(from: 0, to: nums.count - 1, by: 2) {
            if (nums[i] > nums[i + 1]) {
                maximum = max(maximum, nums[i])
                minimum = min(minimum, nums[i + 1])
            } else {
                maximum = max(maximum, nums[i + 1])
                minimum = min(minimum, nums[i])
            }
        }
        print("by reducing the comparisons maximum \(maximum)")
        print("by reducing the comparisons minimum \(minimum)")
    }
}
