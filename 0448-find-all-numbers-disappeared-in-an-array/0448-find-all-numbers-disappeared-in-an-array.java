/*
Approach:
The array contains numbers in the range [1,n], where n =size of array.
Some elements appaear twice and others once.We need to find all numbers in[1,n]
that dont appear in the array

// Key Idea:
// We mark the index corresponding to each number as negative (since numbers range from 1 to n,
// We can use nums[i] -1 as an index). This helps track which numbers exist.
// At the end, the indices that are still positive represent the numbers that never appeared.

// Note: We are modifying the original array in place to keep track of presence without using extra space.

// Steps:
// 1. The list will store the missing numbers(not considered extra space)
// 2. First pass: Mark seen numbers by making the corresponding index negative.
// 3. Get the original value (we may have flipped it negative already)
// 4. If number is negative , make it positive (we only care about the original number)
// 5. Make sure temp is within array bounds(1<=temp<=n)
// 6. Use (temp-1) as index (because array is 0-based)
// 7.Only mark it negative if its not already marked.
// 8. Mark the number as seen
// 9. Second pass: Find the indices with positive value=> missing number
// 10. If the value of index i is still positive, then number (i+1) is missing
// 11. Return the list of missing numbers.

// */


// class Solution {
//     public List<Integer> findDisappearedNumbers(int[] nums) {
//         List<Integer> result = new ArrayList<>();
//         for(int i=0; i<nums.length;i++){
//             int temp=nums[i];
//             if(temp < 0){
//                 temp *= -1;
//             }
//             if(temp<=nums.length){
//                 if(nums[temp-1]>0){
//                     nums[temp-1] *= -1;

//                 }
//             }
//         }
//         for(int i=0; i<nums.length;i++){
//             if
//         }
//     }
// }

/*
Approach:
We are given an array of size 'n', where each element is in the range [1,n]
We need to return all number all numbers from 1 to n that are missing in the array.

This approach uses an auxilliary array 'appeared[]' of size n+1, to track the frequency of each number.
1.Iterate through the input array and increment the count of each number in the appeared[] array.
2. Then iterate from 1 to n (inclusive) and check which number in the appeared[] array.
3. Add those numbers to the result list.

Note:
This SC: O(n) since it uses extra space and extra array


Steps:
1. Create a list to store the missing numbers
2. Create an auxilliary array to track appearences of numbers from 1 to n 
3. Index 0 will remain unused.
4. Iterate through each number in nums
5. Increment the count for the current number
6. Now, check which numbers from 1 to n are missing
7. If a number did not appear in nums , add it to output list
8. Return the list of missing numbers

*/


class Solution{
    public List<Integer> findDisappearedNumbers(int[] nums){
        ArrayList<Integer> output = new ArrayList<>();
        int[] appeared = new int[nums.length+1];
        for(int i: nums){
            appeared[i]++;
        }
        for(int i=1; i<nums.length+1;i++){
            if(appeared[i] == 0){
                output.add(i);
            }
        }
        return output;
    }
}
