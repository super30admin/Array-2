
#TC:O(N)
#SC:O(1)

List1 = [2,1,4,10,0,-1,50,20,21]

# mind min and max
import math
minimum=math.inf
maximum=-math.inf

if len(List1)%2==0:
    for i in range(len(List1)-1):
        if (List1[i]>List1[i+1]):
            minimum=min(minimum,List1[i+1])
            maximum=max(maximum,List1[i])
        else:
            maximum=min(maximum,List1[i+1])
            minimum=max(minimum,List1[i])
    
else:
    for i in range(len(List1)-2):
        if (List1[i]>List1[i+1]):
            minimum=min(minimum,List1[i+1])
            maximum=max(maximum,List1[i])
        else:
            maximum=min(maximum,List1[i+1])
            minimum=max(minimum,List1[i])
    print(minimum,maximum)
    minimum=min(minimum,List1[-1])
    maximum=max(maximum,List1[-1])
print(minimum,maximum)
