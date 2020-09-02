// Time Complexity :2*O(N)
// Space Complexity :O(1) (Neglecting the space used by the output arraylist)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english
// 1. Create the datastructure to store the output (List)
// 2. Put all the elements in the input array into the arraylist
// 3. Iterate for all the natural number upto the array length and check if the number is present in list, if not add to the output list
// Your code here along with comments explaining your approach
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
		// 1. Create the datastructure to store the output (List)
        List<Integer> missingNumbers = new ArrayList<Integer>();
		// 2. Put all the elements in the input array into the arraylist
        HashSet<Integer> numbers = new HashSet<Integer>();
        for(int i:nums){
            numbers.add(i);
        }
		// 3. Iterate for all the natural number upto the array length and check if the number is present in list, if not add to the output list
        for(int i=1;i<=nums.length;i++){
            if(!numbers.contains(i)){
                missingNumbers.add(i);
            }
        }
        return missingNumbers;
    }
}