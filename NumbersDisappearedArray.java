// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


import java.util.ArrayList;
import java.util.List;

// Your code here along with comments explaining your approach
/* APPROACH:
   got to index abs(nums[i]-1) and interchange its sign
   iterate through the array, whichever value is non-negative, that index+1 is missing
 */

public class NumbersDisappearedArray {
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        //Using Hashmap
        // HashMap<Integer, Integer> map = new HashMap<>();
        // ArrayList<Integer> result = new ArrayList();
        // for(int i=0; i<nums.length; i++){
        //     map.put(nums[i],1);
        // }
        // for(int i=1; i<=nums.length; i++){
        //     if(!map.containsKey(i))
        //         result.add(i);
        // }
        // return result;

        //Using Arrays
//         int[] result = new int[nums.length+1];
//         ArrayList<Integer> resultList = new ArrayList();
//         for(int i:nums){
//             result[i]=i;
//         }

//         for(int i=1; i<=nums.length; i++){
//             if(result[i]==0)
//                 resultList.add(i);
//         }
//         return resultList;

        List<Integer> result = new ArrayList<>();
        //Using negative value
        for(int i=0; i<nums.length; i++){
            int index = Math.abs(nums[i])-1;
            if(nums[index] > 0)
                nums[index] *= -1;
        }

        for(int i=0; i<nums.length; i++){
            if(nums[i] > 0){
                result.add(i+1);
            }
        }

        return result;

    }

    public static void main(String[] args){
        int[] nums = {4,3,2,7,8,2,3,1};
        System.out.println(findDisappearedNumbers(nums)); //[5,6]

        int[] nums2 = {1,1};
        System.out.println(findDisappearedNumbers(nums2)); //[2]
    }
}
