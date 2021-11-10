package com.puentedigital.multiposting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//Class Import
import com.puentedigital.multiposting.scripts.myfunctions;
import com.puentedigital.multiposting.scripts.getOnBoardPublisher;




@SpringBootApplication
public class MultipostingApplication {

	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(MultipostingApplication.class, args);
		System.setProperty("webdriver.chrome.driver", "C:/Users/56978/Desktop/Puente Digital/Multiposting/GitHub/multiposting_backend-java/drivers/chromedriver95.exe");
		//Cambiar ruta
		
		
		getOnBoardPublisher pull = new getOnBoardPublisher();
		myfunctions f = new myfunctions();
		pull.init();
		pull.authenticate();
		f.pause(8);
		pull.close();
		System.out.println("Fin");
		
		
		
		
		
	}

}
