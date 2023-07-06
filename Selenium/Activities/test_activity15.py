from selenium import webdriver

from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from selenium.webdriver.support import expected_conditions
from selenium.webdriver.support.wait import WebDriverWait
from webdriver_manager.firefox import GeckoDriverManager


def test_activity15():
    driver = webdriver.Firefox(service=FirefoxService(GeckoDriverManager().install()))
    wait = WebDriverWait(driver, 10)
    driver.get("https://www.training-support.net/selenium/dynamic-attributes")
    print("Title of the page is: " + driver.title)
    driver.find_element(By.XPATH, "//input[starts-with(@class, 'username-')]").send_keys("admin")
    driver.find_element(By.XPATH, "//input[starts-with(@class, 'password-')]").send_keys("password")
    driver.find_element(By.XPATH, "//button[@type='submit']").click()
    wait.until(expected_conditions.visibility_of(driver.find_element(By.ID, "action-confirmation")))
    print(driver.find_element(By.ID, "action-confirmation").text)
    driver.quit()
