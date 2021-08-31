// Time Complexity : O(n)  Decresed the swaps from 2n to 1.5n
// Space Complexity : O(1)
// Did this code successfully run : Yes

function findMinMax(arr) {
    let n = arr.length;
    let result = { min: Infinity, max: -Infinity };
    if (!arr || arr.length === 0) return result;
    if (n == 1) {
        result.max = arr[0];
        result.min = arr[0];
        return result;
    }


    if (arr[0] > arr[1]) {
        result.max = arr[0];
        result.min = arr[1];
    }
    else {
        result.max = arr[1];
        result.min = arr[0];
    }

    for (i = 2; i < n - 1; i++) {
        if (arr[i] < arr[i + 1]) {
            console.log(arr[i], arr[i + 1]);
            result.max = Math.max(result.max, arr[i + 1]);
            result.min = Math.min(result.min, arr[i]);
        } else {
            (arr[i] > arr[i + 1])
            result.max = Math.max(result.max, arr[i]);
            result.min = Math.min(result.min, arr[i + 1]);
        }
    }

    return result;

}