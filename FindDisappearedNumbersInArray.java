//Time Complexity: O(n)
//Space complexity: O(1)

import java.util.ArrayList;
import java.util.List;

public class FindDisappearedNumbersInArray {
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> l = new ArrayList<>();
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]);
            if (nums[index - 1] > 0) {
                nums[index - 1] *= -1;
            }
        }
        k=0;
        for(int n : nums){
            k++;
            if(n>0)
                l.add(k);
        }
//         for(int i=0; i<nums.length; i++){
//             l.add(i+1);
//         }
        
//         for(int i=0; i<nums.length; i++){
//             if(l.contains(nums[i])){
//                 l.remove(new Integer(nums[i]));
//             }
//         }        
        return l;
    }
    public static void main(String[] args) {
        
    }    
}