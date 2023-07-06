from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager


def test_activity1():
    driver = webdriver.Firefox(service=FirefoxService(GeckoDriverManager().install()))
    driver.get("https://www.training-support.net")
    print("Title of the home page is: " + driver.title)
    driver.find_element(By.ID, "about-link").click()
    print("Title of the new page is: " + driver.title)
    driver.quit()
