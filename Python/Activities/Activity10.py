numbers = tuple(input("Enter a sequence of comma separated values: ").split(", "))
print(numbers)
for num in numbers:
    if int(num) % 5 == 0:
        print(num)
