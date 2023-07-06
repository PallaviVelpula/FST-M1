from selenium import webdriver

from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager


def test_activity19():
    driver = webdriver.Firefox(service=FirefoxService(GeckoDriverManager().install()))
    driver.get("https://www.training-support.net/selenium/javascript-alerts")
    print("Title of the page is: " + driver.title)
    confirmationAlert = driver.find_element(By.ID, "confirm")
    confirmationAlert.click()
    alert = driver.switch_to.alert
    print("Text on the alert box is: " + alert.text)
    alert.accept()
    confirmationAlert.click()
    driver.switch_to.alert.dismiss()
    driver.quit()
