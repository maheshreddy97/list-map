package org.test;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Sample3 {
	public static WebDriver driver;

@Given("The user is in home page and click  customer")
public void the_user_is_in_home_page_and_click_customer() {
	System.setProperty("webdriver.chrome.driver","C:\\Users\\greens tech\\Desktop\\mahesh\\Cucumber\\driver\\chromedriver.exe");
	driver=new ChromeDriver();
	driver.get("http://demo.guru99.com/telecom/index.html");
	driver.findElement(By.xpath("(//a[text()='Add Customer'])[1]")).click();
}

@When("The user enters details and then click submit")
public void the_user_enters_details_and_then_click_submit(io.cucumber.datatable.DataTable dataTable) {
	Map<String,String> m = dataTable.asMap(String.class,String.class);
	driver.findElement(By.xpath("//label[@for='done']")).click();
    driver.findElement(By.xpath("//input[@id='fname']")).sendKeys(m.get("fname"));
    driver.findElement(By.xpath("//input[@id='lname']")).sendKeys(m.get("lname"));
    driver.findElement(By.xpath("//input[@id='email']")).sendKeys(m.get("email"));
    driver.findElement(By.xpath("//textarea[@id='message']")).sendKeys(m.get("address"));
    driver.findElement(By.xpath("//input[@id='telephoneno']")).sendKeys(m.get("phno"));
    driver.findElement(By.xpath("//input[@value='Submit']")).click();

}

@Then("The user navigates to home page")
public void the_user_navigates_to_home_page() {
	WebElement txt = driver.findElement(By.xpath("//b[text()='Please Note Down Your CustomerID']"));
	String text = txt.getText();
	if(text.contains("CustomerID")) {
		System.out.println("success");
	}
	else {
		System.out.println("failed");
	}
}
}
