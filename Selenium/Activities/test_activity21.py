import time
from selenium import webdriver

from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from selenium.webdriver.support import expected_conditions
from selenium.webdriver.support.wait import WebDriverWait
from webdriver_manager.firefox import GeckoDriverManager


def test_activity21():
    driver = webdriver.Firefox(service=FirefoxService(GeckoDriverManager().install()))
    wait = WebDriverWait(driver, 10)
    driver.get("https://www.training-support.net/selenium/tab-opener")
    print("Title of the page is: " + driver.title)
    driver.find_element(By.ID, "launcher").click()
    wait.until(expected_conditions.number_of_windows_to_be(2))
    print("Handles opened are: ", driver.window_handles)
    driver.switch_to.window(driver.window_handles[1])
    time.sleep(3)
    wait.until(expected_conditions.visibility_of(driver.find_element(By.XPATH, "//div[@class='content']")))
    print("Title of the page is: " + driver.title)
    heading = driver.find_element(By.XPATH, "//div[@class='content']")
    print(heading.text)
    driver.find_element(By.ID, "actionButton").click()
    wait.until(expected_conditions.number_of_windows_to_be(3))
    print("Handles opened are: ", driver.window_handles)
    driver.switch_to.window(driver.window_handles[2])
    print("Title of the page is: " + driver.title)
    driver.quit()
