from selenium.webdriver.common.by import By
from selenium import webdriver
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager


def test_act9():
    driver = webdriver.Firefox(service=FirefoxService(GeckoDriverManager().install()))
    driver.get("http://alchemy.hguy.co:8080/orangehrm/symfony/web/index.php/auth/login")
    driver.find_element(By.ID, "txtUsername").send_keys("orange")
    driver.find_element(By.ID, "txtPassword").send_keys("orangepassword123")
    driver.find_element(By.ID, "btnLogin").click()
    driver.find_element(By.ID, "menu_pim_viewMyDetails").click()
    driver.find_element(By.XPATH, "//a[contains(text(),'Emergency Contacts')]").click()
    telePhones = driver.find_elements(By.XPATH, "//table[@id='emgcontact_list']/tbody/tr/td[4]")
    for element in telePhones:
        if len(element.text) != 0:
            print("Home Telephones are: " + element.text)
    mobilePhones = driver.find_elements(By.XPATH, "//table[@id='emgcontact_list']/tbody/tr/td[5]")
    for element in mobilePhones:
        if len(element.text) != 0:
            print("Mobile Numbers are: " + element.text)

    driver.quit()
