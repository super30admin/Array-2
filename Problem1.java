// Time Complexity : o(n)
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
//logic is to make number at index -ve as soon as the number equal to index+1 appears
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        //output result so space complex for this is not considered
        List<Integer> result = new ArrayList<>();
        
        //iterate over the array
        for(int i=0;i<nums.length;i++){
           //at each index we need to have num +1 
           //at 0 index we have 1, at 2 we have 2
           //based on this concept, we first take the element from array and                make its corresponding index -ve
           int idx = Math.abs(nums[i])-1;
            //making corresponding index -ve  
            if(nums[idx]>0){
                nums[idx] *= -1;
            }
        }
        //if any elemnts in array are +ve that means its respective element has not appeared and we can result that in an array
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                result.add(i+1);
            }
            //making them +ve again
            nums[i] *= 1;
        }
        return result;
    }
}