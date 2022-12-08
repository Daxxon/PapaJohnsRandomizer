package com.example.PizzaRandomizer;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Assertions;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

@SpringBootTest
class PizzaRandomizerApplicationTests {

	@Test
	void testPageOpenAndClose() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		WebDriver driver=new ChromeDriver(options);

		// Launch Website
		driver.navigate().to("http://www.javatpoint.com/");

		//Maximize the browser
		driver.manage().window().maximize();

		ChromeDriverFixer.printSystemLog();

		//Close the browser
		driver.close();
	}

	@Test
	void testLogInLogOut() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		WebDriver driver=new ChromeDriver(options);

		// Launch Website
		driver.navigate().to("http://www.papajohns.com/");

		//Maximize the browser
		driver.manage().window().maximize();
		Actions actions = new Actions(driver);

		WebElement loginMenu = driver.findElement(By.xpath("/html/body/div[2]/header/section[1]/header/ul/li[3]/a"));
		actions.moveToElement(loginMenu).perform();
		loginMenu.click();

		WebElement user = new WebDriverWait(driver, 1).until(ExpectedConditions.visibilityOfElementLocated(By.id("header-account-sign-in-email")));
		//driver.findElement(By.id("header-account-sign-in-email"));
		actions.moveToElement(user).perform();
		user.click();
		user.sendKeys("daxxon37@hotmail.com");


		WebElement password = driver.findElement(By.id("header-account-sign-in-password"));
		actions.moveToElement(password).perform();
		password.click();
		password.sendKeys("Milkshake37");


		WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"header-account-sign-in-form\"]/div[5]/input"));
		actions.moveToElement(loginButton).perform();
		loginButton.click();


		String greeting = driver.findElement(By.xpath("//a[@class='popup-trigger' and contains(text(),\"Hi, \")]")).getText();
		Assertions.assertTrue(greeting.contains("Hi, "));

		//Close the browser
		driver.close();
	}

}
