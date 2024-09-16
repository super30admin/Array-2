class MinandMax {

    public int[] getMinandMax(int[] arr) {

        int n = arr.length;

        //Using 1.5 comparisons instead of 4, because we do 3 comparisons for every pair
        for(int i=0;i<n;i=i+2) {
            if(i==n-1) {
                if(arr[i]>max) max=arr[i];
                if(arr[i]<min) min=arr[i];
            }
            else if(arr[i]>arr[i+1]) {
                if(arr[i]>max) max=arr[i];
                if(arr[i+1]<min) min=arr[i+1];
            }
            else {
                if(arr[i+1]>max) max=arr[i+1];
                if(arr[i]<min) min=arr[i];
            }

        }

    }
}