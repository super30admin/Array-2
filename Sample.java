// Time Complexity :o(n)
// Space Complexity : o(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach:
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> missingnumbers= new ArrayList<Integer>();
        HashSet<Integer> numbers= new HashSet<Integer>(); //hashsetoto stor unique elements in it
        for(int i: nums) // adding all of them to the hashset
        {
            numbers.add(i);
            
        }
        for(int i=1;i<=nums.length;i++){ //checking 1 by 1 if all numbers are there in the set or not 
            if(!numbers.contains(i)) //if it does not contain then just add to the list 
                missingnumbers.add(i);
        }
        return missingnumbers;
    }
}