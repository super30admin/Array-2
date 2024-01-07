// Time Complexity : O(n)
// Space Complexity : O(1)
// Approach : number of comparisons 2 * (n -2) creating two pairs and keeping two pointers for min and max to create 4 comparisons over n-2/2 elements 


function findMaxMin(arr) {
    let min, max
    if (arr[0] < arr[1]) {
        min = arr[0]
        max = arr[1]
    } else {
        min = arr[1]
        max = arr[0]
    }
    let i = 2
    while (i < arr.length) {
        let currentMax, currentMin
        if (arr[i + 1] != null) {
            currentMax = Math.max(arr[i], arr[i + 1]);
            currentMin = Math.min(arr[i], arr[i + 1]);
        } else {
            currentMax = arr[i]
            currentMin = arr[i]
        }
        max = Math.max(max, currentMax);
        min = Math.min(min, currentMin);
        i += 2;
    }
    return { max, min };
}

