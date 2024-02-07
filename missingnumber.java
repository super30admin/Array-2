// Time Complexity :o(2n)->O(n)
// Space Complexity :o(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach: fing length o the array and create a new array/list then iterate through the array and take the moduls of the value then go to the index=values if its -ve leave else multiply by -1 then traves through the list and print the index of +ve numbers;
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int l=nums.length;       
        List<Integer> result= new ArrayList<>();
        for(int i=0;i<l;i++){
            int num=Math.abs(nums[i])-1;
            if(nums[num]>0){
                nums[num]*=-1;
            }
        }
        for(int i=0;i<l;i++){
            if(nums[i]>0) {result.add(i+1);}
        }
        return result;
    }
}