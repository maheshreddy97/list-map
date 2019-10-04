package org.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Sample {
	public static WebDriver driver;
	
	@Given("The user is in home page and click add customer")
	public void the_user_is_in_home_page_and_click_add_customer() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\greens tech\\Desktop\\mahesh\\Cucumber\\driver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://demo.guru99.com/telecom/index.html");
		driver.findElement(By.xpath("(//a[text()='Add Customer'])[1]")).click();
	}

	@When("The user enters the details and click submit")
	public void the_user_enters_the_details_and_click_submit(io.cucumber.datatable.DataTable dataTable) {
		List<String> l = dataTable.asList(String.class);
		driver.findElement(By.xpath("//label[@for='done']")).click();
	    driver.findElement(By.xpath("//input[@id='fname']")).sendKeys(l.get(0));
	    driver.findElement(By.xpath("//input[@id='lname']")).sendKeys(l.get(1));
	    driver.findElement(By.xpath("//input[@id='email']")).sendKeys(l.get(2));
	    driver.findElement(By.xpath("//textarea[@id='message']")).sendKeys(l.get(3));
	    driver.findElement(By.xpath("//input[@id='telephoneno']")).sendKeys(l.get(4));
	    driver.findElement(By.xpath("//input[@value='Submit']")).click();
	   
	
	}

	@Then("The user navigates to the page")
	public void the_user_navigates_to_the_page() {
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
