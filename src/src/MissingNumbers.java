
/*
TC : O(N) where n is the size of the array
SC :O(1)
Leetcode : yes
Problems faced :no
 */
/**
 * The approach taken is simple. If a number x i spresent the the index x-1 element is made negative.
 * and in the next iteration the index i where the element is postive, means that i+1 is absent.
 */

public class MissingNumbers {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> soln = new ArrayList<>();
        for(int x: nums)
        {
            if(nums[Math.abs(x)-1] >0)
                nums[Math.abs(x)-1] *= -1;
        }

        for( int i=0; i<nums.length;i++)
        {
            if(nums[i]>0)
                soln.add(i+1);
        }
        return soln;
    }
}
