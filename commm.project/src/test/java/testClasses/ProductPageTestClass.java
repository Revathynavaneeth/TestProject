package testClasses;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageClasses.HomePageClass;
import pageClasses.LoginPageClass;
import pageClasses.ManageUsersPageClass;
import pageClasses.ProductPageClass;

public class ProductPageTestClass extends BaseClass {
	LoginPageClass lp;
	HomePageClass hp;
	ManageUsersPageClass mp;
	ProductPageClass pp;

	@Test
	public void verifyProductsPageIsOpenWhileClickingOnListProducts() {
		lp = new LoginPageClass(driver);
		hp = lp.login("admin", "123456");
		hp.clickOnEndTour();
		hp.clickOnProducts();
		pp = hp.clickOnListProducts();
		String actualResult = pp.getTextOfProductTextHeading();
		System.out.println(actualResult);
		SoftAssert soft = new SoftAssert();
		soft.assertTrue(actualResult.contains("Products"));
		soft.assertAll();
	}

	@Test
	public void verifyTocreateA_newProduct() 
	{
		lp = new LoginPageClass(driver);
		hp = lp.login("admin", "123456");
		hp.clickOnEndTour();
		hp.clickOnProducts();
		pp = hp.clickOnListProducts();
		pp.addNewProdutct("Orange", "120",System.getProperty("user.dir")+"\\src\\test\\resources\\lord-vishnu-sree-padmanabhaswamy-temple-trivandrum.jpg", "30","150", "150");
		pp.searchAddedProductOnSearchBarAfterAddition("orange");
		String actualResult = pp.getTextOfAddedProductAfterSearch();
		System.out.println(actualResult);
		Assert.assertTrue(actualResult.contains("Orange"));
	}
	@Test
	
	public void verifyToDeleteAddedProduct()
	{
		lp = new LoginPageClass(driver);
		hp = lp.login("admin", "123456");
		hp.clickOnEndTour();
		hp.clickOnProducts();
		pp = hp.clickOnListProducts();
		pp.searchAddedProductOnSearchBarAfterAddition("orange");
		pp.deleteAddedProduct();
		String actualResult=pp.getTextOfNoMatchingRecordsAfterDeletion();
		Assert.assertTrue(actualResult.contains("records"));
	}
}

