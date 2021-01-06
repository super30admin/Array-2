//TC: O(n)
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int maxNo = Integer.MIN_VALUE;
        List<Integer> list = new ArrayList<Integer>();
        HashSet<Integer> hset = new HashSet<Integer>();
        for(int num : nums) {
            hset.add(num);
            maxNo = Math.max(maxNo, num);

        }

        for(int i = 1; i <= nums.length; i++) {
            if(!hset.contains(i)) {
                list.add(i);
            }
        }
        return list;

    }
}