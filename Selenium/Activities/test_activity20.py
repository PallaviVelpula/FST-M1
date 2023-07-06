from selenium import webdriver

from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager


def test_activity20():
    driver = webdriver.Firefox(service=FirefoxService(GeckoDriverManager().install()))
    driver.get("https://www.training-support.net/selenium/javascript-alerts")
    print("Title of the page is: " + driver.title)
    driver.find_element(By.ID, "prompt").click()
    promptAlert = driver.switch_to.alert
    print(promptAlert.text)
    promptAlert.send_keys("Awesome!")
    promptAlert.accept()
    driver.quit()
