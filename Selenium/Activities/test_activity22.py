from selenium import webdriver

from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager


def test_activity22():
    driver = webdriver.Firefox(service=FirefoxService(GeckoDriverManager().install()))
    actions = webdriver.ActionChains(driver)
    driver.get("https://www.training-support.net/selenium/popups")
    print("Title of the page is: " + driver.title)
    signInBtn = driver.find_element(By.XPATH, "//button[@data-tooltip='Click to sign in']")
    print("Tooltip message is: "+signInBtn.get_attribute("data-tooltip"))
    actions.move_to_element(signInBtn).perform()
    signInBtn.click()
    driver.find_element(By.ID, "username").send_keys("admin")
    driver.find_element(By.ID, "password").send_keys("password")
    driver.find_element(By.XPATH, "//button[text()='Log in']").click()
    print("Success message is displayed as: "+driver.find_element(By.ID, "action-confirmation").text)
    driver.quit()