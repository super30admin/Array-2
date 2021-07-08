/* Problem Statement:
WORKS ON LEETCODE

Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

Find all the elements of [1, n] inclusive that do not appear in this array.

Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.

Example:

Input:

[4,3,2,7,8,2,3,1]

Output:

[5,6]

 *
 * Time Complexity : O(n)
 * Space Complexity : O(1) considering the final array not to be part of the space complexity 
 */

#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<stdbool.h>
#include<math.h>


/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* findDisappearedNumbers(int* nums, int numsSize, int* returnSize){
    int *final_arr = NULL;
    int idx = 0, pos_idx = 0;
    int final_idx = 0;
    *returnSize = 0;
    
    /* validation checks */
    if (!nums) {
        return final_arr;
    }
    /* memory allocation */
    final_arr = (int *)calloc(numsSize, sizeof(int));
    
    if (!final_arr) {
        printf("Memory allocation failed \n");
        return final_arr;
    }
    /* Method 1 : Using the result array to store the value 1 corresponding to indexes
       mapped to values present in the nums array : 136ms run time */
#if 0    
    for (idx = 0; idx < numsSize; idx++) {
        final_arr[nums[idx] - 1] = 1;
    }
    
    for (idx = 0; idx < numsSize; idx++) {
        if (final_arr[idx] == 0) {
            final_arr[final_idx++] = idx + 1;
        }
    }
#endif
    /* Method 2 : Better than 1st one in terms of runtime as here we are modifying the 
     *  original array by doing the following (96ms runtime)
     * 1. Determine the absolute index from the source array and make the number -ve at that index to indicate that the index is actually present ie the number is present in the nums array.
     2. Iterate over the modified nums array to see values at indexes which are +ve and our answer.
     */
    for (idx = 0; idx < numsSize; idx++) {
        pos_idx = abs(nums[idx]) - 1;
        if (nums[pos_idx] > 0) {
            nums[pos_idx] *= -1;
        }
    }
    /* Answer lies in the nums array with values which are still +ve */
    for (idx = 0; idx < numsSize; idx++) {
        if (nums[idx] > 0) {
            final_arr[final_idx++] = idx + 1;
        }
    } 

    *returnSize = final_idx;
    return final_arr;

}



int main(int argc, char *argv[]) {
    int *num_p = NULL;
    int *final_arr = NULL;
    int returnSize = 0;
    int idx = 0;
    if (argc < 2) {
        printf("Usage: ./a.out <num1> ... <num n>\n");
        exit(1);
    }
    printf("Input size array : %d \n", argc - 1);

    num_p = (int *)malloc((argc - 1)*sizeof(int));
    if (num_p == NULL) {
        printf("Memory allocation failed \n");
        return -1;
    }

    /* Dont want to change the function, so copying the input to int array */
    for (idx = 1; idx < argc; idx++) {
        num_p[idx - 1] = atoi(argv[idx]);
    }

    final_arr = findDisappearedNumbers(num_p, argc - 1, &returnSize);
    printf("Missing numbers are : ");
    for (idx = 0; idx < returnSize; idx++) {
        printf(" %d ", final_arr[idx]);

    }
    printf("\n");

    free(num_p);
    free(final_arr);
    return 0;
}


