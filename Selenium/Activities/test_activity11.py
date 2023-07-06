from selenium import webdriver

from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager


def test_activity11():
    driver = webdriver.Firefox(service=FirefoxService(GeckoDriverManager().install()))
    driver.get("https://www.training-support.net/selenium/dynamic-controls")
    print("Title of the page is: " + driver.title)
    checkbox = driver.find_element(By.CLASS_NAME, "willDisappear")
    print("Is checkbox selected?: "+format(checkbox.is_selected()))
    checkbox.click()
    print("Is checkbox checkbox selected after clicking on the toggle?: "+format(checkbox.is_selected()))
    driver.quit()