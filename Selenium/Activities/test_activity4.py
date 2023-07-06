from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager


def test_activity4():
    driver = webdriver.Firefox(service=FirefoxService(GeckoDriverManager().install()))
    driver.get("https://training-support.net/selenium/target-practice")
    print("Title of the page is: " + driver.title)
    print("Text of third header is: " + driver.find_element(By.XPATH, "//h3[@class='ui yellow header']").text)
    print("Colour of fifth header is: " + driver.find_element(
        By.XPATH, "//h5[@class='ui green header']").value_of_css_property("color"))
    print("Class of violet button is: " + driver.find_element(By.XPATH,
                                                              "//button[@class='ui violet button']").get_attribute(
        "class"))
    print("Text of grey button is: " + driver.find_element(By.CSS_SELECTOR, ".ui.green.button").text)
    driver.quit()
