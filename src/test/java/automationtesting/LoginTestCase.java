package automationtesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTestCase {

	public static void main(String[] args) {

		// 1. open web browser(chrome)
		WebDriver driver = new ChromeDriver(); // constructor call that creates a new instance of the ChromeDriver class
												// of type WebDriver interface

		driver.manage().window().maximize(); // open browser in maximise window

		// 2. open url- https://the-internet.herokuapp.com/
		driver.get("https://the-internet.herokuapp.com/");

		// 3. click on Form Authentication link
		driver.findElement(By.linkText("Form Authentication")).click();

		// 4. enter username
		WebElement usernameText = driver.findElement(By.xpath("//*[@id='username']"));
		usernameText.sendKeys("tomsmith");

		// 5. enter password
		WebElement passwordText = driver.findElement(By.xpath("//*[@id='password']"));
		passwordText.sendKeys("SuperSecretPassword!");

		// 6. click on login
		WebElement loginButton = driver.findElement(By.xpath("//*[@id='login']/button/i"));
		loginButton.click();

		// 7. verify logged in page title
		WebElement confirmEle = driver.findElement(By.xpath("//*[@id=\"flash\"]"));

		String confirmText = confirmEle.getText();

		String result = confirmText.contains("You logged into a secure area!") ? "login test successful"
				: "login test failed";

		System.out.println(result);

		// close the browser
		driver.close();
	}

}
