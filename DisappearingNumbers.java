// Time Complexity - O(n)
//Space - O(1)
//The approach is to go over each element in the array and take the index as value - 1. 
//Go to the index and negate the element if it is positive. 
//Go over entire array and find the positive numbers, add 1 to the index to find the misisng number. 
import java.util.*;
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {

        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < nums.length; i++){
            int index = Math.abs(nums[i]) - 1;  //If number is negative, we still need the index to be +ve. 
            if(nums[index] > 0){
                nums[index] = nums[index] * -1;
            }
        }
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0){
                list.add(i + 1);

            }
            else{
                nums[i] = nums[i] * -1;
            }
        
    }
    return list;
}
}