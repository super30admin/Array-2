//Time Complexity: O(N)
//Space Complexity: O(1)
public class MinMax{
    public static int[] getMinMax(int nums[])
    {
        int[] minMax = new int[2];
        if(nums[0] > nums[1])
        {
            minMax[1] = nums[0];
            minMax[0] = nums[1];
        }
        else
        {
            minMax[1] = nums[1];
            minMax[0] = nums[0];
        }
        for(int i = 2; i < nums.length; i++)
        {
            if(nums[i] > minMax[1]) minMax[1] = nums[i];

            else minMax[0] = nums[i];
        }
        return minMax;
    }
    public static void main(String []args){
        int[] nums = {1,2,3,4,5,6,7,8};
        int[] minMax = getMinMax(nums);
        System.out.println("Minimum element in the array is: "+minMax[0]);

        System.out.println("Maximum element in the array is: "+minMax[1]);
    }
}