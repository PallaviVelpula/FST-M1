from selenium import webdriver

from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager


def test_activity7():
    driver = webdriver.Firefox(service=FirefoxService(GeckoDriverManager().install()))
    actions = webdriver.ActionChains(driver)
    driver.get("https://training-support.net/selenium/drag-drop")
    print("Title of the page is: " + driver.title)
    football = driver.find_element(By.ID, "draggable")
    dropzone1 = driver.find_element(By.ID, "droppable")
    dropzone2 = driver.find_element(By.ID, "dropzone2")
    actions.drag_and_drop(football, dropzone1).perform()
    actions.drag_and_drop(football, dropzone2).perform()
    driver.quit()
