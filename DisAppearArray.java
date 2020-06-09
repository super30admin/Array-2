/*
    Time Complexity : O(N)
    Space Complexity:O(N)
    is Worked on leetcode : YEs
*/

import java.util.List;
import java.util.ArrayList;
public class DisAppearArray{
    public List<Integer> findDisappearedNumbers(int[] nums) {
        ArrayList<Integer> al = new ArrayList<Integer>();
        if( nums == null || nums.length == 0 ) return al;
        
        HashSet<Integer> set =  new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        for(int i=1;i<=nums.length;i++){
            if(!set.contains(i)){
                al.add(i);
            }
        }
        return al;
    }
}