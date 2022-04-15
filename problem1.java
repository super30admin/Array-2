import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class disappearedInArray{
    public List<Integer> findDisappearedNumbers(int[] nums) {
        if(nums == null || nums.length == 0) return new ArrayList<>() {};
        List<Integer> res = new ArrayList<>();

        for(int i=0;i<nums.length;i++){
            int index = Math.abs(nums[i]) - 1;
            if(nums[index] > 0){
                nums[index] = nums[index] * -1;
            }
        }

        for(int i=0;i<nums.length;i++){
            if(nums[i] < 0){
                nums[i] = nums[i] * -1;
            }
            else{
                res.add(i+1);
            }
        }
        return res;

    }
    public static void main(String[] args) {
        disappearedInArray da = new disappearedInArray();
        int[] nums = {4,3,2,7,8,2,3,1};
        System.out.println(Arrays.toString(da.findDisappearedNumbers(nums).toArray()));
    }
}