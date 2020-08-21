package mypackage;
import java.util.HashMap;

import org.openqa.selenium.* ;  //contains a web driver class needed to instantiate a new browser associated with the driver
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.pagefactory.ElementLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class myfirstview {
	
	

	public static void main(String[] args) throws InterruptedException
	{
		// TODO Auto-generated method stub
		
		//set properties for client drivers
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Tejashri\\Documents\\chromedriver_version\\chromedriver.exe");
	
	//System.setProperty("webdriver.gecko.driver","C:\\Users\\Tejashri\\Downloads\\geckodriver-v0.26.0-win64\\geckodriver.exe");
		
		//Initiate instance for client drivers
	
		//WebDriver firefoxdriver=new FirefoxDriver();
		ChromeOptions options=new ChromeOptions();
		options.setAcceptInsecureCerts(true);
		WebDriver chromedriver=new ChromeDriver(options);
		
		String baseurl="https://test.legalnextt.com/";
		
		
		chromedriver.get(baseurl);
	  //  firefoxdriver.get(baseurl);

		
       //enter element by id and submit
	 /*   firefoxdriver.findElement(By.id("UserName")).sendKeys("nahush.shukla@legalnextt.com");
	    firefoxdriver.findElement(By.id("Password")).sendKeys("Nahush@123");	  
	    firefoxdriver.findElement(By.xpath("//*[@class='btn btn-primary']")).submit();
	
	    System.out.println(firefoxdriver.getCurrentUrl());
	    
	    Thread.sleep(500);
	    firefoxdriver.findElement(By.xpath("//i[@id='UserMenu']")).click();
	    Thread.sleep(500);
	    firefoxdriver.findElement(By.xpath("//span[@class='fa-sign-out']")).click();*/
	    
	   	//Login on website
		chromedriver.findElement(By.id("UserName")).sendKeys("nahush.shukla@legalnextt.com");
	    chromedriver.findElement(By.id("Password")).sendKeys("Nahush@123");	   
	    chromedriver.findElement(By.xpath("//*[@class='btn btn-primary']")).click();
	    
	    //MyDiary events
		chromedriver.findElement(By.xpath("//a[@id='weeklink']")).click();
		//implement(chromedriver);
		WebDriverWait diarywidget = new WebDriverWait(chromedriver, 11);
		WebElement widgetelement = diarywidget.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[@class='k-today']")));
		chromedriver.findElement(By.xpath("//td[@class='k-today']")).click();
		//[@class='k-callout k-callout-s']
		//WebElement widgetelement = diarywidget.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='k-callout k-callout-s']")));
		//chromedriver.findElement(By.xpath("//*[@class='k-callout k-callout-s']")).click();
		
		//Add an Appointment 			    	    
	    WebDriverWait appointment = new WebDriverWait(chromedriver, 10);
	    WebElement appointmentevent = appointment.until(ExpectedConditions.visibilityOfElementLocated(By.id("appointmentTitle")));
	    chromedriver.findElement(By.id("appointmentTitle")).sendKeys("To meet Ms.Reema Kagti");
		chromedriver.findElement(By.id("appointmentpurpose")).sendKeys("To meet a client and understand the case");
		chromedriver.findElement(By.id("appointmentdescription")).sendKeys("describe the case");
		chromedriver.findElement(By.xpath("//span[@class='k-select' and @aria-controls='Client_listbox']")).click();		
		WebDriverWait selectclient = new WebDriverWait(chromedriver, 10);
	    WebElement clientelement = selectclient.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@role='option' and @data-offset-index='2']")));
	    chromedriver.findElement(By.xpath("//li[@role='option' and @data-offset-index='3']")).click();	    
	    WebDriverWait saveappointment = new WebDriverWait(chromedriver, 10);
	    WebElement saveelement = saveappointment.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Save']")));
	    chromedriver.findElement(By.xpath("//a[text()='Save']")).click(); 	  
	    
	    //Add an event
	/*    WebDriverWait diarywidget1 = new WebDriverWait(chromedriver, 11);
		WebElement widgetelement1 = diarywidget.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[@class='k-today']")));
		chromedriver.findElement(By.xpath("//td[@class='k-today']")).click();
	    
	    WebDriverWait event=new WebDriverWait(chromedriver,10);
	    WebElement eventadd=event.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Event/Meeting']")));
	    chromedriver.findElement(By.id("eventTitle")).sendKeys("Meet a set or crimincal lawyers");
	    chromedriver.findElement(By.id("eventpurpose")).sendKeys("To understand handling of lawyers");
	    chromedriver.findElement(By.id("eventdescription")).sendKeys("To understand how to tackle criminal cases");
	    chromedriver.findElement(By.xpath("//span[@class='k-select' and @aria-controls='Client_listbox']")).click();		
		WebDriverWait client = new WebDriverWait(chromedriver, 10);
	    WebElement elementselectclient = client.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@role='option' and @data-offset-index='2']")));
	    chromedriver.findElement(By.xpath("//li[@role='option' and @data-offset-index='3']")).click();	
	    WebDriverWait saveevent = new WebDriverWait(chromedriver, 20);
	    WebElement saveeventelement = saveevent.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Save']")));
	    chromedriver.findElement(By.xpath("//a[text()='Save']")).click(); 
	    
	    //Task appointment
	    chromedriver.findElement(By.xpath("//span[@class='k-link' and text()='Task']")).click();
	    chromedriver.findElement(By.id("tasktitle")).click();
	    chromedriver.findElement(By.id("taskpurpose")).click();
	    chromedriver.findElement(By.id("taskdescription")).click();
	    chromedriver.findElement(By.xpath("//span[@class='k-select' and @aria-controls='Client_listbox']")).click();		
		WebDriverWait taskclient = new WebDriverWait(chromedriver, 10);
	    WebElement taskselectclient = client.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@role='option' and @data-offset-index='2']")));
	    chromedriver.findElement(By.xpath("//li[@role='option' and @data-offset-index='3']")).click();	
	    WebDriverWait saveevent1 = new WebDriverWait(chromedriver, 20);
	    WebElement saveeventelement1 = saveevent1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Save']")));
	    chromedriver.findElement(By.xpath("//a[text()='Save']")).click(); */
	    
	    
	    Clientpage clientmodule=new Clientpage();
	    clientmodule.clientdriver(chromedriver);

	    //Logout
	    WebDriverWait usermenu = new WebDriverWait(chromedriver, 30);
	    WebElement menudropdown = usermenu.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@id='UserMenu']")));
	    chromedriver.findElement(By.xpath("//i[@id='UserMenu']")).click(); 
	    chromedriver.findElement(By.xpath("//span[@class='fa-sign-out']")).click();	  
	    
}
		

public static void implement(WebDriver chromedriver) 
{
	    
		WebDriverWait diarywidget = new WebDriverWait(chromedriver, 11);
		WebElement widgetelement = diarywidget.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[@class='k-today']")));
		chromedriver.findElement(By.xpath("//td[@class='k-today']")).click();
}
}


