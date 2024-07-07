// Time Complexity : O(n)
// Space Complexity : O(1)

/* To reduce number of comparisons, we can first compare current element
 with the next element, then we compare the smaller of these two with the current min,
and the larger of these two with the max. We do 3 comparisons for each pair, totalling 3n/2 comparisons */


public class MaxnMin {

    public int[] mincom(int[] nums){
        int min = nums[0];
        int max = nums[0];

        for(int i=1;i<nums.length-2;i=i+2){
            if(nums[i]<nums[i+1]){
                min=Math.min(min, nums[i]);
                max=Math.max(max, nums[i+1]);
            }else{
                min=Math.min(min, nums[i+1]);
                max=Math.max(max, nums[i]);
            }
        }
    }
}
