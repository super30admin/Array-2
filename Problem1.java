// Since 1 <= nums[i] <= n all the elements of the array are positive. so the idea is to temporarily
// multiply the element in the (nums[i]-1)th index with -1.This change of sign of (nums[i]-1)th index element
//indicates that element is present in array. Once the array iteration is done , the positve elements index+1 are the missing numbers
// Time Complexity: O(n)
// Space complexity: O(1)
class Problem1 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i<nums.length; i++){
            int idx = Math.abs(nums[i])-1; // get the absolute value if there is  negative number
            if(nums[idx]>0){
                nums[idx] *= -1;
            }
        }
        for(int i = 0; i<nums.length; i++){
            if(nums[i]>0){
                result.add(i+1); // +1 because ex: 4 is stored in index 3
            }
        }
        for(int i = 0; i<nums.length; i++){
            if(nums[i] < 0){
                nums[i] *= -1;
            }
        }
        return result;
    }
}