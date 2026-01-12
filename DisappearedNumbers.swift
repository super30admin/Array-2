//
//  FindDisappearedNumbers.swift
//  DSA-Practice
//
//  Created by Paridhi Malviya on 1/10/26.
//

/*
 Range = 1-8
 array = [4,3, 7, 2,8, 2, 3, 1]
 prerequisite -> we will be having range which is equal to the length of array.
 temporary state change.
 
 hash set under the hood is a boolean array only.
 I f I want to record if 4 is present in the array, go to it's corresponding index i.e. 3 and if the number is not negative over there, make it negative. Index 3 being -ve tells that the number 4 is inside the array.
 check if 3 is present in tht array, got to it's corresponding index i.e. 2 and make it negative if it's non-negative.
 while iterating to check for a value, take absolute value.
 in-place marking.
 No extra space. space complexity - O(1)
 time complexity -> O(n)
 It's just a temporary state change.
 At 2nd pass, we will check if the number is -ve, then the (index corresoping to the no + 1) is the number present in the array. During 2nd pass, can make the number positive to convert it back to the original array.
 
 range - (upper no - lower no) + 1
 
 Above algorithm can work for -nve numbers presence in array as well.
 array - [0, -1, 3, -2, 4, -2, -1, -3]
 add offset of 4 to the elements of above array. [4, 3, 7, 2, 8, 2, 3, 1] -> then can solve it and by in-place marking of -ve.  can convert it back to original array.
 */

class FindDisappearedNumbers {
    
    init() {
        let disapparedNums = findDisappearedNumber()
        print("disappeared numbers \(disapparedNums)")
    }
    
    //time complexity - O(n), space complexity - O(1)
    func findDisappearedNumber() -> [Int] {
        var input = [4, 3, 2, 7, 8, 2, 3, 1]
        var result = [Int]()
        //forward pass. marking the negative
        for i in 0..<input.count {
            let idx = abs(input[i]) - 1
            if (input[idx] > 0) {
                input[idx] *= -1
            }
        }
        
        //find out
        for i in 0..<input.count {
            if (input[i] > 0) {
                //since it's positive, this (index + 1)'s number is not present in the array
                result.append(i + 1)
            } else {
                //convert it back to the original number
                input[i] *= 1
            }
        }
        return result
    }
}

