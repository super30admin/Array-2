//Time Complexity :O(n)
//Space Complexity:O(1)
/*Approach
-placing negatives in the index(Numbers that we are encountering in the array)
and then iterating through it again to check which index has positive number and 
that means its index(actually index +1) is the number which was missing
 */
import java.util.ArrayList;
import java.util.List;

public class DisappearedNumber {
    public static List<Integer> findMissingNumber(int[] nums){
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < nums.length;i++){
            int temp = nums[i];
            if(temp<0) temp *= -1;
            if(nums[temp-1] > 0) nums[temp-1] *= -1;
        }
        for(int i = 0; i < nums.length;i++){
            if(nums[i] >0){
                result.add(i+1);
            }
        }
        return result;
    }

    public static void main(String args[]) {
        List<Integer> result = new ArrayList<>();
        //result = findMissingNumber(new int[]{4,3,2,7,8,2,3,1});
        result = findMissingNumber(new int[]{5,4,4,3,3});
        System.out.println(result);
    }
}