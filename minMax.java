// Time Complexity : o(n)
// Space Complexity :o(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// beauty of this is we are able to do this in 3 * n/2 (1.5n compared to 2n if this trick isnt used ) comparisons! where n is length of array
// say array size is 6 ---> we did it in 9 comparisons ! 

// Your code here along with comments explaining your approachpublic class minMax {
    public int[] minMax(int[] nums) {
        int min = 0, max = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > nums[i + 1]) {
                max = Math.max(max, nums[i]);
                min = Math.min(min, nums[i + 1]);
            }
            else {
                max = Math.max(max, nums[i + 1]);
                min = Math.min(min, nums[i]);
            }
        }
        return new int[]{max, min};
    }
    
}
