
// Idea is to use hashset to store the nums in a hashset and iterate over the numbers from 1 to n
// and check if the number is absent in Hashset and add it to the result.
// Time Complexity : O(n)
// Space Complexity : O(n)
import java.util.HashSet;

class Solution{
    public List<Integer> findDisappearedNumbers(int[] nums){

        List<Integer> result = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();

        int n = nums.length;

        for(int i=0;i<n;i++)
        {
            set.add(nums[i]);
        }

        for(int i=1;i<=n;i++){
            if(!set.contains(i)){
                result.add(i);
            }
        }

        return result;
    }
}