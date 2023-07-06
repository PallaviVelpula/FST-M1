from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager


def test_activity5():
    driver = webdriver.Firefox(service=FirefoxService(GeckoDriverManager().install()))
    actions = webdriver.ActionChains(driver)
    driver.get("https://www.training-support.net/selenium/input-events")
    print("Title of the page is: " + driver.title)
    actions.click().perform()
    frontText = driver.find_element(By.CLASS_NAME, "active").text
    print(frontText)
    actions.double_click().perform()
    frontText = driver.find_element(By.CLASS_NAME, "active").text
    print(frontText)
    actions.context_click().perform()
    frontText = driver.find_element(By.CLASS_NAME, "active").text
    print(frontText)
    driver.quit()
