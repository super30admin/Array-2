// Time Complexity : O(n)
// Space Complexity : O(n)
    // n is the length of the given array.

// Your code here along with comments explaining your approach
    //We maintain a boolean array of size n.
    //While traversing the given array, we take the number itself as the index of the boolean array and put true there.
    //Then we traverse the boolean array, we select all the indexes where false is present and return them in a list.
  
import java.util.*;

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        boolean[] arr = new boolean[n];
        for (int x : nums)
        {
            arr[x-1] = true;
        }
        List<Integer> list = new ArrayList<>();
        for (int i=0; i<n; i++)
        {
            if (arr[i]==false)
            {
                list.add(i+1);
            }
        }
        return list;
    }
}