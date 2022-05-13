import java.util.*;

/**
 * https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array
 * 
 * time: O(n) + O(n) => O(n)
 * space: O(1)
 * 
 * Approach:
 * 1. Iterate thru the array and make the corresponding index -ve
 *      to record the presence of the element
 *       0  1  2   3  4  5  6  7
 *      [4, 3, 2, -7, 8, 2, 3, 1]
 *       |        |
 *      4-1 = 3 // subtracting 1 as the array is indexed from 0
 *      4 => 3 // thus, number 4 corresponds to the index 3 is marked as present using -ve sign 
 *  
 * 2. Iterate thru the array 
 *      and if -ve make it +ve to preserve the original data of the array
 *      and find the +ve index
 *      the corresponding number to this index will be missing
 *       0    1   2   3  4  5   6  7
 *      [-4, -3, -2, -7, 8, 2, -3, -1]
 *                       |  |
 *      8, 2 are +ve which implies (4+1= 5, 5+1= 6) 5,6 are missing     
 *  
 */
class Problem31 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        
        for(int i = 0; i < nums.length; i++){
            int correspondingIndex = Math.abs(nums[i]) - 1;
            if(nums[correspondingIndex] > 0){
                nums[correspondingIndex] *= -1;                
            }
        }
        
        for(int i = 0; i < nums.length; i++){
            if(nums[i] < 0){
                nums[i] *= -1;
            } else {
                result.add(i+1);
            }
        }
        return result;
    }
}