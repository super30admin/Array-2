// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :yes 

class FindDisappeard{

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        for(int i =0; i<nums.lenght; i++){
            int idx = Math.abs(nums[i])-1; //if we already have negative number therefor we take abs. 
                                        //as its idexed from zero we need to do minus 1. 
            if(nums[idx]>0){ // if its positive then only will make negative.
                nums[idx] *= -1;
            }
        }
        for(int i = 0; i<nums.length; i++){
            if(nums[i]>0){
                result.add(i+1); // Will now record postive element and add 1 to get resukt.
            }else{
                nums[i] *= -1; //Just we are converting back to postive.
            }
        }
        return result;
    }
}