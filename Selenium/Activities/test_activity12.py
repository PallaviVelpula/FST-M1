from selenium import webdriver

from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager


def test_activity12():
    driver = webdriver.Firefox(service=FirefoxService(GeckoDriverManager().install()))
    driver.get("https://www.training-support.net/selenium/dynamic-controls")
    print("Title of the page is: " + driver.title)
    input = driver.find_element(By.ID, "input-text")
    input.is_enabled()
    driver.find_element(By.ID, "toggleInput").click()
    print("Is the input box enabled?: " + format(input.is_enabled()))
    driver.quit()
