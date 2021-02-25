/* Time: O(n)  + o(n) => O(n)
Space - O(1) in place
*/

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        //null/empty check
        if(nums == null || nums.length == 0) return  result;
        
        //logic
        //mark number at that index -ve
        for(int i = 0; i < nums.length; i++){
            int idx = Math.abs(nums[i]) - 1;
            if(nums[idx] > 0)
                nums[idx] *= -1;
        }
        
        //add the index + 1 of non neg numbers to the list 
        for(int i = 0; i < nums.length; i++){
            //System.out.println(nums[i]);
            if(nums[i] > 0)
                result.add(i + 1);
        }
        
        return result;
    }
}