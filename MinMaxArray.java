//time complexity : 3((n-1)/2)
//space complexity : O(1)
//steps : if array length is odd, keep max and min to be first point, else compare values at index 0 and 1 and assign max and min accordingly
// now iterate array and take two elements and compare min and max. 
class MinMaxArray {

    public static int[] computeMaxMin(int[] arr){

        int max,min,index;

        if(arr.length%2==1){
            max = arr[0];
            min = arr[0];
            index =1;
        }
        else{
            if(arr[0]>arr[1]){
                max = arr[0];
                min  = arr[1];
            }
            else {
                min = arr[0];
                max = arr[1];
            }
            index = 2;
        }

        for(int i=index; i<arr.length-1;i++){
            if(arr[i]>arr[i+1]){
                max = Math.max(max,arr[i]);
                min = Math.min(min,arr[i+1]);
            }
            else {
                max = Math.max(max,arr[i+1]);
                min = Math.min(min,arr[i]);
            }
        }

        return new int[]{max,min};
    }




    public static void main(String[] args) {
        int [] arr = {2,3,6,11,2,3,4,5,6,7,15};
        int [] s = MinMaxArray.computeMaxMin(arr);
        System.out.println(s[0]+" "+s[1]);
    }
}