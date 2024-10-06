// Time Complexity : O(2n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

public class Solution {
    public IList<int> FindDisappearedNumbers(int[] nums) {
        int n = nums.Length;
        List<int> result = new List<int>();
        for(int i=0; i<n;i++){
            int num = nums[i]; //get the number at each index 
            int idx = Math.Abs(num) -1; //get that index by substracting -1 from num
           
           if(nums[idx]>0){
            nums[idx] = nums[idx] * -1; //alraedy available number into -1

           }
            
            
        }
        for(int i=0; i<n; i++){
                if(nums[i] < 0){
                    nums[i] *= -1;

                }
                else{
                   result.Add(i+1); //if a num is +ve, the missing element would be index+1
                }
        }
        return result;
        
    }
}