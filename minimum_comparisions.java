import java.util.*;
public class minimum_comparisions {
    public static void main(String [] args){
        int arr[] = {1000, 11, 445, 1, 330, 3000};
        int n = arr.length;
        int max=0,min=0;
        int i=0;
        if(n%2==0){
            if(arr[0]>arr[1]){
                max = arr[0];
                min = arr[1];
            }
            else 
            
            {min = arr[0];
            max = arr[1];}
            i = i+2;
        }
        else 
        {
            min = arr[0];
            max = arr[0];
            i=1;
        }
        
        while(i<n-1){
            if(arr[i]>arr[i+1]){
                max= Math.max(max,arr[i]);
                min = Math.min(min,arr[i+1]);
            }
            else{
                max= Math.max(max,arr[i+1]);
                min = Math.min(min,arr[i]);
            }
            i = i+2;
        }
        System.out.println(max);
        System.out.println(min);
        return;
    }
}
