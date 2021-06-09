// time complexity - O(N)
//space complexity - O(1)



class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {

        //finding the index and marking it wih multipying the number by -1
        for(int i = 0; i < nums.length; i++) {

            int index = Math.abs(nums[i]) - 1;

            if(nums[index] > 0) {

                nums[index] *= -1;

            }


        }

        // check the result array with non-negative entry to add in result array with their respective index positions
        List<Integer> result = new LinkedList<Integer>();

        for( int i = 1; i <= nums.length; i++) {

            if(nums[i - 1] > 0) {

                result.add(i);

            }


        }


        return result;




    }
}