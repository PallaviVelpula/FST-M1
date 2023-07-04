numbers = list(input("Enter a sequence of comma separated values: ").split(", "))

if numbers[0] == numbers[-1]:
    print("True")
else:
    print("False")
