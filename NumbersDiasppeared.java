//Time Complexity: O(N)
//Space Complexity: O(1)
//To find out the missing number, we modify the given array(By doing so, we are able to 
//achieve O(1) space complexity). For every element present in the array,
//we make the element at its corresponding index negative. In the end, if there is a non negative element in 
//the array, the element corresponding to that element is the missing element.
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if(result == null) return result;
        
        for(int i = 0; i<nums.length; i++){
            int index = Math.abs(nums[i])-1;
            if(nums[index]>0){
                nums[index] *= -1;
            }
        }
        for(int i = 0; i<nums.length; i++){
            if(nums[i]>0){
                result.add(i+1);
            }else{
                nums[i] *= -1;
            }
        }
        return result;
    }
}