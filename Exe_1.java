class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for(int i=0; i<nums.length; ++i) {
            int index = Math.abs(nums [i])-1;
                if(nums[index] > 0) {
                nums [index] *= -1;
            }
            }
            List<Integer> ans = new ArrayList<>();
            for(int num=1; num<=nums.length; ++num) {
                if(nums [num-1] > 0) {
            ans.add(num);
            }
            }
                return ans;
         }
        }
//tc=O(n)
//sc=O(1)
