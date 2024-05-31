/*
 * TC - O(n)
 * SC - O(1)
 */


class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = n -1;
        int mid = left;

        while(mid <= right){
            if(nums[mid] == 2){
                swap(nums, mid, right);
                right--;
            } else if(nums[mid] == 0){
                swap(nums, mid, left);
                left++;
                mid++;
            } else{
                mid++;
            }
        }
    }

    public void swap(int[] nums, int i, int j){
        int temp = 0;
        temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}