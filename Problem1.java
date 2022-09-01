// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


import java.util.ArrayList;
import java.util.List;

public class Problem1 {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        //approach using a Hashset
        //Time complexity is O(N)
        //Space is O(N)

//        List<Integer> result = new ArrayList<>();
//        HashSet<Integer> s = new HashSet<>();
//
//        for(int i=0; i<nums.length; i++){
//
//            s.add(nums[i]);
//        }
//
//        for(int i=1; i<=nums.length; i++){
//            if(!s.contains(i)){
//                result.add(i);
//            }
//
//        }
//
//
//        return result;


        //second approach
        //taking the negation of element at each index
        //returning the elements that are not negative at the end
        //modifying the original array back again to absolute value
        //approach is known as temporary state change pattern
        List<Integer> l = new ArrayList<>();
        if(nums==null || nums.length==0) return l;


        for(int i=0; i<nums.length; i++){

            //going to the corresponding index and making the element negative
            int idx = Math.abs(nums[i])-1;
            if(nums[idx] >0){
                nums[idx] *=-1;
            }
        }
        for(int i=0; i<nums.length; i++){
            //if the element found is positive
            //add it to list
            //reverting back to original array
            if(nums[i] >0){
                l.add(i+1);
            }
            else{
                nums[i] = nums[i]*-1;
            }
        }
        return l;




    }
        
    }
}
