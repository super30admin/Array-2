import java.util.ArrayList;
import java.util.List;
//TC O(n)
//SC O(1)
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int i = 0;
        List<Integer> l = new ArrayList<Integer>();
        while(i < nums.length){
            if(nums[i] != i+1){
                if(nums[i] == nums[nums[i] - 1]) {
                    i++;
                }else{
                    int tmp = nums[i];
                    nums[i] = nums[nums[i] - 1];
                    nums[tmp - 1] = tmp;
                }
            } else i++;
        }
        for(i = 0; i < nums.length; i++){
            if(nums[i] != i + 1) l.add(i+1);
        }
        return l;

    }
}