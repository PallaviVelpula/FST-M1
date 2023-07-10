from selenium.webdriver.common.by import By
from selenium import webdriver
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager


def test_act6():
    driver = webdriver.Firefox(service=FirefoxService(GeckoDriverManager().install()))
    driver.get("http://alchemy.hguy.co:8080/orangehrm/symfony/web/index.php/auth/login")
    driver.find_element(By.ID, "txtUsername").send_keys("orange")
    driver.find_element(By.ID, "txtPassword").send_keys("orangepassword123")
    driver.find_element(By.ID, "btnLogin").click()
    driver.find_element(By.XPATH, "//h1[contains(text(),'Dashboard')]").click()

    directoryMenu = driver.find_element(By.ID, "menu_directory_viewDirectory")
    if directoryMenu.is_displayed():
        directoryMenu.click()
    directoryHeading = driver.find_element(By.XPATH, "//div[@class='head']/h1").text
    assert directoryHeading == "Search Directory"
    driver.quit()
