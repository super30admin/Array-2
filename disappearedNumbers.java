    /*  Explanation
    # Leetcode problem link : https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
    Time Complexity for operators : o(n) .. number of  elements in the array
    Extra Space Complexity for operators : o(1) .. LIST is the required return type.
    Did this code successfully run on Leetcode : Yes
    Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
        # Basic approach : Sort the array and chck with  the index+1.

        # Optimized approach same like basic approach: 
                              
            # 1. traverse thru thee array and get the value of the position but change the index of that value by multiplying
                 it by -1.
              2. You will get all those index which are missing if it has positive value.
              3. next for loop to check position numbers and indexes of those number to the list (indexs+1).
              4. return list.
       */

    import java.util.*;
    public class disappearedNumbers{
        public static void main(String args[]) {
                    int nums[] = new int[]{4,3,2,7,8,2,3,1};
                    List<Integer> list = findDisappearedNumbers(nums);
                  // for(int i=0;i<arr.length;i++){
                        System.out.println(list);
                    //}
        }
                
                            
            public static List<Integer> findDisappearedNumbers(int nums[]) {
                if(nums==null || nums.length==0)
                    return new ArrayList<>();
        
                for(int i = 0;i<nums.length;i++){
                    int k = Math.abs(nums[i]);
                    // if(k<0)
                    //     k *= -1;
                    if(nums[k-1]>0)
                        nums[k-1] = nums[k-1] * -1;
                }
                List<Integer> list = new ArrayList<>();
                for(int i = 0;i<nums.length;i++){
                if(nums[i]>0)
                    list.add(i+1);
                }
                return list;
            }
    }