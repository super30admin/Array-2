
def min_max( array):

    min_val = 99999
    max_val = -99999
        
    i = 0

    while i <= len(array) - 2:
        j = i+1

        if array[i] < array[j]:
            big = array[j]
            small = array[i]
        else:
            big = array[i]
            small = array[j]
        i = i+1
        #print(big,small)
        min_val = min(min_val,small )
        max_val = max(max_val, big)

    return min_val,max_val

print (min_max([3,4,1,8]))
    