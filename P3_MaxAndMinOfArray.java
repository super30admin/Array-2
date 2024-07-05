/*
 TC: O(n)
 SC: O(1)
 Did this code successfully run on Leetcode :yes
 Approach: 

 */

 class P3_MaxAndMinOfArray {
    static int[] maxmin(int[] nums) {
        int max = -9999;
        int min = 9999;
        for(int i=0; i<nums.length-1 ; i +=2) { //0 1
            if(nums[i] < nums[i+1]) {
                if(nums[i] < min) {
                    min = nums[i];
                }
                if(nums[i+1] > max) {
                    max = nums[i+1];
                }
            } else {
                if(nums[i] < nums[i+1]) {
                    if(nums[i+1] < min) {
                        min = nums[i];
                    }
                    if(nums[i] > max) {
                        max = nums[i+1];
                    }
                }
            }
        }
        return new int[] {min, max};
    }

    public static void main(String[] args) {
        int[] arr = new int[] {2,1,4,3,5,6,8,9,11};
        int[] res = maxmin(arr);
        System.out.println(res[0]);
        System.out.println(res[1]);
    }
 }