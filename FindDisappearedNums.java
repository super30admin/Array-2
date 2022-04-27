import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Time Complexity : O(n) n is number of elements in nums
// Space Complexity : O(n) as I'm using an aux array of length n
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach: map the elements in an array
// then check the array for missing values; add to resulting list

public class FindDisappearedNums {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int[] arr = new int[nums.length+1];
        Arrays.fill(arr, -1);
        for(int n : nums){
            arr[n] = 1;
        }
        for(int i=0; i< arr.length; i++){
            if(arr[i] == -1) res.add(i);
        }
        res.remove(0);
        return res;
    }
}
