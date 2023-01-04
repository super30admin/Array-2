import java.util.ArrayList;
import java.util.List;

public class Problem1 {

    //time o(n), space o(1)
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        int negative = -1;

        List<Integer> list = new ArrayList<>();
        for(int i =0; i< n; i++){
            int idx = Math.abs(nums[i])-1;
            nums[idx] = negative*Math.abs(nums[idx]);
        }

        for(int i=0; i<n ; i++){
            if(nums[i] > 0){
                list.add(i+1);
            }
        }

        return list;


    }
}
