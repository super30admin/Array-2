//Time Complexity: O(n)
//Space Complexity:O(1)
class Solution {
    public static void main(String[] Args) {
        int[] arr = new int[]{2,8,1,3,6,7,19,5,4};
        int len = arr.length;
        int min = arr[0];
        int max = arr[0];
        for(int i=1;i<len-1;i++){
            if(arr[i]>arr[i+1]){
                max = Math.max(max, arr[i]);
                min = Math.min(min, arr[i+1]);
            }else{
                max = Math.max(max, arr[i+1]);
                min = Math.min(min, arr[i]);
            }
        }
        System.out.print("Max & Min are : " + max + " " + min);
    }
}