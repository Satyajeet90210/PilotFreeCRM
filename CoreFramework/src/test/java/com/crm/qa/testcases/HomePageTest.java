package com.crm.qa.testcases;
import com.crm.qa.pages.LoginPage;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.util.TestUtil;
public class HomePageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	public HomePageTest(){
		 super();
	}
	@BeforeMethod
	public void setUp() throws InterruptedException{
		 initialization();
		 loginPage = new LoginPage();
		 homePage = new HomePage();
		 loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		 Thread.sleep(5000);
		 System.out.println("after setup");
	}
	@Test
	public void VerifyhomepageTitle() throws InterruptedException{
		 Assert.assertEquals(homePage.verifyPageTitle(),"CRM","Home Page Tiltle is wrong");
		 
	}
	@Test(enabled = true)
	public void CheckLoggedinUser(){
		System.out.println(homePage.UserLable.getText());
		
	}
	@AfterMethod
	public void tearDown(){
		 driver.quit();
	}
}
