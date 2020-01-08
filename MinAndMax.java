// Time Complexity : O(n)
// Space Complexity : O(1)

// Any problem you faced while coding this : no
// there will be 1.5( n-1) comparisions as we are pairing elements
public class HelloWorld{

     public static void main(String []args){
        System.out.println("Hello World");
        int max;
        int min;
        int[] arr=new int[]{2,8,6,2,11,5,70};
        max=arr[0];
        min=arr[0];
        int n=arr.length;
        for(int i=0;i<arr.length;i=i+2)
        {
            if(i==n-1) // if there is last element and no element left to pair
            {
                 max=Math.max(max,arr[i]);
                 min=Math.min(min,arr[i]);
            }
            else if(arr[i]>arr[i+1]) // if arr[i] is greater then conpare only arr[i]
            {
               max=Math.max(arr[i],max);
               min=Math.min(arr[i+1],min);
            }
            else{
                max=Math.max(arr[i+1],max);
                min=Math.min(arr[i],min); 
            }
        }
        System.out.print(max);
        System.out.print(min);
     }
}