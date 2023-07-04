import pandas

csv_data = pandas.read_csv('../resources/activity17.csv')
print(csv_data)
print(csv_data["usernames"])
print("Username and password of second row are: " + csv_data["usernames"][1] + ", " + csv_data["passwords"][1])
print(csv_data.sort_values("usernames"))
print(csv_data.sort_values("passwords", ascending=False))
