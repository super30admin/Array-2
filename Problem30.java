// Time Complexity : O(n)
// Space Complexity: O(1)

// Approach:
//     Loop thorugh the array, where i point to 0th index element & j to array.length-1 index element
//     Compare both the elements present at ith & jth index
//     if arr[i]<arr[j] move the ith element; else j--;

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        
        List<Integer> list = new ArrayList<>();
        
        for(int i =0; i<nums.length; i++){
            int n = Math.abs(nums[i]);
            if(n>0 && nums[n-1]>0) nums[n-1] *= -1;
        }
        
        for(int i = 0; i<nums.length; i++){
            if(nums[i]>0) list.add(i+1);
        }
        
        return list;
    }
}