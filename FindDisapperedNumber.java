//Interview :Flipkart
//Time Complexity = O(n)
//Space complexity = O(1)
//Brute force approach: 1 to n elements in a given array then scan and check the lowest and highest number to check missing elements in a given array

//Optimize approach:apply 1-n operation to given array and make the result to index of that element converted to negative .So + ve value =-ve.Checking the missing value for given value+nums[i]
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        if(nums == null || nums.length == 0) return new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            int index = Math.abs(nums[i])-1;
            if(nums[index]>0){
                nums[index] = nums[index]*-1;
            }
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                result.add(i+1);
            } else{
                nums[i] = nums[i]* -1;
            }
        }
        return result;
    }
}