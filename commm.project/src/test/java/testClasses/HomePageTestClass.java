package testClasses;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageClasses.HomePageClass;
import pageClasses.LoginPageClass;

public class HomePageTestClass extends BaseClass 
{
	LoginPageClass lp;
	HomePageClass hp;
	ManageUsersTestClass mp;
  @Test
  public void verifyTheCountOfTilesDisplayedOnHomePage() 
  {
	  lp = new LoginPageClass(driver);
	  hp = lp.login("admin", "123456");
	  hp.clickOnEndTour();
	  
	  boolean actualResult = hp.isAllTilesDisplayed();
	  Assert.assertTrue(actualResult);
 }
  @Test
  
  public void verifyTheTooltip_Calculator_isShowingWhileHoveringTheMouseOnCalculator()
  {
	  lp=new LoginPageClass(driver);
	  hp = lp.login("admin", "123456");
	  hp.clickOnEndTour();
	  hp.hoverMouseOverCalculatorButton();
	  String actualResult = hp.getAttributeValueOfCalculatorButton("data-original-title");
	  //String expectedResult = "Calculator";
	  Assert.assertTrue(actualResult.contains("Calculator"));
	  System.out.println(actualResult);
	  
  }
  @Test
  public void verifySuccessfullSignOut()
  {
	  lp=new LoginPageClass(driver);
	  hp = lp.login("admin", "123456");
	  hp.clickOnEndTour();
	  hp.clickOnAdminButton();
	  lp= hp.clickOnSignOutButton();
	  String actualResult=lp.getTextOfLoginAfterSuccessfullSignout();
	  System.out.println(actualResult);
	  SoftAssert soft = new SoftAssert();
		soft.assertTrue(actualResult.contains("Login"));
		soft.assertAll();
  }
 

 
}
