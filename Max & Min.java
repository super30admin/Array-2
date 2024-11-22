// Time complexity : 0(n)
// space complexity : 0(1)


import java.io.*;

class GFG {
public static void main (String[] args) {
int max,min,n=10;
int [] arr = new int []{2,89,4,6,5,3,1,10,9,11};
   max = arr[0];
   min = arr[0];
for(int i=1; i<arr.length; i=i+2){
   if(i == n-1){
       max = Math.max(max,arr[i]);
       min = Math.min(min,arr[i]);
   } else if (arr[i] > arr [i+1]){
       max = Math.max(max,arr[i]);
       min = Math.min(min,arr[i+1]);
   } else {
       max = Math.max(max,arr[i+1]);
       min = Math.min(min,arr[i]);
}
}
System.out.println("minimum element is:"+min);
System.out.println("maximum element is:"+max);

}
    
}