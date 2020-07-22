// Time Complexity : O(n) where n is number of rows.
// Space Complexity :O(1) 
// Did this code successfully run on Leetcode : Not on Leetcode
// Any problem you faced while coding this : No

public class MinAndMax{
    
     private static void minAndMax(int[] array)
     {
         if(array==null || array.length==0) {
             System.out.println("Empty array");
         }
         if(array.length==1)
         {
             System.out.println("Min is "+array[0]);
             System.out.println("Max is "+array[0]);
         }
         
         int i = 0;
         int j = 1;
         int min = array[0];
         int max = array[0];
         while(i<array.length)
         {
             
             System.out.println(i+","+j);
             if(i==array.length-1)
             {
                if(array[i]>max) max=array[i];
                if(array[i]<min) min=array[i]; 
             }
             else if(array[i]>array[j])
             {
                if(array[i]>max) max = array[i];
                if(array[j]<min) min = array[j];
             }
             else
             {
                if(array[j]>max) max=array[j];
                if(array[i]<min) min=array[i];   
             }
             i=j+1;
             j=i+1;
         }
         System.out.println("Min is "+min);
         System.out.println("Max is "+max);
     }

     public static void main(String []args){
        int[] array = {2,8,6,2,11,5,70};
        minAndMax(array);
     }
}