//We use a HashSet to track numbers present in the array.

//Steps:
//1.Add all elements into HashSet
//2.Check numbers from 1 to n
//3.If number is missing in set → add to result

//Time: O(n)
//Space: O(n)

class Solution {

    public List<Integer> findDisappearedNumbers(int[] nums) {

        // List to store missing numbers
        List<Integer> result = new ArrayList<>();

        // HashSet to store all present numbers
        HashSet<Integer> set = new HashSet<>();

        // Length of array
        int n = nums.length;



        // Step 1: Add all numbers from array into HashSet
        // This helps in fast lookup O(1)
        for(int i = 0; i < n; i++) {

            set.add(nums[i]);
        }



        // Step 2: Check numbers from 1 to n
        for(int i = 1; i <= n; i++) {

            // If number is not present in set
            // then it is missing
            if(!set.contains(i)) {

                result.add(i);
            }
        }



        // Return missing numbers list
        return result;
    }
}