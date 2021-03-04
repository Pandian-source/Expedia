package ExpediaFlight;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
public class Flight {
	
	@Test
	public void expedia() throws IOException
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Pandiyan\\Documents\\chromedriver.exe");
		ChromeDriver driver  = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("Window maximised");
		String baseUrl = "https://www.expedia.co.in/";
		driver.get(baseUrl);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement Flight = driver.findElement(By.xpath("//span[contains(.,'Flights')]"));
		Flight.getText();
		Flight.click();
		Screenshot Searchpage = new AShot().takeScreenshot(driver);
		ImageIO.write(Searchpage.getImage(),"png",new File("C:\\Users\\Pandiyan\\eclipse-workspace\\Expedia\\Folder1\\Expedia.png"));
		File f = new File ("C:\\Users\\Pandiyan\\eclipse-workspace\\Expedia\\Folder1\\Expedia.png");
		if(f.exists())
		{
			System.out.println("Image File captured ");
		}
		else
		{
			System.out.println("Image file not captured ");
		}
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
		driver.findElement(By.xpath("(//button[@data-day='15'])[2]")).click();
		driver.findElement(By.xpath("(//button[@data-day='20'])[2]")).click();
		driver.findElement(By.xpath(".//button/span[text()='Done']")).click();
		driver.findElement(By.xpath(".//button[text()='Search']")).click();
		WebDriverWait wait = new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//p[contains(.,'No change fees')])[1]")));
	    WebElement Results = driver.findElement(By.xpath("(//div[@data-test-id='listing-main'])[1]"));
		System.out.println("***********************FIRST ROW RESULTS DATA**********************************");
		String a = Results.getText();
		System.out.println(a);
		driver.close();
		}

	@Test
	public void expedianewmethod() throws IOException
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Pandiyan\\Documents\\chromedriver.exe");
		ChromeDriver driver  = new ChromeDriver();
		driver.manage().window().maximize();
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
		driver.findElement(By.xpath("(//button[@data-day='15'])[2]")).click();
		driver.findElement(By.xpath("(//button[@data-day='20'])[2]")).click();
		driver.findElement(By.xpath(".//button/span[text()='Done']")).click();
		driver.findElement(By.xpath(".//button[text()='Search']")).click();
		WebDriverWait wait = new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//p[contains(.,'No change fees')])[1]")));
	    
	    String beforeXpath = "(//div[@data-test-id='listing-main'])[";
	    String afterXpath  = "]";
	    List<WebElement> Totalresults = driver.findElements(By.xpath("(//div[@data-test-id='listing-main'])"));
	    System.out.println("Flight Results count is = "+ Totalresults.size());
	    int totalcount = Totalresults.size();
	    for (int i=1; i<=totalcount; i++)
	    {
	    	System.out.println("*************************FLIGHT RESULTS*******************************");
	    	System.out.println(i + " ST ROW FLIGHT DATA");
	    	String actualXpath = beforeXpath+i+afterXpath;
	    	String Element = driver.findElement(By.xpath(actualXpath)).getText();
	    	System.out.println(Element);
	    	}
		driver.close();
	}}
