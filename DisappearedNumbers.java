package s30.arrays.array2;


// Time complexity : O(n) >>>O(2n) asymptotically its O(n)
// Space complexity: O(1)
import java.util.ArrayList;
import java.util.List;

public class DisappearedNumbers {

    public static List<Integer> findDisappearedNumbers(int[] nums) {

        List<Integer> res = new ArrayList<>();
        for(int index =0; index < nums.length; index++){

            if(nums[Math.abs(nums[index])-1] > 0){
                nums[Math.abs(nums[index])-1] *=-1;
            }
        }

        for(int index=0; index < nums.length; index++){
            if(nums[index] > 0) res.add(index+1);
        }

        return res;
    }
    public static void main(String[] args) {
        System.out.println(findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1}));
    }
}
