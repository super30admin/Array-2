import java.util.ArrayList;
import java.util.List;

class Solution_ {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int max=0;
        int[] data = new int[nums.length+1];
        List<Integer> result = new ArrayList<Integer>();
        for(int i=0;i<nums.length;i++){
            data[nums[i]]=nums[i];

        }
        for (int i=0;i<data.length;i++){
            if(data[i]!=i){
                result.add(i);
            }
        }

        return result;
    }
}