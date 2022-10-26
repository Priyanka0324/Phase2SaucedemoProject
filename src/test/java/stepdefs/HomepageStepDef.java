package stepdefs;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomepageStepDef {

	WebDriver driver = Hooks.driver ; //Here the we are using the hooks class for driver	

	int CartItem = 0;
	int result =0;

		@When("I add below product as {string}")
		public void i_add_below_product_as(String ProductName) {
			
			// Adding a product into the cart
			String xpath = "//div[text()='" + ProductName + "']//following::button[1]";
			WebElement product = driver.findElement(By.xpath(xpath));
			product.click();	
			
		}

	@Then("I should have cart item updated as to be {int}")
	public void i_should_have_cart_item_updated_as_to_be(int expResult) {
		
		//Validating if the cart value is incremented to 1 after adding a item/product to cart
		WebElement CartProduct = driver.findElement(By.id("shopping_cart_container"));
		CartItem = Integer.parseInt(CartProduct.getText());
		Assert.assertEquals(expResult, CartItem);
		System.out.println("The item in cart is " +CartItem);
		
	}
	
	
	@When("I add below Products")
	public void i_add_below_Products(List<String> Products) {
		
		// Adding multiple products into the cart
		for(String products : Products) {
			String xpath = "//div[text()='" +  products + "']//following::button[1]";
			WebElement ProductName = driver.findElement(By.xpath(xpath));
			ProductName.click();
		}
	  
	}

	@Then("Cart item count should be {int}")
	public void cart_item_count_should_be(int result) {
		
		//Validating if the cart value is incremented to 3 after adding items/products to cart
		WebElement CartProduct = driver.findElement(By.id("shopping_cart_container"));
		CartItem = Integer.parseInt(CartProduct.getText());
		Assert.assertEquals(result, CartItem);
		System.out.println("The item in cart is " +CartItem);
	}
	
	
}