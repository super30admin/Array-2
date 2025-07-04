// TC- O(n)
// SC- O(1)

// Itegrate through  array and use index of each element to find its value in array and mark it as negative.
// In result array find the numbers which are positive. Answer will be the index+1 of that number
class DisappearNumber {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        
        if(nums==null || nums.length==0){
            return new ArrayList<>();
        }

        int index=0;
        List<Integer> missing = new ArrayList<>();

        // Itegrating and marking found as negative
        for(int i=0; i<nums.length; i++){
            index = Math.abs(nums[i])-1;
            if(nums[index]>0){
                 nums[index] = -nums[index];
            }
        }

        // checking for positive numbers and adding index+1 to missing list
        for(int i=0; i<nums.length; i++){
            if(nums[i]>0){
                missing.add(i+1);
            }
        }
        return missing;
    }
}