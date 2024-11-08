// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Problem1 {
    //TC : O(N)
    //SC: O(1)
    public List<Integer> findDisappearedNumbers(int[] nums) {
        //[4,3,2,7,8,2,3,1]
        List<Integer> result = new ArrayList<>();
        //take a new array of same size afer finding maximum

        //Use the same array
        for(int i=0;i<nums.length;i++){
            int idx = Math.abs(nums[i])-1; //since the array is 0 based index -1

            if(nums[idx]>0) //for duplicate numbers we do not want to mark it again
            {
                //if the index is found just mark it negetive if it is a positie number
                nums[idx]*= -1;
            }
        }

        for(int j=0;j<nums.length;j++){
            if(nums[j]>0){
                result.add(j+1);
            }else{
                nums[j]*=-1;
            }
        }
        return result;

    }

}