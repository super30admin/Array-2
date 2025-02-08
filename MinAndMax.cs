class HelloWorld
{
    public static int[] FindMinMax(int[] nums)
    {
        int min = nums[0];
        int max = nums[0];
        for (int i = 0; i < nums.Length; i = i + 2)
        {
            if (i == nums.Length - 1)
            {
                max = Math.Max(nums[i], max);
                min = Math.Min(nums[i], min);
            }
            if (nums[i] > nums[i + 1])
            {
                max = Math.Max(nums[i], max);
                min = Math.Min(nums[i + 1], min);
            }
            else
            {
                max = Math.Max(nums[i + 1], max);
                min = Math.Min(nums[i], min);
            }
        }
        return new int[] { min, max };
    }
    static void Main()
    {
        System.Console.WriteLine("Hello World!");
        int[] arr = new int[] { 1, 2, 3, 4, 5, 6 };
        int[] minmax = FindMinMax(arr);
        Console.WriteLine($"Min {minmax[0]} Max {minmax[1]}");
    }
}