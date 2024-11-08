// Time Complexity :isIsomorphic: O(5n/2)=O(n)
// Space Complexity :0(1)


public class MaxAndMin {

    class Pair{
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
    }
    public Pair maxAndMin(int[] arr){
        Pair minmax= new Pair();
        if(arr.length == 1){
            minmax.min= arr[0];
            minmax.max= arr[0];
        }

        if(arr.length % 2!=0){
            minmax.min = Math.min(minmax.min, arr[arr.length-1]);
            minmax.max = Math.max(minmax.max, arr[arr.length-1]);
        }

        for(int i=0; i<=arr.length+1; i=i+2){
            if(arr[i]<arr[i+1]){
                minmax.min = Math.min(minmax.min, arr[i]);
                minmax.max = Math.max(minmax.max, arr[i+1]);
            }else{
                minmax.min = Math.min(minmax.min, arr[i+1]);
                minmax.max = Math.max(minmax.max, arr[i]);
            }
        }
        return minmax;
    }

    public static void main(String args[]) {
        MaxAndMin maxMin= new MaxAndMin();
        int[] arr= {4,9,6,5,2,3};
        Pair minmax = maxMin.maxAndMin(arr);
        System.out.println("minimum "+minmax.min);
        System.out.println("maximum "+minmax.min);
    }
}
