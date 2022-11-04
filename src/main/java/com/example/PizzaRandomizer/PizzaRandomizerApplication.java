package com.example.PizzaRandomizer;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@SpringBootApplication
public class PizzaRandomizerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PizzaRandomizerApplication.class, args);

		WebDriverManager.chromedriver().setup();

		ChromeOptions options = new ChromeOptions();

		WebDriver driver=new ChromeDriver(options);

		// Launch Website
		driver.navigate().to("http://www.javatpoint.com/");

		//Maximize the browser
		driver.manage().window().maximize();

		//Scroll down the webpage by 5000 pixels
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scrollBy(0, 5000)");

		// Click on the Search button
		driver.findElement(By.linkText("Core Java")).click();
	}

}
