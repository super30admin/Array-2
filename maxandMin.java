    /*  Explanation
    # Leetcode problem link : not available 
                https://www.geeksforgeeks.org/maximum-and-minimum-in-an-array/
    Time Complexity for operators : o(n) .. number of  elements in the array
                        better than (2n-2) comparison
    Extra Space Complexity for operators : o(1) .. LIST is the required return type.
    Did this code successfully run on Leetcode : NA
    Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
        # Basic approach : Two variable max and min. and check with each element and maintain their value and return
                           max and min.

        # Optimized approach same like basic approach: 
                              
            # 1. traverse thru the array but do it in a slot of 2 (i=i+2)and check first element with second.
              2. If first element is lesser then check 2nd element for max and 1st with min.
              3. If first element is greater then check 2nd element for min and 1st with max.
              4. add to list and return list.
       */

    import java.util.*;
    public class maxandMin{
        public static void main(String args[]) {
                    int nums[] = new int[]{2,5,6,0,8,9,1};
                    List<Integer> list = maxandMinproblem(nums);
                    System.out.println(list);
        }
                
                            
            public static List<Integer> maxandMinproblem(int nums[]) {
                if(nums==null || nums.length==0)
                    return new ArrayList<>();
                int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

                for(int i = 0;i<nums.length-1;i=i+2){
                    if(nums[i]<nums[i+1]){
                        min = Math.min(min,nums[i]);
                        max = Math.max(max,nums[i+1]);
                    }else{
                        min = Math.min(min,nums[i+1]);
                        max = Math.max(max,nums[i]);
                    }
                }
                if(nums.length%2==1){
                    min = Math.min(min,nums[nums.length-1]);
                    max = Math.max(max,nums[nums.length-1]);
                }
               // (3n/2)+2 i.e (1.5n+2) comparisons
                List<Integer> list = new ArrayList<>();
                list.add(min);
                list.add(max);
                return list;
            }
    }