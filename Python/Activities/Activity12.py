def sumrecursive(n):
    if n < 1:
        return n
    else:
        return n + sumrecursive(n - 1)

n = sumrecursive(10)
print(f"Sum of numbers from 0 to 10 is {n}.")
