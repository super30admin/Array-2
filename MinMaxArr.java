package Day12;

//TC: O(n)
//SC: O(1)
public class MinMaxArr {

    public static void main(String args[]) {
        int n = 7, max, min;

        int[] arr = new int[]{2,8,6,2,11,5,70};

        max = arr[0];
        min = arr[0];

        for(int i=1; i<arr.length; i=i+2){
            //Stopping condition
            //in case of odd number of elements left after 0th element
            //last element wont have an other element to be compared with
            //therefore comparing last element alone with max and min and updating max and min accordingly
            if(i == n-1){
                max = Math.max(max, arr[i]);
                min = Math.min(min, arr[i]);
            }
            //considering elements starting from first element as 0th element is taken as ref as both min and max
            //compare ith and i+1 th element, greater among those will be compared with global max and lesser with global min
            //and update max and min accordingly
            else if(arr[i] > arr[i+1]){
                max = Math.max(max, arr[i]);
                min = Math.min(min, arr[i+1]);
            }
            //if ith element is smaller i+1th element, assign ith to min and i+1 to max and compare with global max and min again update
            else{
                max = Math.max(max, arr[i+1]);
                min = Math.min(min, arr[i]);
            }
        }

        System.out.println("The minimum element in the array is: "+min);
        System.out.println("The maximum element in the array is: "+max);
    }
}
