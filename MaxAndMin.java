// Time Complexity : 1.5 O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Ran it on https://www.jdoodle.com/online-java-compiler/
// Any problem you faced while coding this : No

public class MyClass {
    public static void main(String args[]) {
      int[] arr = {1,8,4,3,-6,17,6,19,14};
      int min = arr[0];
      int max = arr[0];
      int i=1;
      int j=2;
      while(j<=8){
          if(arr[i]>arr[j]){
              if(arr[i]>max){
                  max=arr[i];
              }
              if(arr[j]<min){
                  min=arr[j];
              }
          }
          else{
              if(arr[j]>max){
                  max=arr[j];
              }
              if(arr[i]<min){
                  min=arr[i];
              }
          }
          i++;
          j++;
      }
      System.out.println("Max:"+max);
      System.out.println("Min:"+min);
    }
}