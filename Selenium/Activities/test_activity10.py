from selenium import webdriver

from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager


def test_activity10():
    driver = webdriver.Firefox(service=FirefoxService(GeckoDriverManager().install()))
    driver.get("https://www.training-support.net/selenium/dynamic-controls")
    print("Title of the page is: " + driver.title)
    toggle = driver.find_element(By.CLASS_NAME, "willDisappear")
    toggle.is_displayed()
    driver.find_element(By.ID, "toggleCheckbox").click()
    print("Is checkbox toggle displayed?: "+format(toggle.is_displayed()))
    driver.quit()
