// Before class 
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
//Boolean array for reference to check if the element is present or not
//Extra Boolean array required

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        boolean[] arr =  new boolean[nums.length];
        List<Integer> result = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            arr[nums[i]-1] = true;
        }
        for(int i=0;i<nums.length;i++){
            if(arr[i]==false) result.add(i+1);
        }
        return result;
    }
}

// Before class 
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
// Utilized List result to switch the element at ith index to the original index it should belong in sorted array.
// loop over the list and check what all elements are out of space and that will be our reault

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int i=0;
        List<Integer> result = new ArrayList<>();
        while(i<=nums.length-1){
            if(nums[i] != nums[nums[i]-1]){
                int temp = nums[nums[i]-1];
                nums[nums[i]-1] = nums[i];
                nums[i] = temp;
            }else{
                i++;
            }
        }
        for(int j=0;j<nums.length;j++){
            //System.out.print(nums[j]+" ");
            if(nums[j] != j+1) result.add(j+1);
        }
        return result;
    }
}