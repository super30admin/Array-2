//Find min max
//[2,4,3,1,5,0]
//Space Complexity : o(1)
//Time complexity :o(n)
public class Problem3 {
    private int[] findMinMax(int[] arr){
        int min = Integer.MAX_VALUE;
        int max= Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>arr[i+1]){

                min =Math.min(min,a[i+1]);
                max=Math.max(max,a[i]);
            }else{
                min =Math.min(min,a[i]);
                max=Math.max(max,a[i+1]);
            }
        }

        return new int[]{min,max};

    }
}
