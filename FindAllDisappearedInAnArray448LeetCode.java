//Time Complexity : O(n)
//Space Complexity : O(1)
//didn't face any problems
//runs successfully

import java.util.ArrayList;
import java.util.List;

public class FindAllDisappearedInAnArray448LeetCode {

    public List<Integer> findDisappearedNumbers(int[] nums) {

        List<Integer> list = new ArrayList<>();                         //output list
        for(int i=0; i<nums.length;i++){                                //iterating through array

            int index = Math.abs(nums[i]);                              //taking absolute value of element

            //we are going to find the value as a index, then we are taking index-1 value because the values are present starting from 1 and index is starting from 0
            int value = nums[index-1];
            if(value>0){                                                //if that value is greater zero means we are visiting the first time
                nums[index-1] = -nums[index-1];                         // then we have to set it to negative means that that index value is present in the array
            }

        }

        for(int i=0;i<nums.length;i++){                                 //iterating through array
            if(nums[i]>0){                                              //check if any value is greater zero
                list.add(i+1);                                          //if yes, then it means that this index value is not present in the array and we add those indexes to the output list
            }
        }

        return list;
    }
}

