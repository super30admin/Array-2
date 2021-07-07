//The program objective is to find the minimum and maximum value in a given array for reduced comparision
//Time complexity: O(n)
//Tried the following code in geeks for geeks IDE
/*
for the below input the output came to be:
                                            max: 111
                                            min: -40
*/
class Solution
{
    public static void main(String[] args)
    {
        //the given input array
        int [] arr = {-1,-40,-2,9,111,8,7};
        int n=7;
        //to store max val
        int max=arr[0];
        //to store the min val
        int min=arr[0];
        //Iterate over the array for every 2 adjacent elements
        for(int i=1;i<n;i+=2)
        {
            //check if i is at the last element
            if(i==n-1)
            {
                //Check if the last element is smaller than the current min
                if(min > arr[i])
                //assign min as arr[i]
                    min = arr[i];
                //Check if the last element is greater than the current max
                if(max < arr[i])
                //assign max as arr[i]
                    max = arr[i];
            }
            else
            //else check if the current element is greater than the adjacent element
            if(arr[i]>arr[i+1])
            {
                //If current element is greater then check if it is greater than current max
                if(arr[i]>max)
                //assign it as the max element
                max = arr[i];
                //Check if the adjacent element is smaller than the current min 
                if(arr[i+1]<min)
                //assign it as min if true
                min = arr[i+1];
            }
            else
            {
                //ELse check for reverse of the above conditions and assign accordingly
                if(arr[i+1]>max)
                max = arr[i+1];
                if(arr[i]<min)
                min = arr[i];
            }
        }
        System.out.println("max: "+max);
        System.out.println("min: "+min);
    }
}