import java.util.HashSet;
/*
    BruteForce Solution
        Time Complexity : O(N)
        Space Complexity:O(N)
        is Worked on leetcode : YEs
    Efficient Solution
        Time Complexity :O(N)
        Space Complexity :  O(1)
        is workedon leetcode : YES
*/

import java.util.List;
import java.util.ArrayList;
public class DisAppearArray{
    public List<Integer> findDisappearedNumbers_Bruteforce(int[] nums) {
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


    public List<Integer> findDisappearedNumbers1(int[] nums) {
        ArrayList<Integer> al = new ArrayList<Integer>();
        if( nums == null || nums.length == 0 ) return al;
        for(int i=0; i<nums.length;i++){
           int index = Math.abs(nums[i])-1;
           if(nums[index] > 0){
               nums[index] = nums[index]*-1;
           }
        }
        
        for(int i=0; i<nums.length;i++){
            if(nums[i]>0){
                al.add(i+1);
            }
        }
        
        return al;
        
    }
    public static void main(String[] args) {
        DisAppearArray obj =  new DisAppearArray();
        int[]nums= new int[]{4,3,2,7,8,2,3,1};
        System.out.println(obj.findDisappearedNumbers1(nums).toString());
    }
}