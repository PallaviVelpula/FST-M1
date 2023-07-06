from selenium import webdriver

from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager


def test_activity13():
    driver = webdriver.Firefox(service=FirefoxService(GeckoDriverManager().install()))
    driver.get("https://www.training-support.net/selenium/tables")
    print("Title of the page is: " + driver.title)
    rows = driver.find_elements(By.XPATH, "//table[@class='ui celled striped table']/tbody/tr")
    columns = driver.find_elements(By.XPATH, "(//table[@class='ui celled striped table']/tbody/tr)[1]/td")
    print("Number of rows is: {} and number of columns is: {}".format(len(rows), len(columns)))
    tableValues = driver.find_elements(By.XPATH, "(//table[@class='ui celled striped table']/tbody/tr)[1]/td")
    for i in tableValues:
        print(i.text)
    print("Value of 2nd column in second row is: "+driver.find_element(By.XPATH, "((//table[@class='ui celled striped table']/tbody/tr)[2]/td)[2]").text)
    driver.quit()



