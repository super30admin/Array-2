/*Given an array of numbers of length N, find both the minimum and maximum. Follow up : Can you do it using less than 2 * (N - 2) comparison*/
// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes


// Your code here along with comments explaining your approach
  //get pairs of 2 numbers.
  //for all pairs make 3 comparisons to get global min and max.
import java.util.*;
class Solution{
  public int[] minMax(int ar[]){
    //consider ret[0] as min, ret[1] as max.
    int ret[] = new int[2];

    //if only one num, mark as max and min.
    if(ar.length == 1){
      ret[0] = ar[0];
      ret[1] = ar[0];
    }
    //if more than one elem
    else {
      //compare first 2 elems.
      if(ar[0] > ar[1]){
        ret[0] = ar[1];
        ret[1] = ar[0];
      }
      else{
        ret[0] = ar[0];
        ret[1] = ar[1];
      }

      //iterate in a group of 2.
      int i = 2;
      while(i <= ar.length - 1){
        //in case len is odd, we ll have one elem without grp.
        //compare single elem with min max.
        //this should be last elem , if len odd.
        if(i == ar.length -1){
          if(ar[i] > ret[1])
            ret[1] = ar[i];
          if(ar[i] < ret[0])
            ret[0] = ar[i];
        }

        //in a group compare two elems,
        //then compare global max with grp max
        //and global min with group min.
        else if(ar[i] > ar[i+1]){
          //ar[i] is larger
          if(ar[i] > ret[1])
            ret[1] = ar[i];
          if(ar[i+1] < ret[0])
            ret[0] = ar[i+1];
        }
        else{
          //ar[i+1] is larger
          if(ar[i+1] > ret[1])
            ret[1] = ar[i+1];
          if(ar[i] < ret[0])
            ret[0] = ar[i];
        }
        i+=2;
      }
    }
    return ret;
  }
}
class MinMax{
  public static void main(String[] args) {
    Solution sol = new Solution();
    int ar[] = {1,2,4};
    System.out.println(Arrays.toString(sol.minMax(ar)));
  }
}
