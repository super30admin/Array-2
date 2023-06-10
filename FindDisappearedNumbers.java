// Time Complexity : O(n) as we traverse the array only once linearly
// Space Complexity : O(1) no auxiliary space used
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

import java.util.ArrayList;
import java.util.List;

class FindDisappearedNumbers {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        if(nums == null || nums.length < 1){
            return null;
        }

        List<Integer> missingNumbers = new ArrayList<>();
        int i =0;
        while(i < nums.length){

            int current = nums[i];
            //put it at it's correct index (current -1)
            if(nums[current-1] != current){
                swap(i, current-1, nums);
            }else{
                if(current-1 == i){
                    i++;
                }else if(i < nums.length){
                    nums[i] = 0;
                }
            }
            if(i < nums.length && nums[i] == 0){
                i++;
            }
        }

        //now iterate through the array and the find the indices where val is 0
        for(int index = 0; index< nums.length; index++){

            if(nums[index] == 0){
                missingNumbers.add(index+1);
            }
        }
        return missingNumbers;
    }

    private void swap(int i , int j, int[] nums){

        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


}