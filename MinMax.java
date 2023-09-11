// Time Complexity : O(N)  3N/2 comparisons
// Space Complexity :  O(1)
// Did this code successfully run on Leetcode :yes



class MinMax{
    public void printMinMax(int[] arr){
        int n = arr.length;
        int i = 0;
        int j = n-1;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        while(i<j){
            if(arr[i] < arr[j]){
                min = Math.min(min, arr[i]);
                max = Math.max(max, arr[j]);
            }
            else {
                min = Math.min(min, arr[j]);
                max = Math.max(max, arr[i]);
            }
            i++;
            j--;
        }
        if(i == j){
            if(arr[i] < min){
                min = arr[i]; 
            }
            else if(arr[i] > max){
                max = arr[i];
            }
        }
        System.out.println("min: "+ min);
        System.out.println("max: "+ max);
    }
    public static void main(String[] args){
        int[] arr = new int[]{1,4,32,42,123,323,13,342534};
        MinMax obj = new MinMax();
        obj.printMinMax(arr);
    }
}