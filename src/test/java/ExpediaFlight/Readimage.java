package ExpediaFlight;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.imageio.ImageIO;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;

public class Readimage {

	@Test
	public void expedia() throws IOException, InterruptedException
	{
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Pandiyan\\Documents\\chromedriver.exe");
		ChromeDriver driver  = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1600,1200));
		System.out.println("Window maximised");
		String baseUrl = "https://www.expedia.co.in/";
		driver.get(baseUrl);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement Flight = driver.findElement(By.xpath("//span[contains(.,'Flights')]"));
		Flight.getText();
		Flight.click();
		WebElement From = driver.findElement(By.xpath("//button[@aria-label='Leaving from']"));
		From.click();
		WebElement Fromflight = driver.findElement(By.xpath("//input[@id='location-field-leg1-origin']"));
		Fromflight.click();
		Fromflight.sendKeys("MAA");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//strong[contains(.,'Chennai (MAA - Chennai Intl.)')]")).click();
		WebElement Fromto = driver.findElement(By.xpath("//button[@aria-label='Going to']"));
		Fromto.click();
		WebElement To = driver.findElement(By.xpath("//input[@id='location-field-leg1-destination']"));
		To.click();
		To.sendKeys("DXB");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//strong[contains(.,'Dubai (DXB - All Airports)')]")).click();
		driver.findElement(By.xpath("//*[@id='d1-btn']")).click();
		driver.findElement(By.xpath("(//button[contains(@data-day,'15')])[2]")).click();
		driver.findElement(By.xpath("(//button[contains(@data-day,'20')])[2]")).click();
		driver.findElement(By.xpath(".//button/span[text()='Done']")).click();
		driver.findElement(By.xpath(".//button[text()='Search']")).click();
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='flightSearchResultDiv']/div[1]")));
		WebElement element = driver.findElement(By.xpath("//*[@id='flightSearchResultDiv']/div[1]"));
		Dimension a = element.getSize();
		System.out.println(a);
		String d = element.getText();
		System.out.println(d);
		JavascriptExecutor js = driver;
		js.executeScript("window.scrollBy(0,100)");
		Thread.sleep(2000);
		Screenshot Resultspage = new AShot().takeScreenshot(driver,element);
		ImageIO.write(Resultspage.getImage(),"png",new File("C:\\Users\\Pandiyan\\eclipse-workspace\\Expedia\\Folder2\\test.png"));
		File f = new File ("C:\\Users\\Pandiyan\\eclipse-workspace\\Expedia\\Folder2\\test.png");
		if(f.exists())
		{
			System.out.println("Image File captured ");
		}
		else
		{
			System.out.println("Image file not captured ");
		}
		driver.close();

	}}
