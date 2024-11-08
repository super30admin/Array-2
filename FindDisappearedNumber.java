// Time Complexity :isIsomorphic: O(2n)=O(n) , n is  number of characters in the string
// Space Complexity :0(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : nothing

import java.util.ArrayList;
import java.util.List;

public class FindDisappearedNumber {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer>  result = new ArrayList<>();

        for(int i=0; i<nums.length; i++){
            int index= Math.abs(nums[i])-1;
            if(nums[index]>0){
                nums[index] *= -1;
            }
        }

        for(int i=0; i<nums.length; i++){
            if(nums[i]<0){
                nums[i] *= -1;
            } else{
                result.add(i+1);
            }
        }
        return result;
    }

    public static void main(String args[]) {
        FindDisappearedNumber find= new FindDisappearedNumber();
        int[] nums= {4,3,2,7,8,2,3,1};
        System.out.println("missing numbers "+find.findDisappearedNumbers(nums));

    }
}
