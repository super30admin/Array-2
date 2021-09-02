//Time complexity: O(n)
//Space complexity: O(n)
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        Set<Integer> set = new HashSet<>();
        List<Integer> result = new ArrayList<>();
        //add elements to the set
        for(int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        //iterate through 1 to length of array and will return the elements that
        //are not present in the set (that will be our missing elements)
        for(int i = 1; i <= nums.length; i++) {
            if(!set.contains(i)) {
                result.add(i);
            }
        }
        return result;
    }
}