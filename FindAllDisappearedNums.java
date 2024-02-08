//Time Complexity = O(n)
//Space Complexity = O(1)
// Does it run on LeetCode successfully?: Yes
// Any difficulties: Clicking logic in an interview is key. I am still able to derive after watching video.

/*
[1...n]
As this problems ask us to find numbers in place and O(n),
we will negate corresponding index number and in second iteration,
we are again negating it back what it was and picking numbers which are still positive after first iterations
and they are our missing numbers from given array.
*/

import java.util.List;
import java.util.LinkedList;

public class FindAllDisappearedNums {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new LinkedList<>();
        if(nums == null) return null;
        int n = nums.length;

        for(int i=0; i<n; i++){ //O(n)
            int idx = Math.abs(nums[i])-1;
            if(nums[idx] > 0) {
                nums[idx]*= -1;
            }
        }

        for(int i=0; i<n; i++){ //O(n)
            if(nums[i] > 0) {
                result.add(i+1);
            }else{
                nums[i] *= -1;
            }
        }
        return result;
    }

    public static void main(String[] args){
        FindAllDisappearedNums obj = new FindAllDisappearedNums();
        int[] nums = {4,3,2,7,8,2,3,1};
        System.out.println("Missing numbers : "+ obj.findDisappearedNumbers(nums));
    }
}