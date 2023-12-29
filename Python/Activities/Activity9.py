lst1 = [1,4,3,7,9,2]
lst2 = [6,14,5,8,10,12]

newlist=[]

for i in lst1:
    if i % 2 != 0:
        newlist.append(i)
for i in lst2:
    if i % 2 == 0:
        newlist.append(i)
print(newlist)
