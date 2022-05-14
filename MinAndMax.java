public class MinAndMax {
    public static void main(String[] args) {
        int[] arr = new int[]{1,4,-8,10,21,43,23,-10};
        int start = 0;
        int end = arr.length -1;
        int min = arr[start];
        int max= arr[end];
        while(start <= end){
            if(arr[start] > arr[end]){
                max = Math.max(max, arr[start]);
                min = Math.min(min, arr[end]);
            }
            else{
                max = Math.max(max, arr[end]);
                min = Math.min(min, arr[start]);
            }
            start++;
            end--;
        }
        System.out.println("Min: "+ min);
        System.out.println("Max: "+ max);
    }
}
