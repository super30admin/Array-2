/*
Time Complexity -->
O(n) since we are looping through the array once

Space Complexity -->
O(1)
*/

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        ArrayList<Integer> arr = new ArrayList<>();
        int val = 0;
        int n = nums.length-1;
        for(int i=0;i<nums.length;i++){
            
            val = nums[i]<0?nums[i]*-1:nums[i];
            if(nums[val-1]<0){
               continue;
            }//if
            else{
                nums[val-1]=nums[val-1]*-1;
            }
            
        }//for
        
        for(int i=0;i<nums.length;i++){
            if (nums[i]>0) arr.add(i+1);
        }//for
        
        return arr;
        
    }// public
}//class