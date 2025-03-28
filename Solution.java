class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();


        //[4,3,2,7,8,2,3,1] =
        //(0,1,2,3,4,5,6,7)
        //[4,3,2,-7,8,2,3,1]
        //[4,3,-2,-7,8,2,3,1]
        //[4,-3,-2,-7,8,2,3,1]
        //[4,-3,-2,-7,8,2,-3,1]
        //[4,-3,-2,-7,8,2,-3,-1]
        //[4,-3,-2,-7,8,2,-3,-1] - already visited so ignore
        //[4,-3,-2,-7,8,2,-3,-1] - done already
        //[-4,-3,-2,-7,8,2,-3,-1]
        // (0,1,2,3,4,5,6,7) - 5 and 6 are missing


        for(int i = 0; i < nums.length; i++)
        {
            int index = Math.abs(nums[i]) -1;
            if(nums[index] > 0){
                nums[index] = nums[index]*(-1);
            }

        }
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0)
            {
                result.add(i+1);

            }
        }
        return result;

    }
}