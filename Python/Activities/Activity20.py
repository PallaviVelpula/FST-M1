import pandas

excel_data = pandas.read_excel("../resources/activity19.xlsx")
print(excel_data)
print(excel_data.shape)
print(excel_data["Email"])
print(excel_data.sort_values("FirstName"))
