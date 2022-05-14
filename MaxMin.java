// Time Complexity : O(n)
// Space Complexity :O(1)
public class MaxMin {
public static void main(String args[]) 
    { 
        int arr[] = {200, 191, 112, -11, 330, 60};
   int n = 6;
   int min=0,max=0;
   /*If there is only one element then return it as min and max both*/
   if (n == 1)
      { min=max=arr[0]; }
   /* If there are more than one elements, then initialize min and max*/
   if (arr[0] > arr[1]){
      max = arr[0];
      min = arr[1];
   }
   else{
      max = arr[1];
      min = arr[0];
   }
   for (int i = 2; i<n; i++){
      if (arr[i] > max)
         max = arr[i];
      else if (arr[i] < min)
         min = arr[i];
   }
   System.out.println(" Minimum element"  );
   System.out.println(min);
   System.out.println(" Maximum element"  );
   System.out.println(max);
    }

    
}
