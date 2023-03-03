package com.Base;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Enum.Locators;

public class CommonMethods extends PageInitialize {

	public static Select select;
	public static Actions actions;
	public static WebDriverWait wait;
	public static TakesScreenshot ScreenShot;

	

// Webdriver methods
	public static void setUrl(String value) {
		driver.get(value);
	}
	
	public static String getURL(){
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}

	public static String getPageTitle(){
		String title = driver.getTitle();
		return title;
	}


// WebElement methods
	
public WebElement element(Locators type, String Value) {
		
		try {
			switch (type) {
			case id:
				return driver.findElement(By.id(Value));
			case xpath:
				return driver.findElement(By.xpath(Value));
			case linkText:
				return driver.findElement(By.linkText(Value));
			case tagName:
				return driver.findElement(By.tagName(Value));
			case className:
				return driver.findElement(By.className(Value));
			case name:
				return driver.findElement(By.name(Value));
			case css:
				return driver.findElement(By.cssSelector(Value));
			default:
				break;
			}
		} catch (NoSuchElementException e) {
			System.err.println("Element not found => "+e.getMessage());
			throw new NoSuchElementException("Element not found");
		}catch(WebDriverException e) {
			System.err.println(e.getMessage());
			throw new WebDriverException("Some unknown webdriver error");
		}catch(Exception e) {
			System.err.println(e.getMessage());
		}
		
		return null;
	}
	
	public List<WebElement> elements(Locators type, String Value) {
		try {
			switch (type) {
			case id:
				return driver.findElements(By.id(Value));
			case xpath:
				return driver.findElements(By.xpath(Value));
			case linkText:
				return driver.findElements(By.linkText(Value));
			case tagName:
				return driver.findElements(By.tagName(Value));
			case className:
				return driver.findElements(By.className(Value));
			case name:
				return driver.findElements(By.name(Value));
			case css:
				return driver.findElements(By.cssSelector(Value));
			default:
				break;
			}
		} catch (NoSuchElementException e) {
			System.err.println("Element not found => "+e.getMessage());
			throw new NoSuchElementException("Element not found");
		}catch(WebDriverException e) {
			System.err.println(e.getMessage());
			throw new WebDriverException("Some unknown webdriver error");
		}catch(Exception e) {
			System.err.println(e.getMessage());
		}
		return null;
	
	}
	
	public static String getElementText(WebElement element) {
		return element.getText();
	}
	
	public static String getAttributeName(WebElement element, String value) {
		String attribute = element.getAttribute(value);
		return attribute;
	}

	public static void passKeys(WebElement element, String value) {
		element.sendKeys(value);
	}

	public static void submit(WebElement element) {
		element.click();
	}

	public static void close() {
		driver.close();
	}

	public static boolean enabled(WebElement element) {
		boolean enabled = element.isEnabled();
		return enabled;
	}

	public static boolean displayed(WebElement element) {
		boolean displayed = element.isDisplayed();
		return displayed;
	}

	public static boolean selected(WebElement element) {
		boolean selected = element.isSelected();
		return selected;
	}

// Dropdown methods
	
	public static void selectValue(WebElement element, String value) {
		new Select(element).selectByValue(value);
	}

	public static void selectText(WebElement element, String value) {
		new Select(element).selectByVisibleText(value);
	}

	public static void selectIndex(WebElement element, int value) {
		new Select(element).selectByIndex(value);
	}

	public static void deselectValue(WebElement element, String value) {
		new Select(element).deselectByValue(value);
	}

	public static void deselectText(WebElement element, String value) {
		new Select(element).deselectByVisibleText(value);
	}

	public static void deselectIndex(WebElement element, int value) {
		new Select(element).deselectByIndex(value);
	}

	public static List<WebElement> options(WebElement element){
		select = new Select(element);
		List<WebElement> options = select.getOptions();
		return options;
	}
	
	public static List<WebElement> allSelectedOptions(WebElement element) {
		select = new Select(element);
		List<WebElement> allSelectedOptions = select.getAllSelectedOptions();
		return allSelectedOptions;
	}
	
	public static WebElement firstSelectedOption(WebElement element) {
		select = new Select(element);
		WebElement firstSelectedOption = select.getFirstSelectedOption();
		return firstSelectedOption;
	}
	
	public static boolean isMultiple(WebElement element) {
		select = new Select(element);
		boolean multiple = select.isMultiple();
		return multiple;
	}
	
	public static void deselectAll(WebElement element) {
		select = new Select(element);
		select.deselectAll();
	}
	
// Window handles
	public static String getWindow() {
		String windowHandle = driver.getWindowHandle();
		return windowHandle;
	}

	public static void getWindows(int i) {
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> Win = new ArrayList<String>(windowHandles);
		driver.switchTo().window(Win.get(i));
	}

// Frames
	public static void iFrame(int index) {
		driver.switchTo().frame(index);
	}
	
	public static void iFrame(String Value) {
		driver.switchTo().frame(Value);
	}
	
	public static void iFrame(WebElement ele) {
		driver.switchTo().frame(ele);
	}

	public static void parentFrame() {
		driver.switchTo().parentFrame();
	}
	
	public static void defaultContent() {
		driver.switchTo().defaultContent();
	}

// Action
	public static void moveToElement(WebElement element) {
		actions = new Actions(driver);
		actions.moveToElement(element);
	}

	public static void click(WebElement element) {
		actions = new Actions(driver);
		actions.click(element);
	}
	
	public static void rightClick(WebElement element) {
		actions = new Actions(driver);
		actions.contextClick(element);
	}
	
	public static void doubleClick(WebElement element) {
		actions = new Actions(driver);
		actions.doubleClick(element);
	}
	
	public static void dragAndDrop(WebElement source, WebElement target) {
		actions = new Actions(driver);
		actions.dragAndDrop(source, target);
	}
	
// Alert
	public static void alertText(String Value) {
		try {
			driver.switchTo().alert().sendKeys(Value);
		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		}
	}

	public static void acceptAlert() {
		try {
			driver.switchTo().alert().accept();
		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		}
	}

	public static void dismissAlert() {
		try {
			driver.switchTo().alert().dismiss();
		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		}
	}

// ScreenShot
	public static byte[] screenShot(String FileName) {
		ScreenShot = (TakesScreenshot) driver;
		byte[] picBytes = ScreenShot.getScreenshotAs(OutputType.BYTES);
		File source = ScreenShot.getScreenshotAs(OutputType.FILE);
		File destination = new File("./ScreenShot/"+FileName+"-"+getTimeStamp()+".png");
		try {
			FileUtils.copyFile(source, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return picBytes;
	}

// Time stamp
	public static String getTimeStamp() {
		Date date = new Date();
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(date.getTime());
		return timeStamp;
	}
	

// Wait
	
	public static void implicit(int Time) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Time));
	}

	public static void explicit(int Time, WebElement element) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(Time));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public static void wait(int seconds) {
		try {
			Thread.sleep(seconds*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}


}
