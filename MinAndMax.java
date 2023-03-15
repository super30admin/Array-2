class MinAndMax
{
    public List<Integer> findMinAndMax(int[] nums)
    {
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        if ((n & 1) == 1) { n--; }
        for (int i = 0; i < n; i = i + 2)
        {
            int maximum, minimum;
            if (nums[i] > nums[i + 1]) {      
                minimum = nums[i + 1];
                maximum = nums[i];
            }
            else {
                minimum = nums[i];
                maximum = nums[i + 1];
            }
            if (maximum > max) {       
                max = maximum;
            }
            if (minimum < min) {        
                min = minimum;
            }
        }
 
        if ((n & 1) == 1)
        {
            if (nums[n] > max) {
                max = nums[n];
            }
 
            if (nums[n] < min) {
                min = nums[n];
            }
        }
        list.add(min);
        list.add(max);
        return list;
    }
}
