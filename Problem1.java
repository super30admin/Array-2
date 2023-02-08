import java.util.ArrayList;
import java.util.List;

/*
Disappeared Numbers in an array
approach: a number n should be at index n-1

time: O(n)
space: O(1)
 */
public class Problem1 {
        public List<Integer> findDisappearedNumbers(int[] nums) {
            List<Integer> res = new ArrayList<>();
            for(int i=0; i<nums.length; i++) {
                if(Math.abs(nums[i])>0) {
                    if(nums[Math.abs(nums[i])-1]>0) nums[Math.abs(nums[i])-1]*=-1;
                }
            }

            for(int i=0;i<nums.length;i++) {
                if(nums[i]>0) res.add(i+1);
            }

            return res;
        }

}
