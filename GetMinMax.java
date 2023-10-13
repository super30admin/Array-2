//given an array find min and max values
//Given an array of numbers of length N, find both the minimum and maximum. Follow up : Can you do it using less than 2 * (N - 2) comparison

// We are taking one pass at the array and comparing for current and next values
// and skipping by 2 indexes, reducing time complexity from 2 to 1.5 ms

//Time complexity: O(n)
//Space complexity: O(1)

public class GetMinMax {

    public static void main(String[] args)
    {
        int nums[] = {1,8, 9, 10, 11, 12, 13, 14, 15, -1};
        int max = 1;
        int min = 1;

        for (int i = 0; i < nums.length - 1; i+=2)
        {
            if(nums[i] < nums[i + 1])
            {
                max = Math.max(max, nums[i+1]);
                min  = Math.min(min, nums[i]);
            }
            else{
                max = Math.max(max, nums[i]);
                min = Math.min(min, nums[i+1]);
            }
        }

        System.out.println("Max: " + max);
        System.out.println("Min: " + min);
    }
    
}
