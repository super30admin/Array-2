// Time Complexity :O (3N/2)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Problem not in leetcode
// Any problem you faced while coding this : Struggled to get the pairs logic for this problem

//We will form pairs of two elements and compare the elements with each other. The greater number needs to be compared with max and the smaller number needs to be compared with min. So, with this approach we don't compare each element for max and min unnecessarily  


// Your code here along with comments explaining your approach
public class Problem2 {
   public void compareElements(int[]nums){
       int max = Integer.MIN_VALUE;
       int min = Integer.MIN_VALUE;
       int i;

       if(nums.length == 0 || nums == null) System.out.println("Array is empty");

       if(nums.length == 1){
            max = nums[0];
            min = nums[0];
       }

       if(nums.length % 2 != 0){
        //array is odd. So consider first element as min and max both and start forming pairs 
            max = min = nums[0];
            i =1; // start with 1st element of array
       }

       else{
            if (nums[0] < nums[1]){
                max = nums[1];
                min = nums[0];
            }
            else {
                max = nums[0];
                min = nums[1];
            }
            i = 2; //start from index 2
       }

       while(i < nums.length -1){
           if(nums[i] < nums[i+1]){
               if(nums[i+1] > max) max = nums[i+1];
               if(nums[i] < min) min = nums[i];
           }
           else{
            //nums[i] is greater
            if(nums[i] > max) max = nums[i];
            if(nums[i+1] < min) min = nums[i+1];
           }
           i += 2;
       }

        System.out.println("Array size  : " + nums.length);
        System.out.println("Max         : " + max);
        System.out.println("Min         : " + min);
   }   
    public static void main(String[] args) {
        Problem2 demo = new Problem2();
        
        int [] nums = {3, 1, 4, 1, 5, 9};
        demo.compareElements(nums);

        int [] nums2 = {7, 2, 8, 3, 6};
        demo.compareElements(nums2);

        int [] nums3 = {1, 2, 3, 4, 5, 6};
        demo.compareElements(nums3);
    }
}
