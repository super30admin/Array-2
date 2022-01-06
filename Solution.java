class Solution
{
    private static void findMinMax(int[] arr)
    {
        int min, max;
        int i;
        if(arr.length % 2 ==0 && arr.length!=0)
            {
                
                if(arr[0]> arr[1])
                {
                    min = arr[1];
                    max = arr[0];
                }
                else
                {
                    min = arr[0];
                    max = arr[1];
                }

                i= 2;
            }
            else
            {
                min = arr[0];
                max = arr[0];
                i=1;

            }
        for(; i<arr.length-1; i+=2 )
        {
        
            if(arr[i]>arr[i+1])
            {
                min = Math.min(min, arr[i+1]);
                max= Math.max(max, arr[i]);
            }
            else
            {
                min = Math.min(min, arr[i]);
                max= Math.max(max, arr[i+1]);
            }
        }
        System.out.println("The minimum value is:" + min);
        System.out.println("The maximum value is:" + max);
    }

    public static void main(String args[])
    {
        int[] arr1 ={5,8,3,18,4,7,12};
        int[] arr2 ={ 5,8,3,18,4,7,12,2};

        findMinMax(arr1);
        findMinMax(arr2);

    }
}