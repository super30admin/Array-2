class Solution{
    public void maxOrmin(int[] arr){

        int max = arr[0];
        int min = arr[0];

        for(int i=0; i<arr.length-1; i++){
            if(arr[i] > arr[i+1]){
                max = Math.max(max,arr[i]);
                min = Math.min(min,arr[i+1]);
            }else{
                max = Math.max(max,arr[i+1]);
                min = Math.min(min,arr[i]);
            }
        }

        System.out.println("max"+max+"min"+min);

    }

    public static void main(String []args){

        int[] arr = new int[]{10,8,4,7,2,6,1,5};
        maxOrmin(arr);

    }


}