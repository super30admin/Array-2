import java.util.ArrayList;
import java.util.List;

public class FindAllMissingNum {
    //Time Complexity: O(n)
    //Space Complexity: O(1)
   public List<Integer> findDisappearedNumbers(int[] nums) {
       List<Integer> res = new ArrayList<>();
       // convert positions into negative

       for (int i =0;i< nums.length;i++){
        int num = Math.abs(nums[i])-1;
        if (nums[num] <0){
            continue;
        }
        nums[num] = nums[num]*-1;
       }


       for (int i =0;i< nums.length;i++){
        if (nums[i] > 0){
            res.add(i+1);
        }
       }
       return res;
    }
    public static void main(String[] args) {
        FindAllMissingNum f = new FindAllMissingNum();
        int[] nums = {4,3,2,7,8,2,3,1};
        System.out.println(f.findDisappearedNumbers(nums));
    }
}