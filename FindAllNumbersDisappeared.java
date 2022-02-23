import java.util.ArrayList;
import java.util.List;

/*
Time Complexity: O(n)
Space Complexity: O(n)
Run on leetcode: yes
any difficulties: no

Approach: Attempted after the class
 */
public class FindAllNumbersDisappeared {
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for(int num: nums){
            int index = Math.abs(num)-1;
            if(nums[index]>0){
                nums[index]*=-1;
            }
        }
        for(int i = 0; i<nums.length; i++){
            if(nums[i]>0){
                result.add(i+1);
            }
        }
        return result;
    }
    public static void main(String[] args){
        int[] nums = {4,3,2,7,8,2,3,1};
        System.out.println(findDisappearedNumbers(nums));
    }
}
