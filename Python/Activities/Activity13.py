def calculatesumlst(lst):
    sum1 = 0
    for items in lst:
        sum1 += items
    return sum1


lst = [10, 3, 5, 2]
n = calculatesumlst(lst)
print(n)
print(f"Sum of elements of the list {n}.")