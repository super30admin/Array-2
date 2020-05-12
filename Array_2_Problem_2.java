//Time Complexity : O(n)
//Space Complexity : O(1)
//Not sure if its on leetcode or not
//No problem

//Here we are trying to reduce the number of comparision
//We will be taking elements in pair and will be finding local minimum and local maximum
//After than the localminimum will be compared to global minimum and likewise for the maximum





public class Array_2_Problem_2 {
    public static int[] findMinMax(int nums[])
    {
        if(nums == null || nums.length == 0) return new int[]{0,0};
        else if(nums.length == 1) return new int[]{nums[0],nums[1]};
        int min = nums[0];
        int max = nums[0];
        for(int i = 0; i < nums.length -1 ; i = i + 2)
        {
            int localMin;
            int localMax;
            if(nums[i]<nums[i+1])
            {
                localMin = nums[i];
                localMax = nums[i+1];
            }
            else
            {
                localMax = nums[i];
                localMin = nums[i+1];
            }
            min = Math.min(min,localMin);
            max = Math.max(max,localMax);
        }
        return new int[]{min,max};
    }

    public static void main(String[] args) {
        int[] a = { 7, 2, 9, 3, 1, 6, 7, 8, 4 };
        int[] ans = findMinMax(a);
        System.out.println(ans[0] + " "+ ans[1]);
    }
}
