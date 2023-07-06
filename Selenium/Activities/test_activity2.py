from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager


def test_activity2():
    driver = webdriver.Firefox(service=FirefoxService(GeckoDriverManager().install()))
    driver.get("https://training-support.net/selenium/login-form")
    print("Title of the Login page is: " + driver.title)
    driver.find_element(By.ID, "username").send_keys("admin")
    driver.find_element(By.NAME, "Password").send_keys("password")
    driver.find_element(By.XPATH, "//button[(@type='submit' and text()='Log in')]").click()
    driver.quit()
