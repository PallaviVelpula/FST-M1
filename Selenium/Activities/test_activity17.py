from selenium import webdriver

from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from selenium.webdriver.support.select import Select
from webdriver_manager.firefox import GeckoDriverManager


def test_activity17():
    driver = webdriver.Firefox(service=FirefoxService(GeckoDriverManager().install()))
    driver.get("https://www.training-support.net/selenium/selects")
    print("Title of the page is: " + driver.title)
    singleSelectDropdown = driver.find_element(By.ID, "single-select")
    select = Select(singleSelectDropdown)
    select.select_by_visible_text("Option 2")
    select.select_by_index(3)
    select.select_by_value("4")
    allOptions = select.options
    for option in allOptions:
        print(option.text)
    driver.quit()
