// "static void main" must be defined in a public class.
//Time Complexity: O(nlogn).
//Space Complexity: O(1).
//The minimum number of comparison required in the best sorting algorithm is 2(N-1). There best sorting algorithm works here. 


public class MinMax {
   
        public int[] getMinMax(int[] arr, int n){
            int[] ans = new int[2];
            
            Arrays.sort(arr);
            ans[0] = arr[0];
            ans[1] = arr[arr.length - 1];
            return ans;
        }

    public static void main(String args[]) {
        int arr[] = {1000, 11, 445, 1, 330, 3000};
        int arr_size = 6;
        MinMax minMax = new MinMax();
        int[] ans = minMax.getMinMax(arr, arr_size);
        System.out.printf("\nMinimum element is %d", ans[0]);
        System.out.printf("\nMaximum element is %d", ans[1]);
  
    }
}