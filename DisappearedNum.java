// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : YES

class DisappearedNum {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        if(nums == null || nums.length ==0) return new ArrayList<>();
        int n = nums.length;
        List<Integer> result = new ArrayList<>();

        //take the absolute value of an element and find it's corresposding index
        //if the value of that particular index is not negative then make it negative
        // that way we can record that this value coresposing to any index is present or not
        for(int i=0; i<n; i++){
            int index = Math.abs(nums[i])-1;
            if(nums[index] > 0){
                nums[index] *= (-1);
            }
        }

        //if the value of the particular index is positive then it means value corresponding to that index is not present in our array and add it to the result. and if value is negative make it positive.
        for(int i=0; i<n; i++){
            if(nums[i]<0){
                nums[i] *= (-1);
            } else {
                result.add(i+1);
            }
        }

        return result;
    }
}