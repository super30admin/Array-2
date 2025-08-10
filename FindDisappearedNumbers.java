class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        // o(n) space would be
      /* 1. iterate store in HashSet
         2. iterate from 1 to n  & check if exist in HashSet else add in result array

        ** without extra space
        1. iterate nums , update nums index nums( Math.abs(nums[i]) - 1 ) by -ve
        if it is already negative then ignore
        2. in the end check which index are positive then return idex+1 as missing nums

        */

        for( int i = 0; i < nums.length; i++ ){

            int ind = Math.abs(nums[i]) - 1;
            if(  nums[ind] > 0 ){
                nums[ind] =  nums[ind] * -1;
            }

        }

        // check for positive

        List<Integer> res = new ArrayList<>();

        for( int i = 0; i < nums.length; i++ ){
            if( nums[i] > 0 ){
                res.add(i+1);
            }
        }
        return res;
    }
}