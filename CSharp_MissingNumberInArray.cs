
public class Solution {
    public IList<int> FindDisappearedNumbers(int[] nums) {
        
        IList<int> result = new List<int>();
        
        //ArrayList result = new ArrayList<int>();
        int n = nums.Length;
        
        //base case
        if(n==0) return result; //shows invalid case
        
        for(int i = 0; i < n ; i++)
        {
           int idx = Math.Abs(nums[i]) -1;
            
            if(nums[idx] > 0)
            {
                nums[idx] *= -1;
            }
        }
        
        //traverse through array to find the POSITIVE number, add it to result, and revert array back.
        
        for(int i =0; i<n; i++)
        {
            if(nums[i] > 0)
                //((List<int>)myList)
                result.Add(i+1);
            else
                nums[i] *= -1;
        }
        return result;
    }
}
//TC: O(n) - 2 pass
//SC: O(1)
