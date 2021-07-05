//Time Complexity: O(N)
//SPace Complexity:O(1)
//In this problem, first the length of the array is traversed through and then at each iteration, the element at the index -1 corresponding to the element at the current iteration is changed to negative if it is grater than zero. Then the array is again iterated through and those indices for which the element values are greater than zero are returned as index +1.
//This problem was successfully executed and got accepted in leetcode.

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> out=new ArrayList<Integer>();
        for(int i=0;i<nums.length;i++){
            int temp = Math.abs(nums[i])-1;
            if(nums[temp]>0){
                nums[temp]=nums[temp]*(-1);
            }
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                out.add(i+1);
            }
        }
        return out;
    }
}