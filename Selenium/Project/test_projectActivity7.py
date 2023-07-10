from selenium.webdriver.common.by import By
from selenium import webdriver
from selenium.webdriver.firefox.service import Service as FirefoxService
from selenium.webdriver.support.select import Select
from webdriver_manager.firefox import GeckoDriverManager


def test_act7():
    driver = webdriver.Firefox(service=FirefoxService(GeckoDriverManager().install()))
    driver.get("http://alchemy.hguy.co:8080/orangehrm/symfony/web/index.php/auth/login")
    driver.find_element(By.ID, "txtUsername").send_keys("orange")
    driver.find_element(By.ID, "txtPassword").send_keys("orangepassword123")
    driver.find_element(By.ID, "btnLogin").click()
    driver.find_element(By.ID, "menu_pim_viewMyDetails").click()
    driver.find_element(By.XPATH, "(//a[contains(text(),'Qualifications')])[2]").click()
    driver.find_element(By.ID, "addWorkExperience").click()
    driver.find_element(By.ID, "experience_employer").send_keys("Wipro")
    driver.find_element(By.ID, "experience_jobtitle").send_keys("Quality Engineer")
    driver.find_element(By.ID, "btnWorkExpSave").click()
    driver.quit()
