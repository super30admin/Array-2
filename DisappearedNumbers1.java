
import java.util.ArrayList;
import java.util.List;

/**
 * url: https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
 * Title: 448. Find All Numbers Disappeared in an Array Time Complexity:
 * O(n) Space Complexity: O(1)
 */
public class DisappearedNumbers1 {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> mList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int pos = Math.abs(nums[i]) - 1;
            if (nums[pos] > 0) {
                nums[pos] = -nums[pos];
            } 
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                mList.add(i + 1);
        }
        }   
        return mList;
    }

    public static void main(String[] args) {
        List<Integer> missing = new DisappearedNumbers1().findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1});
        System.out.println(missing);

        missing = new DisappearedNumbers1().findDisappearedNumbers(new int[]{10,2,5,10,9,1,1,4,3,7});
        System.out.println(missing);
    }
}
