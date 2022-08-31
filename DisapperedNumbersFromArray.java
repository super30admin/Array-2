// Time Complexity :O(n) where n is the length of nums array
// Space Complexity :O(1) using no extra space
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class DisapperedNumbersFromArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List <Integer> result = new ArrayList<>();

        //null check
        if(nums == null || nums.length == 0)
            return result;

        int n = nums.length;

        for(int i = 0 ; i < n; i++){
            //this is to find out where(which index) to mark -ve
            int idx = Math.abs(nums[i]) - 1;
            // check if number is positive
            if(nums[idx] > 0){
                // if its positive, mark it negative
                nums[idx] *= -1;
            }
        }

        for(int i = 0 ; i < n ; i++){
            if(nums[i] > 0){
                //if number is positive, it means we are missing (index of that +ve elements+1) value in the aaray
                result.add(i+1);
            }
            else
                //if number is -ve, make it positive
                nums[i] *= -1;
        }

        return result;
    }

}