from keyboard import press
from selenium.webdriver import Keys
from selenium.webdriver.common.by import By
from selenium import webdriver
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager


def test_act9():
    driver = webdriver.Firefox(service=FirefoxService(GeckoDriverManager().install()))
    actions = webdriver.ActionChains(driver)
    driver.get("http://alchemy.hguy.co:8080/orangehrm/symfony/web/index.php/auth/login")
    driver.find_element(By.ID, "txtUsername").send_keys("orange")
    driver.find_element(By.ID, "txtPassword").send_keys("orangepassword123")
    driver.find_element(By.ID, "btnLogin").click()
    driver.find_element(By.ID, "menu_pim_viewMyDetails").click()
    driver.find_element(By.XPATH, "//b[contains(text(),'PIM')]").click()
    driver.find_element(By.ID, "btnAdd").click()
    firstname = "uig";
    lastName = "sun";
    driver.find_element(By.ID, "firstName").send_keys(firstname)
    driver.find_element(By.ID, "lastName").send_keys(lastName)
    driver.find_element(By.ID, "btnSave").click()
    driver.find_element(By.XPATH, "//b[contains(text(),'PIM')]").click()
    searchEmp = driver.find_element(By.ID, "empsearch_employee_name_empName")
    searchEmp.click()
    searchEmp.clear()
    searchEmp.send_keys(firstname + " " + lastName)
    actions.key_down(Keys.PAGE_DOWN).perform()
    actions.key_up(Keys.PAGE_DOWN).perform()
    actions.send_keys(Keys.ENTER).perform()
    driver.find_element(By.ID, "searchBtn").click()
    assert driver.find_element(By.XPATH, "//*[@id='resultTable']/tbody/tr/td[3]/a").text == firstname
    assert driver.find_element(By.XPATH, "//*[@id='resultTable']/tbody/tr/td[4]/a").text == lastName
    driver.quit()
