/**
 * Idea: 
 * 1. Recursively call left half and right 
 * 2. Base condition for 1 and 2 elements. 
 * 3. Compare left half and right half to find min and max
 * 
 * Time Complexity: O(n) 
 * Space Complexity: O(1) no extra space other than result
 */

class MinMaxArray {
    
    class Result {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
    }
    public Result findMinMax(int[] nums, int low, int high){
        
        Result result = new Result();

        //1 ele
        if(low == high){
            result.min = nums[low];
            result.max = nums[high];
            return result;
        }

        //2 ele
        if(high == low + 1){
            if(nums[low] < nums[high]){
                result.min = nums[low];
                result.max = nums[high];
            }
            else{
                result.min = nums[high];
                result.max = nums[low];
            }
            return result;
        }

        // more than 2 ele
        int mid = low + (high-low)/2;

        Result left = findMinMax(nums, low, mid);
        Result right = findMinMax(nums, mid+1, high);

        if(left.min < right.min){
            result.min = left.min;
        }
        else{
            result.min = right.min;
        }

        if(left.max > right.max){
            result.max = left.max;
        }
        else{
            result.max = right.max;
        }

        
        return result;
    }
    public static void main(String[] args){
        System.out.println("MinMaxArray");
        MinMaxArray obj = new MinMaxArray();
        int[] nums = {3,7,1,5,4,6,2};
        

        Result resultObj = obj.findMinMax(nums, 0, nums.length-1);
        System.out.println(resultObj.max + " " + resultObj.min);
    }
}