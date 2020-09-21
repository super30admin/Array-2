/*
Time Complexity :O(n Log n)
Space Complexity : O(n)
Did this code successfully run on Leetcode : not tried on Leetcode. It ran on my IDE with correct console output.
Any problem you faced while coding this : Referred from geeksforgeeks
*/

import java.util.*;

public class MissingElements
{
    static void printMissing(int ar[], int low, int high)
    {
        HashSet<Integer> hs = new HashSet<>();

        for (int i = 0; i < ar.length; i++)
            hs.add(ar[i]);

        for (int i = low; i <= high; i++)
        {
            if (!hs.contains(i))
            {
                System.out.print(i + " ");
            }
        }
    }

    public static void main(String[] args)
    {
        int arr[] = { 4,3,2,7,8,2,3,1};
        int low = 1, high = 8;
        printMissing(arr, low, high);
    }
}