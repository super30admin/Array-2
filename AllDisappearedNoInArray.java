//Time Complexity: O(n)
//Space Complexity: O(1)
import java.util.ArrayList;
import java.util.List;

public class AllDisappearedNoInArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        int index = -1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                index = nums[i]-1;
            }
            else{
                index = nums[i]*-1;
                index = index-1;
            }
            if(nums[index]>0){
                nums[index] = nums[index]*-1;
            }
        }

        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                list.add(i+1);
            }
        }
        return list;

    }
}
