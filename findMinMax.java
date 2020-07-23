/** Problem: Given an array of numbers of length N, find both the minimum and maximum. Follow up : Can you do it using less than 2 * (N - 2) comparison 
 * 
 * time complexity : O(n) where n is the total number of elements in the array
 * space complexity : O(1)
 * executed on leetcode: not on leetcode
 * approach :
 * if the array has even number of elements, initiate global min and max after comparing first two elements
 * if the array has odd number of elements, global min and max will be first element
 * then start from index 2 and compare in pairs and update global min and max accordingly
 * return global min and max
 * takes less than 2n-2 comparisions
 */
public class findMinMax {
    int max;
    int min;
    int i=0;
    findMinMax(int[] nums)
    {   int localmin;
        int localmax;
        if(nums.length%2==0) 
        {
            if(nums[0]>nums[1])
            {
                max = nums[0];
                min = nums[1];
            }
            else if(nums[0]<nums[1]){
                max = nums[1];
                min = nums[0];
            }
            else
            {
                min = nums[0];
                max = min;
            }
            i=2;
        }
        else{
            min = nums[0];
            max = nums[0];
            i=1;
        }
        
        while(i<=nums.length-2)
        {
            if(nums[i]>nums[i+1])
            {
                localmax = nums[i];
                localmin = nums[i+1];
                
            }
            else{
                localmax = nums[i+1];
                localmin = nums[i];
            }
            if(localmin<min) min=localmin;
            if(localmax>max) max =localmax;
            i+=2;
        }
        System.out.println("min="+min+" and max="+max);
    }
    public static void main(String[] args) {
        int[] nums = new int[]{9,9,7,1,2,-1,8,0};
        findMinMax obj = new findMinMax(nums);
    }
    
}