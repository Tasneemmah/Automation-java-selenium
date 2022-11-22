package swag_labs;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Home_Page {
	public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\my new drive\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();

		String userName = "standard_user";
		String password = "secret_sauce";
		
		driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys(userName);
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(password);
		driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
		
		int expectedItemsAdded = 6 ;
		List<WebElement> myButtons= driver.findElements(By .className("btn"));
//		System.out.println(myButtons.size());
		
		for (int i =0 ; i < myButtons.size(); i ++) {
			myButtons.get(i).click();
}
		String actualItemsAdded = driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a/span")).getText();
//		System.out.println(actualItemsAdded);
		
		int theRealNumber = Integer.parseInt(actualItemsAdded);
//		double theRealNumber = Double.parseDouble(actualItemsAdded); 
		
		Assert.assertEquals(theRealNumber, expectedItemsAdded);
			}
}
