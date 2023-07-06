from selenium import webdriver

from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from selenium.webdriver.support import expected_conditions
from selenium.webdriver.support.wait import WebDriverWait
from webdriver_manager.firefox import GeckoDriverManager


def test_activity16():
    driver = webdriver.Firefox(service=FirefoxService(GeckoDriverManager().install()))
    wait = WebDriverWait(driver, 10)
    driver.get("https://www.training-support.net/selenium/dynamic-attributes")
    print("Title of the page is: " + driver.title)
    driver.find_element(By.CSS_SELECTOR, "input[class$='-username']").send_keys("admin")
    driver.find_element(By.CSS_SELECTOR, "input[class$='-password']").send_keys("password")
    driver.find_element(By.XPATH, "//label[contains(text(),'Confirm Password')]/following-sibling::input").send_keys(
        "password")
    driver.find_element(By.XPATH, "//input[starts-with(@name,'email')]").send_keys("pallavi.example@gmail.com")
    driver.find_element(By.XPATH, "//button[@type='submit' and contains(text(),'Sign Up')]").click()
    print(wait.until(
        expected_conditions.visibility_of(driver.find_element(By.XPATH, "//div[@id='action-confirmation']"))).text)
    driver.quit()
