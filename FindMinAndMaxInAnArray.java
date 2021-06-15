// Time Complexity : O(k x n/2) where k is the number of pairs and n is the length of the array ≈ O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : I had to handle odd and even case which I had missed initially

public class FindMinMax {
    private Pair minMAx(int[] arr){
      
        if(arr == null || arr.length == 0)
            return new Pair(0,0);
      
        int max = 0;
        int min  = Integer.MAX_VALUE;
        int flag = arr.length%2 == 0? 0: 1;
      
        for(int i=0; i<arr.length-1; i=i+2){
            if(arr[i] > arr[i+1]){
                max = Math.max(max, arr[i]);
                min = Math.min(min, arr[i+1]);
            }
            else {
                max = Math.max(max, arr[i + 1]);
                min = Math.min(min, arr[i]);
            }
        }
      // if arr length is odd
        if(flag == 1){
            max = Math.max(max, arr[arr.length-1]);
            min = Math.min(min, arr[arr.length-1]);
        }
        return new Pair(max, min);
    }
    public static void main(String[] args) {
        FindMinMax f = new FindMinMax();
        Pair ans = f.minMAx(new int[]{4, 6, 1, 9, 15, 10, 0});
        System.out.println(ans.key);
        System.out.println(ans.val);
    }
}

// for returning a tuple
class Pair{
    int key;
    int val;
    Pair(int key, int val){
        this.key = key;
        this.val = val;
    }
}
