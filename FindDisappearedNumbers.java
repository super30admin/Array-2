/*TC- O(N) -linear iteration on the input array  
 *SC-O(N) auxiliary hashmap used
 Ran on leetcode - yes
 * */i

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        Map<Integer, Boolean> hm= new HashMap<Integer, Boolean>();
	// Add the numbers to the hashmap
        for (int num:nums){
            hm.put(num, true);
        }
        List<Integer> ans = new ArrayList<Integer>();
        for (int i = 1; i <= nums.length; i++){
		// since the numbers are starting with one (given), we inpspect from1 to n.  
		// if the element is not found , add to the resultanant arraylist
            if (!hm.containsKey(i)){
                ans.add(i);
            }
        }
        
        return ans;
    }
}





