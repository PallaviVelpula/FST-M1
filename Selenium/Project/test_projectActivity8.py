from selenium.webdriver.common.by import By
from selenium import webdriver
from selenium.webdriver.firefox.service import Service as FirefoxService
from selenium.webdriver.support.select import Select
from webdriver_manager.firefox import GeckoDriverManager
from keyboard import press


def test_act8():
    driver = webdriver.Firefox(service=FirefoxService(GeckoDriverManager().install()))
    driver.get("http://alchemy.hguy.co:8080/orangehrm/symfony/web/index.php/auth/login")
    driver.find_element(By.ID, "txtUsername").send_keys("orange")
    driver.find_element(By.ID, "txtPassword").send_keys("orangepassword123")
    driver.find_element(By.ID, "btnLogin").click()
    driver.find_element(By.XPATH, "//span[contains(text(),'Apply Leave')]").click()
    leaveType = driver.find_element(By.ID, "applyleave_txtLeaveType")
    selectValue = Select(leaveType)
    selectValue.select_by_value("1")
    driver.find_element(By.ID, "applyleave_txtFromDate").clear()
    fromDate = "2023-08-21";
    toDate = "2023-08-22";
    driver.find_element(By.ID, "applyleave_txtFromDate").send_keys(fromDate)
    driver.find_element(By.ID, "applyleave_txtToDate").clear()
    driver.find_element(By.ID, "applyleave_txtToDate").send_keys(toDate)
    press('ENTER')
    driver.find_element(By.ID, "applyBtn").click()
    driver.find_element(By.ID, "menu_leave_viewMyLeaveList").click()

    # search for applied leave
    driver.find_element(By.ID, "calFromDate").clear()
    driver.find_element(By.ID, "calFromDate").send_keys(fromDate)
    driver.find_element(By.ID, "calToDate").clear()
    driver.find_element(By.ID, "calToDate").send_keys(toDate)
    press('ENTER')
    driver.find_element(By.ID, "btnSearch").click()
    assert "Pending Approval" in driver.find_element(By.XPATH, "(//table[@id='resultTable']/tbody/tr/td/a)[3]").text
    driver.quit()
