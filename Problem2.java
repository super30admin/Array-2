// Time Complexity : O(N)  , as we are looping throuhg all the elements in array.
// Space Complexity : Constanct , used pair class . 
// Did this code successfully run on Leetcode : Y, referenced from geek for geeks.
// Any problem you faced while coding this : No.


// Your code here along with comments explaining your approach

class Solution{

static class Pair{
  int minArr;
  int maxArr;
}

public static int getMinMax(int[] arr){
 
 Pair res = new Pair();
 
 if(arr.length == 1){
 res.minArr = arr[0];
 res.maxArr = arr[0];
 return res;
 }
 if(arr[0]>arr[1]){
 res.minArr = arr[1];
 res.maxArr = arr[0];
 }else{
 res.minArr = arr[0];
 res.maxArr = arr[1];
 }
 
 for(i=2;i<arr.length;i++){
    if(arr[i] > res.maxArr){
      res.maxArr = arr[i];
    }else if(arr[i] < res.minArr){
      res.minArr = arr[i];
      }
 }
}

public static void main(String[] args){
int[] arr = {4,3,2,7,8,2,3,1};
Pair p = getMinMax(arr);
System.out.print("Min : ",p.minArr);
System.out.print("Max : ",p.maxArr);
}
}






