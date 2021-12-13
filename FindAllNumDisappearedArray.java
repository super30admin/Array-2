// Time Complexity : O(n)
// Space Complexity : O(1)
public class FindAllNumDisappearedArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        if(nums == null || nums.length == 0)
            return new ArrayList<>();
        
        List<Integer> result = new ArrayList<>();
        // since we are supposed to have all the number in array equal to idx's
        // mark num-1 = idx as visited
        for(int i = 0 ; i < nums.length ; i ++)
        {
            // mark this idx visited
            int idx = Math.abs(nums[i]) - 1;    
            if(nums[idx] < 0)
            {
                // this is already visited
            }
            else
            {
                nums[idx] = -1 * nums[idx];
            }
        }
        
        // an non -ve no is the idx that we never found
        for(int i = 0 ; i < nums.length; i++)
        {
            if(nums[i] > 0)
                result.add(i+1);
        }
        
        return result;
    }
}