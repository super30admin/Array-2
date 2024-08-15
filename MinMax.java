public class MinMax {
    public static void main(String[] args) {
        int[] arr={4,-3,2,1,7,0,1,3,2};
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            if(arr[i]<min){
                min=arr[i];
            }
            if(arr[i]>max){
                max=arr[i];

            }
        }
        System.out.println(min);
        System .out.println(max);

    }
}
