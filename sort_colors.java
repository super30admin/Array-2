//BRUTE FORCE
//TC: O(n)
//SC: O(k) k is number of colours (for Hashset or array)
//leetcode : successful
class Solution {
    public void sortColors(int[] nums) {
        int [] arr = new int[3];
        if(nums==null || nums.length==0)
            return;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0)
                arr[0] = arr[0]+1;
            else if(nums[i]==1)
                arr[1] = arr[1]+1;
            else if(nums[i]==2)
                arr[2] = arr[2]+1;
        }
        int i=0;
            int count =0;
            for(i=0;i<arr[0];i++){
                nums[i] =  0;
                count++;
            }
            for(i=count;i<arr[1]+arr[0];i++){
                nums[i] =  1;
                count++;
            }
            for(i=count;i<arr[2]+arr[1]+arr[0];i++){
                nums[i] =  2;
                count++;
            }
        
        for(i=0;i<nums.length;i++){
                System.out.print(nums[i]);
            }
        return;
    }
}

//TC: O(n)
//SC: O(1) 
//leetcode : successful
//Approach: trying to swap the O elements to the start and incrementing the index value
// swapping the 2 elements to the end and decrementing the end point
class Solution {
    public void sortColors(int[] nums) {
        int mid=0, start=0, end = nums.length-1;
        while(mid<=end){
            if(nums[mid]==0){
                int temp = nums[mid];
                nums[mid] = nums[start];
                nums[start] = temp;
                mid++;
                start++;
            }
            else if(nums[mid]==1)
                mid++;
            else
            {
                int swap = nums[end];
                nums[end] = nums[mid];
                nums[mid] = swap;
                end--;
            }
        }
 return;       
    }
}

