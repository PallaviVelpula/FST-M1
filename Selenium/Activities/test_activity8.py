from selenium import webdriver

from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from selenium.webdriver.support import expected_conditions
from selenium.webdriver.support.wait import WebDriverWait
from webdriver_manager.firefox import GeckoDriverManager


def test_activity8():
    driver = webdriver.Firefox(service=FirefoxService(GeckoDriverManager().install()))
    wait = WebDriverWait(driver, 10)
    driver.get("https://www.training-support.net/selenium/dynamic-controls")
    print("Title of the page is: " + driver.title)
    checkbox = driver.find_element(By.ID, "toggleCheckbox")
    checkbox.click()
    wait.until(expected_conditions.invisibility_of_element_located(driver.find_element(By.ID, "dynamicCheckbox")))
    checkbox.click()
    driver.find_element(By.ID, "dynamicCheckbox").is_displayed()
    driver.find_element(By.NAME, "toggled").click()
    driver.quit()
