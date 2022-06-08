//Time complexity: O(n)
// space complexity: O(1)
public class Solution {
public class Pair{
int min;
  int max;
}
  
  public Pair getMinMax(int arr[]){
  if(arr.length<=1) return null;
    int min,max;
    for(int i=1;i<arr.length;i=i+2){
      min=arr[i-1];
      max=arr[i];
      if(arr[i]>arr[i-1]){
      max=Math.max(max,arr[i]);
        min=Math.min(min,arr[i-1);
      } else {
      max=Math.max(max,arr[i-1]);
        min=Math.min(min,arr[i);
      }
  
    }
Pair p = new Pair();
                             p.max=max;
                             p.min=min;
                             return p;
  }
}
