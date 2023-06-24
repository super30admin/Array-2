package prog_448_FindAllDisappearNumberArray;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    /*
    In this problem we have to find all the missing numbers from the sorted array.
    Approach 1 :
    We can sort entire array and check the diffrence between current index and next index it should be 0 or 1.
    If it is more than one that means element missing between 2 indexes.
    Time complexity : O(NlogN) + N

    Approach 2 :
    1) In this approach we are starting we index 0 and we get the value of that index.
     we go to appropriate element of that index and mark that number to -
     for eg
      0  1  2  3  4  5. 6. 7
     [4, 3, 2, 7, 8, 2, 3, 1]

     We start with index 0, at index 0 we have value 4 so we will go to 4th item which is index 3
     and we will mark it to negative number so 4th item number 7 at index 3 will be negative.
      0  1  2  3  4  5. 6. 7
     [4, 3, 2, -7, 8, 2, 3, 1]

     At index 1, we have value 3 so we will go to 3rd item at index 2 and mark value 2 as negative
      0  1  2  3  4  5. 6. 7
     [4, 3, -2, -7, 8, 2, 3, 1]

    We will keep doing till the end
      0   1   2   3   4  5  6 7
     [-4, -3, -2, -7, 8, 2, -3, -1]

     Now we knw at index 4 & 5 we have a positive number
     So we will be returning index + 1 as a value which means that is missing number
     So index 4 + 1 = 5 && 5 + 1 = 6 so 5,6 are missing numbers.

     Time complexity : O(N) + O(N) = 2 O(N) => O(N)
     Space Complexity : O(1)
     */

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            int a = Math.abs(nums[i]) -1 ;
            if(nums[a]>0){
                nums[a] = nums[a] * -1;
            }
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                result.add(i+1);
            }
            else{
                nums[i] = nums[i]* -1 ;
            }
        }
        return result ;
    }
}