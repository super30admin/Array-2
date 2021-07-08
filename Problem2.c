/* Problem Statement:
Question not present on LeetCode

Given an array of numbers of length N, find both the minimum and maximum. Follow up : Can you do it using less than 2 * (N - 2) comparison

 *
 * Time Complexity : O(n) specifically 2 * O(N - 2)
 * STILL TRYING TO FIGURE OUT THE CASE WHERE WE CAN SOLVE BETTER THAN 2 * O(N - 2)
 * Space Complexity : O(1) 
 */

#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<stdbool.h>
#include<math.h>


/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
void find_min_max(int* nums, int numsSize){
    int idx = 0, min = 0, max = 0;
    
    /* validation checks */
    if (!nums) {
        return;
    }

    /* Minimum 2 numbers needed */
    if (numsSize < 2 ){
        printf("Insufficient data to perform operations \n");
        return;
    }
    /* Initialize min and max */
    if (num[0] > num[1]) {
        max = num[0];
        min = num[1];
    } else {
        max = num[1];
        min = num[0];
    }

    /* Go over the numbers from 3rd element onwards and based on condition update min and max.*/
    for (idx = 2; idx < numsSize; idx++) {
        if (min > nums[idx]) {
            min = nums[idx];
        } else if (max < nums[idx]) {
            max = nums[idx];
        }
    }
    printf("Min : %d, Max: %d\n",min,max);
    return;
}



int main(int argc, char *argv[]) {
    int *num_p = NULL;
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

    find_min_max(num_p, argc - 1);
    free(num_p);
    return 0;
}


