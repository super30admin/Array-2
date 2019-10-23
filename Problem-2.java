/*
Time Complexity: O(n)

Leetcode: could not find the problem on Leetcode.

Approach: 

select first element as minimum.
select last element as maximum.
does not matter what you choose.

iterrate through the nums from i=1 to the 2nd last element of the array.

after the loop completes, we have found the minimum and the maximum, with (N-2)*2 comparisions.



*/

public class HelloWorld{

     public static void main(String []args){
        System.out.println("Hello World");
        
        int nums[] = new int [] {15,4,7,51,9,123,10,23};
        
        int min=nums[0];
        int max=nums[nums.length-1];
        
        for(int i=1;i<nums.length-1;i++)
        {
            if(max<nums[i]) max=nums[i];
            
            if(min>nums[i]) min=nums[i];
        }
        
        System.out.printf(" new max number is %d, min number is %d",max,min);
        
        
        
     }
}
