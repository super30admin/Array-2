
#An array of numbers of length N is given , you need to find the minimum and maximum. try doing this in less than 2* (N-2) comparisons

def max_min_of_ele(a):
    max = a[0]
    min=a[0]
    for i in range(0,len(a),2):
        if i == len(a)-1:
            if max < a[i]:
                max = a[i]
            elif min > a[i]:
                min = a[i]
        if a[i] < a[i-1]:
            if min > a[i]:
                min = a[i]
            if max < a[i-1]:
                max = a[i-1]
        else:
            if max < a[i]:
                max = a[i]
            if min > a[i-1]:
                min = a[i-1]
    return min,max

print(max_min_of_ele([2,4,5,10,1]))