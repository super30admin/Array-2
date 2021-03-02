class FindMinMax {

    // Time Complexity: O(n)
    // Space Complexity: O(1)

    public int[] findMinMax(int[] nums){
        if(nums == null || nums.length == 0)
            return new int[]{};
        int minVal = Integer.MAX_VALUE;
        int maxVal = Integer.MIN_VALUE;

        for(int i: nums){
            minVal = Math.min(minVal, i);
            maxVal = Math.max(maxVal, i);
        }
        return new int[]{minVal, maxVal};
    }
}