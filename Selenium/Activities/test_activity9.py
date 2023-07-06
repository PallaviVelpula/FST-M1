from selenium import webdriver

from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from selenium.webdriver.support import expected_conditions
from selenium.webdriver.support.wait import WebDriverWait
from webdriver_manager.firefox import GeckoDriverManager


def test_activity9():
    driver = webdriver.Firefox(service=FirefoxService(GeckoDriverManager().install()))
    wait = WebDriverWait(driver, 10)
    driver.get("https://www.training-support.net/selenium/ajax")
    print("Title of the page is: " + driver.title)
    driver.find_element(By.XPATH, "//button[contains(text(),'Change Content')]").click()
    wait.until(expected_conditions.visibility_of(driver.find_element(By.XPATH, "//h1[contains(text(),'HELLO!')]")))
    print("Message on the page is: " + driver.find_element(By.XPATH, "//h3").text)
    wait.until(expected_conditions.text_to_be_present_in_element((By.TAG_NAME, "h3"), "I'm late!"))
    print("Message on the page after a few seconds is: " + driver.find_element(By.TAG_NAME, "h3").text)
    driver.quit()
