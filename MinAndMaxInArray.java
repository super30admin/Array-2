// Time Complexity : O(n).
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Approach : Comparison by pairs approach helps in reducing the comparisons that checking min and max at each value. We consider two
// elements in the array and based on the bigger value we compare with existing max and voce versa for min. If array size is odd I was
// missing the last element, so I have added an additional condition for it as well.

class Solution {
    public ArrayList<Integer> getMinMax(int[] arr) {
        // code Here
        ArrayList<Integer> res = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int i=0;
        for(i=0;i<arr.length-1;i+=2){ //increment by 2 as we are comparing pairs
            if(arr[i] < arr[i+1]){
                min = Math.min(min,arr[i]);
                max = Math.max(max,arr[i+1]); //as i+1 is bigger, compare with previous max
            } else{
                min = Math.min(min,arr[i+1]); //as i+1 is smaller, compare with previous min
                max = Math.max(max,arr[i]);
            }
        }
        if(i == arr.length-1){ //additional check for last element of odd length arrays
            min = Math.min(min,arr[i]);
            max = Math.max(max,arr[i]);
        }
        res.add(min);
        res.add(max);
        return res;

    }
}
