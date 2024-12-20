package testClasses;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageClasses.HomePageClass;
import pageClasses.LoginPageClass;
import pageClasses.ManageUsersPageClass;

public class ManageUsersTestClass extends BaseClass
{
  
	LoginPageClass lp;
	HomePageClass hp;
	ManageUsersPageClass mp;
	
	 @Test
	  
	  public void verifyTheManagerUsersPageIsOpenWhileClickingOnUsers()
	  {
		  lp=new LoginPageClass(driver);
		  hp = lp.login("admin", "123456");
		  hp.clickOnEndTour(); 
		  hp.clickOnUserManagement();
		  mp= hp.clickOnUsers();
		  String actualResult = mp.getTextOfManageUser();
		  Assert.assertTrue(actualResult.contains("Manage"));
	  }
	 @Test
	 
	public void verifyToAddNewUser()
	 {

		  lp=new LoginPageClass(driver);
		  hp = lp.login("admin", "123456");
		  hp.clickOnEndTour();  
		  hp.clickOnUserManagement();
		  mp=hp.clickOnUsers();
		  mp.addNewUser("Revathy","revath87y@gmail.com","123456","123456");
		  mp.searchAddedUserInTheSearchBar("Revathy");
		  String actualResult = mp.getTextOfSearchName();
		  System.out.println(actualResult);
		  Assert.assertTrue(actualResult.contains("5205"));
	 }
}
					
 

	

