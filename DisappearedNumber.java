// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No


class DisappearedNumber {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        //list for result
        List<Integer> res = new ArrayList<>();

        //looping through input and marking element if it exist
        for(int i=0; i<nums.length; i++){
            //finding index
            int ind = Math.abs(nums[i])-1;
            //if current element is not marked
            if(nums[ind]>0){
                //marking element as exist
                nums[ind] *=-1;
            }
        }
        //looping through marked input
        for(int i=0; i<nums.length; i++){
            //if not marked as exist
            if(nums[i]>0){
                // adding index of the elements that are not present
                res.add(i+1);
            }
        }
        //returning result
        return res;

    }
}