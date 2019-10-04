package org.test;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Sample4 {
	public static WebDriver driver;

@Given("The user is in home page and click add button")
public void the_user_is_in_home_page_and_click_add_button() {
	System.setProperty("webdriver.chrome.driver","C:\\Users\\greens tech\\Desktop\\mahesh\\Cucumber\\driver\\chromedriver.exe");
	driver=new ChromeDriver();
	driver.get("http://demo.guru99.com/telecom/index.html");
	driver.findElement(By.xpath("(//a[text()='Add Customer'])[1]")).click();
}

@When("The user enters details then click submit")
public void the_user_enters_details_then_click_submit(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
	List<Map<String,String>> m1 = dataTable.asMaps(String.class,String.class);
	driver.findElement(By.xpath("//label[@for='done']")).click();
    driver.findElement(By.xpath("//input[@id='fname']")).sendKeys(m1.get(1).get("fname"));
    Thread.sleep(3000);
    driver.findElement(By.xpath("//input[@id='lname']")).sendKeys(m1.get(1).get("lname"));
    driver.findElement(By.xpath("//input[@id='email']")).sendKeys(m1.get(1).get("email"));
    driver.findElement(By.xpath("//textarea[@id='message']")).sendKeys(m1.get(1).get("address"));
    driver.findElement(By.xpath("//input[@id='telephoneno']")).sendKeys(m1.get(1).get("phno"));
    JavascriptExecutor j=(JavascriptExecutor)driver;
    WebElement e = driver.findElement(By.xpath("//input[@value='Submit']"));
    j.executeScript("arguments[0].click()",e);
    
}
    @Then("The user navigates to next page")
public void the_user_navigates_to_next_page() {
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
