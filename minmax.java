public class minmax {


    public static void minmax(int []nums){
        // base condition check if array is null
        if(nums== null || nums.length<1)
            return;

        int min ,max;
        //initialized two variables

        //in case array has just one element in it
        if(nums.length == 1){
            max= nums[0];
            min= nums[0];
            System.out.println(max + min );
            return ;
        }
        if (nums[0]>nums[1]){
            //base case dealing with two elements in the array
            max = nums[0];
            min = nums[1];
        }else{
            max = nums[1];
            min = nums[0];
        }

        //iterating over the complete array and updating teh value of min and max accordingly .
        for(int i =2;i< nums.length-1;i++){
            if (max < nums[i]){
                max= nums[i];
            }
            else if (min > nums[i]){

                min = nums[i];
            }
        }

        System.out.println("min"+ min +"max"+max);
    }
    public static void main (String[] args) {
        int[] nums = {7, 1, 5, 3, 6, 4};
        minmax(nums);
    }

}
