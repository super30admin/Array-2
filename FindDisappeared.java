// TC = O(n) as we iterate through each element once
// SC = O(1) no auxiliary space is used, we change state of the
// elements in input array itself.
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindDisappeared {
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        List<Integer> res = new ArrayList<>();
        if(nums==null||nums.length==0) return new ArrayList<>();
        for(int i=0;i<n;i++){
            int curr_idx = Math.abs(nums[i]);
            if(nums[curr_idx-1]<0){
                continue;
            }
            else{
                nums[curr_idx-1] *= -1;
            }

        }
        for(int i=0;i<n;i++){
            if(nums[i]>0){
                res.add(i+1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(FindDisappeared.findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1}));
    }
}
