// Time Complexity : O(2N) ~ O(N), N is the length of input array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class DisappearedNumbers {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> missingNumbers = new ArrayList<>();
        for(int i=0;i<nums.length;i++) {
            if(nums[Math.abs(nums[i])-1]<0) continue;
            else {
                nums[Math.abs(nums[i])-1] *= -1;
            }
        }
        System.out.println(Arrays.toString(nums));
        for(int i=0;i<nums.length;i++) {
            if(nums[i] > 0)
                missingNumbers.add(i+1);
        }
        return missingNumbers;
    }
}