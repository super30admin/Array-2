// Time Complexity : O(n)
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

    for (i = 2; i < n; i++) {
        if (arr[i] < result.min)
            result.min = arr[i];

        else if (arr[i] > result.max)
            result.max = arr[i];
    }

    return result;

}

findMinMax([4, 76, 2, 100])