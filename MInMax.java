Class Solution{

    public findMinMax(int[] arr){
        int min = arr[0];
        int max = arr[0];

        for(int i=0;i<arr.length;i++){
            int temp_min = arr[i];
            int temp_max = arr[i];
            if(i+1 < arr.length){
               if(arr[i] < arr[i+1]){
                temp_min = arr[i];
               }else{
                   temp_max = arr[i+1];
               }
               i++;
            }
            if(temp_min<min){
                min = temp_min;
            } 
            if(temp_max>max){
                max = temp_max;
            }
        }

    }
}