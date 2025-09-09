// Online C# Editor for free
// Write, Edit and Run your C# code using C# Online Compiler

using System;

public class HelloWorld
{
    public static void Main(string[] args)
    {
        var (min,max) = FindMinMax(new []{3, 5, 1, 8, 2 });
    }
    
    public static (int min,int max) FindMinMax(int[] arr)
    {
        int min = arr[0];
        int max = arr[0];
        for(var i=1;i<arr.Length;i++)
        {
            if(arr[i]>max)
            {
                max = arr[i];
            }
            if(arr[i]<min)
            {
              min = arr[i];
            }
        }
        return (min,max);
    }
}