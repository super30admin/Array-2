// Time Complexity : O(n)
// Space Complexity : O(1)
// Any problem you faced while coding this :yes


// Your code here along with comments explaining your approach
//Find the min and max on eaxh pair and 2 additional comaprison for odd number of elements
//Total comparisions = (3n/2) for even elements and (3n/2)+2 for odd elements

public class Main
{
    static class Pair {

        int min;
        int max;
    }

    public static void main (String[] args)
    {
        int arr[] = {200, 11, 445, 1, 230};
        Pair minmax = getMinMax(arr);
        System.out.printf("Minimum element is %d", minmax.min);
        System.out.printf("\nMaximum element is %d", minmax.max);
    }
    static Pair getMinMax(int arr[]) {
        Pair minmax = new Pair();
        int i=0;
        minmax.min = Integer.MAX_VALUE;
        minmax.max = Integer.MIN_VALUE;
        while(i<arr.length-2){
            if(arr[i]<arr[i+1]){
                minmax.min = Math.min(minmax.min,arr[i]);
                minmax.max = Math.max(minmax.max,arr[i+1]);
            }else{
                minmax.min = Math.min(minmax.min,arr[i+1]);
                minmax.max = Math.max(minmax.max,arr[i]);
            }
            i +=2;
        }
        if(arr.length%2>0){
            minmax.min = Math.min(minmax.min,arr[arr.length-1]);
            minmax.max = Math.max(minmax.max,arr[arr.length-1]);
        }
        return minmax;
    }
}