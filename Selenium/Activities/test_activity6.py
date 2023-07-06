from selenium import webdriver
from selenium.webdriver import Keys
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager


def test_activity6():
    driver = webdriver.Firefox(service=FirefoxService(GeckoDriverManager().install()))
    actions = webdriver.ActionChains(driver)
    driver.get("https://training-support.net/selenium/input-events")
    print("Title of the page is: " + driver.title)
    actions.send_keys("P").perform()
    actions.key_down(Keys.CONTROL).send_keys("A").send_keys("C").key_up(Keys.CONTROL).perform()
    driver.quit()
