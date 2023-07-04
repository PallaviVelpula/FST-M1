import pandas

data = {
    "usernames": ["admin", "Charles", "Deku"],
    "passwords": ["password", "Charl13", "AllMight"]
}
dataFrame = pandas.DataFrame(data)
print(dataFrame)

dataFrame.to_csv("../resources/activity17.csv", index=False)
