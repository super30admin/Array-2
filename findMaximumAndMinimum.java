


class FindMaximumAndMinimumInAnArray {
    //Brute force solution
    public int[] findMaxAndMin(int[] nums) {
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++)
        {
            min=Math.min(min, nums[i]);
            max=Math.max(max, nums[i]);
        }
        System.out.println(min+" "+max);
        return new int[] {min, max};
    }



    public static void main(String[] args)
    {
        FindMaximumAndMinimumInAnArray f = new FindMaximumAndMinimumInAnArray();
        int[] nums={4, 6, 9, 3, 0, 2};
        f.findMaxAndMin(nums);
    }

}