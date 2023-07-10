from selenium.webdriver.common.by import By
from selenium import webdriver
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager


def test_act2():
    driver = webdriver.Firefox(service=FirefoxService(GeckoDriverManager().install()))
    driver.get("http://alchemy.hguy.co/orangehrm")
    element = driver.find_element(By.XPATH, "//div[@id='divLogo']/img").get_attribute("src")
    print("Header logo is: " + element)
    driver.quit()
