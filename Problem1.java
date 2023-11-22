// Time Complexity : O(m * n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes 
// Any problem you faced while coding this :

import java.util.ArrayList;
import java.util.List;

public class Problem1 {
        public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<Integer>();
        
        for(int i = 0; i < nums.length; i++){
            int number = Math.abs(nums[i]);
            int index = number-1;
            if(nums[index] > 0){
                nums[index]*= -1;
            }
        }
        
        for(int i = 0; i < nums.length; i++){
           if(nums[i] > 0){
               list.add(i+1);
           }else{
               nums[i]*=-1;
           }
        }
        return list;
    }


        public static void main(String[] arg) {
        int[] nums = new int[]{3,3,2,1,4,5,6,4};
        List<Integer> result = findDisappearedNumbers(nums);

        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
