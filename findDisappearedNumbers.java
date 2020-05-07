//time complexity O(n)
//space complexity O(1)

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        if(nums == null || nums.length == 0) return new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        for(int number: nums){
            number = Math.abs(number);
            if(nums[number-1] > 0){
            nums[number-1] *= -1;
            }
        }
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0){
                result.add(i+1);
            }
        }
        return result;
    }
}
