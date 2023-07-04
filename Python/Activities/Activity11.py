fruits = {
    "apple": "75",
    "banana": "60",
    "strawberry": "100"
}
check_fruit = input("What fruit are you looking for?: ").lower()
if check_fruit in fruits:
    print(check_fruit+ " is available")
else:
    print(check_fruit+ " is not available")
