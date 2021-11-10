package com.puentedigital.multiposting.scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

public class myfunctions {
	
	WebDriver driver;
	
	public void init() {
		driver = new ChromeDriver();
	};//Funcionando
	
	public void pause(long t) throws InterruptedException {
		
		Thread.sleep(t*1000);
	};//Funcionando
	
	public void close() {
		
		driver.close();
	};//Funcionando
	
	public void wait_element(String xpath) throws InterruptedException {
		
		pause(1);
		WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
		
	};//Funcionando
	
	public void navigate(String url) {
		
		driver.get(url);
		
	};//Funcionando
	
	public WebElement find_element(String xpath) {
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        
        WebElement element = driver.findElement(By.xpath(xpath));
        
        return element;
        
	};//Funcionando
	
	public WebElement find_elements(String xpath) {
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        
        WebElement element = (WebElement) driver.findElements(By.xpath(xpath));
        
        return element;
        
	}; //Funcionando
	
	public void fill_input(String xpath, String value) {
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        WebElement input_element = find_element(xpath);
        input_element.clear();
        input_element.sendKeys(value);
        
		
	};//Funcionando
	
	public void fill_iframe(String xpath, String value) {
		
		driver.switchTo().frame(find_element(xpath));

        WebElement body = driver.findElement(By.tagName("body"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].innerHTML = arguments[1]", body, value);
        driver.switchTo().defaultContent();
        	
	};
	
	public void select_option_by_text() {
		
		/*sleep(t)

        WebDriverWait(self.__driver, 10).until(EC.element_to_be_clickable((By.XPATH, xpath_select)))
        select = Select(self.__driver.find_element(By.XPATH, xpath_select))
        for optionIndex in range(0, len(select.options) - 1):
            if str.strip(select.options[optionIndex].text).lower() == str.strip(option_text).lower():
                select.select_by_index(optionIndex)
                return True

        return False*/
		
	};
	
	public void custom_select_option() {
		/*
		self.click(container_xpath)

        option_list = self.find_element(options_xpath)
        for option_item in option_list.find_elements(By.TAG_NAME, "li"):
            if option_item.text == value:
                option_item.click()
                return True

        return False*/
		
	};
	
	public void click(String xpath) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        pause(2);
        WebElement input_element = find_element(xpath);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", input_element);
    	//input_element.click();
   	
	};
	
	public void select_by_value(String xpath_select, String value) {
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath_select)));
        
        Select select_option = new Select(driver.findElement(By.xpath(xpath_select)));
        select_option.selectByValue(value);
        		
	};
	
	public void execute_script(String script, String xpath_element) {
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath_element)));
        
        WebElement element = find_element(xpath_element);
        ((JavascriptExecutor) driver).executeScript(script, element);
        	
	};
	
	public void key_up(String xpath_element) throws InterruptedException {
		
		pause(1);
		WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath_element)));
        
        WebElement element = find_element(xpath_element);
        element.sendKeys(Keys.UP);
        pause(1);
        
	};
	
	public void key_return(String xpath_element) throws InterruptedException {
		
		pause(1);
		WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath_element)));
        
        WebElement element = find_element(xpath_element);
        element.sendKeys(Keys.RETURN);
        pause(1);

	};
	
	public void maximize_window() {
		driver.manage().window().maximize();
	};//Funcionando
	
	public void scroll_page_up() {
		
		//js.executeScript("scroll(0, -250);");
		((JavascriptExecutor) driver).executeScript("scroll(0, -250);");
	};
	
	public void scroll_page_down() {
		
		//js.executeScript("scroll(0, 250);");
		((JavascriptExecutor) driver).executeScript("scroll(0, 250);");
	};
	
	public void click_by_link_text(String value) throws InterruptedException {
		
		pause(1);
		driver.findElement(By.linkText(value)).click();
	};
	
	public void click_without_webdriver() {
		
		/*element = self.find_element(xpath)
		element.click()*/
		
	};
	
	public void fill_input_location_gob(String xpath_element, String value) throws InterruptedException {
		
		pause(2);
		WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath_element)));
        
        WebElement input_element = find_element(xpath_element);
        input_element.sendKeys(value);
		
	};
	

}
