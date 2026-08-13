import java.util.*;

//Approach: The idea is to calculate the index of the current element and making the element in that index to negative.
//At the end, iterate through the array to find if there are any positive elements in the original array and add them
// to the result.

//Time Complexity : O(2n)
//Space Complexity: O(1)

class DisappearedNumbers {
    public List<Integer> findDisappearedNumbers(int[] nums) {

        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < nums.length; i++)
        {
            int idx = Math.abs(nums[i]) - 1;
            if (nums[idx] > 0){
                nums[idx]*= -1;
            }
        }

        for(int i=0; i<nums.length; i++){
            if(nums[i] > 0){
                ans.add(i+1);
            }
        }

        return ans;
    }
}
