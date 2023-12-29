dict={
    "apple": 10,
    "banana":20,
    "orange":15,
    "grapes":12
}

user_input = input("Enter the fruit name : ")

if user_input in dict:
    print("Fruit is available")
else:
    print("Fruit is not available")