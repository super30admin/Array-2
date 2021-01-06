// TC: O(2N) - O(N) - nums.length
// SC: O(1) 
// Did it run successfully on Leetcode? : Yes
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int N = nums.length;
        List<Integer> result = new ArrayList();
      
        if ( nums == null || N == 0)
           return result;  
        
        for ( int i = 0; i < N; i++)
        { 
            int index = Math.abs(nums[i]) -1 ;
            if (nums[index] > 0)
                nums[index] *= -1;
        }
        for (int i = 1; i <= N; i++)
        {
            if (nums[i-1] > 0)
                result.add(i);
        }
        
        return result;
    }
}


// TC: O(2N) - O(N) - nums.length
// SC: O(M) - M unique no.s in nums array
// Did it run successfully on Leetcode? : Yes
// class Solution {
//     public List<Integer> findDisappearedNumbers(int[] nums) {
//         List<Integer> result = new ArrayList();
//         if ( nums == null || nums.length == 0)
//            return result; 
//         int N = nums.length;
//         HashSet<Integer> set = new HashSet<Integer>();
       
//         for (int num : nums)
//         {
//             set.add(num);
//         }
//         for (int i = 1; i <= N; i++)
//         {
//             if (!set.contains(i))
//                 result.add(i);
//         }
//         return result;
//     }
// }
