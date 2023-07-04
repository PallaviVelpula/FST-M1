list_one = [1, 3, 4, 6, 7, 9, 99, 76, 23]
list_two = [12, 13, 5, 54, 89, 44, 65]
list_three = []

for number in list_one:
    if number % 2 != 0:
        list_three.append(number)

for number in list_two:
    if number % 2 != 0:
        list_three.append(number)
print(list_three)
