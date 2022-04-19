// Time Complexity : o(n)
// Space Complexity :o(1)

public class minMax{
    public static void main(String args[]){
        int nums[] = {12,30,10,2,89,10};
        int min= nums[0];
        int max= nums[0];
        //iterating over the array at checking for min and max values
        for(int i=0;i<nums.length;i++){
            if(nums[i]<min){
                min = nums[i];
            }
             if(nums[i]>max){
                max = nums[i];
            }
        }
        System.out.println("Minimum: " + min);
        System.out.println("Maximum: " + max);
    }
} 
