from selenium.webdriver.common.by import By
from selenium import webdriver
from selenium.webdriver.firefox.service import Service as FirefoxService
from selenium.webdriver.support.select import Select
from webdriver_manager.firefox import GeckoDriverManager


def test_act5():
    driver = webdriver.Firefox(service=FirefoxService(GeckoDriverManager().install()))
    driver.get("http://alchemy.hguy.co:8080/orangehrm/symfony/web/index.php/auth/login")
    driver.find_element(By.ID, "txtUsername").send_keys("orange")
    driver.find_element(By.ID, "txtPassword").send_keys("orangepassword123")
    driver.find_element(By.ID, "btnLogin").click()
    driver.find_element(By.ID, "menu_pim_viewMyDetails").click()
    driver.find_element(By.XPATH, "//input[@value='Edit']").click()
    firstName= driver.find_element(By.ID, "personal_txtEmpFirstName")
    firstName .clear()
    firstName.send_keys("Ken")
    lastName = driver.find_element(By.ID, "personal_txtEmpLastName")
    lastName.clear()
    lastName.send_keys("Ryuguji")
    driver.find_element(By.ID, "personal_DOB").click()
    dropDownYear = driver.find_element(By.CLASS_NAME, "ui-datepicker-year")
    selectValue = Select(dropDownYear);
    selectValue.select_by_value("1998");
    dropDownMonth = driver.find_element(By.CLASS_NAME,"ui-datepicker-month");
    selectValue2 = Select(dropDownMonth);
    selectValue2.select_by_visible_text("May");
    driver.find_element(By.XPATH, "//a[contains(@class,'ui-state-default') and contains(text(),'15')]").click()
    driver.find_element(By.XPATH,"//input[@value='Save']").click()
    driver.quit()
