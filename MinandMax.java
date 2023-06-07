//Time Complexity o(n) space complexity o(1)
public class MinandMax{
    public static void main(String[] args) {
        int[] arr = {34,45,2,3,12,-1,0,45,68};
        int max=arr[0], min=arr[0];
        for(int i=1;i<arr.length-1;i++){
            if(arr[i] > arr[i+1]){
                max = Math.max(max, arr[i]);
                min = Math.min(min, arr[i+1]);
            }
            else{
                max = Math.max(max, arr[i+1]);
                min = Math.min(min, arr[i]);
            }
        }
        System.out.println("Max :" + max + " Min :"+min);
    }
}