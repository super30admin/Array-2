// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this : yes, checking for already negative number was crucial


// Your code here along with comments explaining your approach
/*
The question states that length of array is n, and it should contain 1 to n elements. It currently has positive elements which are all <=n.@interface
We can use this data to build intuition.
We will visit each element in the array, get the abolste value , and mark at that value index is that the value is found already.@interface
For marking we will negate the element at the index, which would state that a value belonging to that index is already found.
next, we will itaratve through the array, and all the positive value index would be the indices where the values are missing
so we will do index +1 = element and add that to the list , and also make all the elements back to positive during visit
*/
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {

        List<Integer> result  = new ArrayList<Integer>();

        for(int i=0;i<nums.length;i++){

            int element = Math.abs(nums[i]); // the number could be negative by another operation so taking absolute value
            element--; // this would give the index where the element should back
            // if the number is not already negative
            if(nums[element]>0)
            nums[element] = nums[element] * (-1); // Marking it as negative to tell that element belonging to this index is found
        }

        // Now we have temporarily mutated the input, but we will fix it
        // we will find the positve numbers, the indexes +1 would give us the missing elements

        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){ // this means the number is positive
            result.add(i+1); // index+1 would give us the number
            }else{
                // make the negate back to positive to give back the input in original form
                nums[i] = nums[i] * (-1);
            }

        }

        return result;
        
    }
}