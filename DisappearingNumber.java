/**
Problem: Find disappering numbers in the given array from 1 to n
Time Complexity : O(n), where n is the length of the array.
Space Complexity : O(1), for optimal solution, as we modify the array  in place. 
                    O(n), if we use a hashset.

Did the problem run on leetcode : Yes

Approach 1 : Use a hashset. TC : O(n), SC : O(n)
1. Place all the unique elements in the hashet.
2. Iterate thru the given array, and check if the index is already present in the hashset.
3. If it's not present, then it's a missing number. So append it to the list and at the end return the list.



Approach 2: In-place array modification. TC : O(n) SC : O(1)
1. Iterate thru the array, and if the index(offset by 1) is present as an element in the array, go to that index, and make the number negative.
2. If there's a duplicate number, we don't make it negative again.(because we could have already made it negative earlier)
3. By doing this, we'll have a few negative numbers and few positive numbers.
4. In the end, we return the indices of positive numbers as those are the indices whose elements haven't been found.
 */
//Solution 1: Use a hashset
public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<Integer>();
        HashSet<Integer> hs = new HashSet<>();
        for(int i = 0; i < nums.length; i++) {
            if(!hs.contains(nums[i])) {
                hs.add(nums[i]);
            }
        }
        for(int i = 0; i < nums.length; i++) {
            if(!hs.contains(i+1)) {
                list.add(i+1);
            }
        }
        return list;
    }
}


//Solution 2: In-place modification.
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            if(temp < 0) {
                temp *= -1;
            }
            if(nums[temp-1] > 0) {
                nums[temp-1] *= -1;
            }
        }
        for(int i= 0; i < nums.length; i++) {
            if(nums[i] > 0) {
                list.add(i+1);
            }
        }
        return list;
    }
}