from selenium import webdriver

from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from selenium.webdriver.support.select import Select
from webdriver_manager.firefox import GeckoDriverManager


def test_activity18():
    driver = webdriver.Firefox(service=FirefoxService(GeckoDriverManager().install()))
    driver.get("https://www.training-support.net/selenium/selects")
    print("Title of the page is: " + driver.title)
    dropdown = driver.find_element(By.ID, "multi-select")
    select = Select(dropdown)
    select.select_by_visible_text("Javascript")
    select.select_by_index(4)
    select.select_by_index(5)
    select.select_by_index(6)
    select.select_by_value("node")
    select.deselect_by_index(5)
    driver.quit()
