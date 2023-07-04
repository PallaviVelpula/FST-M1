def arraySum(numbers):
    sum_value = 0
    for num in numbers:
        sum_value = sum_value + num
    return sum_value


result = arraySum([1, 2, 1, 3])
print(result)
