from selenium import webdriver

from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager


def test_activity14():
    driver = webdriver.Firefox(service=FirefoxService(GeckoDriverManager().install()))
    driver.get("https://www.training-support.net/selenium/tables")
    print("Title of the page is: " + driver.title)
    print("Number of rows are: " + format(len(driver.find_elements(By.XPATH, "//table[@id='sortableTable']/tbody/tr"))))
    print("Number of columns are: " + format(
        len(driver.find_elements(By.XPATH, "//table[@id='sortableTable']/thead/following::tbody/tr[1]/td"))))
    print("Value on Second row second column is: " + (
        driver.find_element(By.XPATH, "//table[@id='sortableTable']/tbody/tr[2]/td[2]")).text)
    (driver.find_element(By.XPATH, "//table[@id='sortableTable']/thead/tr/th[1]")).click()
    print("Value on Second row second column after sorting is: " + driver.find_element(By.XPATH,
                                                                                       "//table[@id='sortableTable']/tbody/tr[2]/td[2]").text)
    footer = driver.find_elements(By.XPATH, "//table[@id='sortableTable']/tfoot/tr/th")
    for i in footer:
        print("Footer value of column is: " + i.text)
    driver.quit()
