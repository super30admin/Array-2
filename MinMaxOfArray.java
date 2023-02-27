public class MinMaxOfArray {
    public int[] maxMinArray(int[] nums){
        int n = nums.length;
        int l = 0;
        int r = 1;
        while(r<n){
            if(nums[l]>nums[r]){
                max = Math.max(max,nums[l]);
                min = Math.min(min,nums[r]);
            }else{
                max = Math.max(max,nums[r]);
                min = Math.min(min,nums[l]);
            }
            l+=2;
            r+=2;
        }
        if(n%2!=0){
            max = Math.max(max,nums[l]);
            min = Math.min(min,nums[l]);
        }
        return new int[] {min,max};
    }
}

// TC - O(n)
// SC - O(1)