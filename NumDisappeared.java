/*448. Find All Numbers Disappeared in an Array
Time Complexity: O(n)
Space Complexity: O(n)
*/

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        List<Integer> res = new ArrayList<>();

        for(int i=0; i<nums.length; i++)
            set.add(nums[i]);

        //Iterated from 1 to N since the length is max 1 to N [1,N] inclusive
        for(int i=1; i<=nums.length; i++){
            if(!set.contains(i))
                res.add(i);
        }

        return res;
    }
}


/*448. Find All Numbers Disappeared in an Array
Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();

        for(int i=0; i<nums.length; i++){
            int index = Math.abs(nums[i]) - 1;

            if(nums[index] > 0)
                nums[index] *= -1;
        }

        for(int i=0; i<nums.length; i++){
            if(nums[i] > 0)
                result.add(i+1);
        }
        return result;
    }
}