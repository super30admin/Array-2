/**Given an array of numbers of length N, find both the minimum and maximum. Follow up : Can you do it using less than 2 * (N - 2) comparison */
/**Algorithm- Two Pointer
 * Use a high and a low pointer starting from the start of the array and the end of the array
 * Make a comparison between the ow and the high pointer. Assign the smaller value to the variable small and bigger value to the variable big
 * Comapre the min to the small and max to big
 */
/**TC- O(N)
 * SC- O(1)
 * Total comparisons - 3N/2 because 1 comaprison between high & low + 2 comparison with min and max
 */
public class MinMax {
    public static void main(String[] args) {
        int[] arr = new int[] {3,4,7,8,9,2,1,9,1};
        int small=0, big =0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int low = 0;
        int high = arr.length-1;
        while(low<=high){
          if(arr[low]<arr[high]){
            small = arr[low];
            big = arr[high];
          }
          else{
            small = arr[high];
            big = arr[low];
          }
          low++;
          high--;
          min = Math.min(min,small);
          max = Math.max(max, big);
        }
        System.out.println(min +" " + max);
      }
}
