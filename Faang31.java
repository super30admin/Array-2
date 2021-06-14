//time conplexity = o(n)
//space complexity =o(1)

package leetcode;
import java.util.ArrayList;
import java.util.List;

class Faang31 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i=0;i<nums.length;i++) {
            int index =  Math.abs(nums[i]) - 1;
            if(nums[index]>0){
                nums[index] *= -1;
            }
        }
        for (int i=0;i<nums.length;i++) {
            if (nums[i] > 0) {
                list.add(i + 1);
            } else {
                nums[i] *= -1;
            }
        }
        return list;
    }
}
