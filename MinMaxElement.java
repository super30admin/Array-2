// TC: O(N)
// SC: O(1)
class MinMaxElements
{
    class Pair{
        int min;
        int max;
        Pair(int min, int max)
        {
            this.min = min;
            this.max = max;
        }
    }
    public Pair getMinMaxElement(int[] nums) {
        int min = nums[0];
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        return new Pair(min, max);
    }
}
