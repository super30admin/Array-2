//Time Complexity: O(n)
//Space Complexity: O(n)
//Did it run on leetcode: Yes
//Problems faced any: No


import java.util.ArrayList;
import java.util.List;

public class Problem30 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        if(nums==null || nums.length==0)
            return new ArrayList<>();

        //boolean array to keep track of elements
        boolean[] arr =  new boolean[nums.length+1];

        arr[0] = true;

        for(int i=0; i<nums.length; i++){
            arr[nums[i]] = true;
        }

        List<Integer> result = new ArrayList<>();

        for(int i=1; i<arr.length; i++){
            if(arr[i]!=true)
                result.add(i);
        }

        return result;
    }
}
