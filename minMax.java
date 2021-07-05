//Time Complexity: O(N)
//Space Complexity:O(1)
//In this problem, I'll have two variables min and max to keep track of my min and max element as I iterate through the array. When I iterate through the array, I'll check whether I have reached the last element. In that case, I'll check whether my last element is greater than max and I'll update the max value if so and check if it is less than my min and update it accordingly if so. Else, I'll compare the elements in pair to find out local min and max. I'll then compare these local min and max with the min and max and update them accordingly if there's any change.
//This problem got executed successfully in VS code. 

class Solution{
    public static void main(String[] args){
        int[] nums={-1,2,3,4,11,0,-2};
        int min=nums[0];
        int max=nums[0];
        for(int i=1;i<nums.length;i+=2){
            if(i==nums.length-1){
                if(min>nums[i]){
                    min=nums[i];
                }
                if(max<nums[i]){
                    max=nums[i];
                }

            }
            else{
                if(nums[i]>nums[i+1]){
                    if(max<nums[i]){
                        max=nums[i];
                    }
                    if(min>nums[i+1]){
                        min=nums[i+1];
                    }
                }
                else{
                    if(max<nums[i+1]){
                        max=nums[i+1];
                    }
                    if(min>nums[i]){
                        min=nums[i];
                    }
                }
            }


        }
        System.out.println("The min element is "+min);
        System.out.println("The max element is "+max);
    }
}