// Time Complexity :O(n) --> beacuse of for loop
// Space Complexity :1
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
//
import java.util.ArrayList;
import java.util.List;

public class disappearedNumbers {
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<Integer>();
        for(int i = 0;i<nums.length;i++){
            int x = Math.abs(nums[i])-1;
            if(nums[x]>0)
                nums[x] = -nums[x];
        }
        for(int i = 0;i<nums.length;i++){
            if(nums[i]>0)
                list.add(i+1);
        }

        return list;
    }
    public static void main(String[] args) {
        int [] nums = {4,3,2,7,8,2,3,1};
        System.out.println(findDisappearedNumbers(nums));
    }
}
