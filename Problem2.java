// Time Complexity :O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
class Problem2{

    // find min-max using less than 2n-2 comparisons
    public static int[] findMinMax(int[] nums){

        // edge case
        if(nums== null || nums.length<2)
            return new int[]{0,0};
        
        // result: 0th -> min , 1st -> max
        int[] result = {Integer.MAX_VALUE, Integer.MIN_VALUE};

        // iterate 
        for(int i=0; i<nums.length; i++){

            // less
            if(nums[i] < nums[i+1]){

                // check with gobal
                if(nums[i] < result[0])
                    result[0] = nums[i];
                if(nums[i+1] > result[1])
                    result[1] = nums[i+1];
            // greater
            }else{

                // check with global
                if(nums[i+1] < result[0])
                    result[0] = nums[i+1];
                if(nums[i] > result[1])
                    result[1] = nums[i];
            }

            // odd length
            if(i+2 == nums.length-1){
                if(nums[i+2] < result[0])
                    result[0] = nums[i+2];
                else if(nums[i+2] > result[1])
                    result[1] = nums[i+2];
                break;
            }else{
                ++i;
            }

        }


        return result;
    }

    public static void main(String[] args) {
        
        int oddNums[] = {2, 3, 7, 8, 1};
        int evenNums[] = {5, 7, 8, 9, 11, 2};

        System.out.println("For odd length");
        int[] oddResult = findMinMax(oddNums);
        System.out.println("Min: " + oddResult[0]);
        System.out.println("Max: " + oddResult[1]);

        System.out.println("----------------------------------");

        System.out.println("For even length");
        int[] evenResult = findMinMax(evenNums);
        System.out.println("Min: " + evenResult[0]);
        System.out.println("Max: " + evenResult[1]);

    }
}