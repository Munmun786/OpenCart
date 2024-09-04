package testBase;

import java.io.File;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;



import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class BaseClass {
    public Logger logger; 
    public static WebDriver driver;
    public Properties pro;

    @BeforeClass(groups = {"Sanity","Regression","Master","DataDriven"})
    @Parameters({"os","browser"})
    public void setUp(String os,String br) throws IOException {
        logger = LogManager.getLogger(this.getClass());
        
        pro = new Properties();
		FileReader file = new FileReader("./src//test//resources//config.properties");
		pro.load(file);
        
		if(pro.getProperty("execution_env").equalsIgnoreCase("remote")) {
			
			DesiredCapabilities capabilities= new DesiredCapabilities();
		
			
			//os
			if(os.equalsIgnoreCase("windows")) {
				capabilities.setPlatform(Platform.WIN10);
			}
			else if (os.equalsIgnoreCase("mac")) {
				capabilities.setPlatform(Platform.MAC);
			}
			else {
				System.out.println("not matchinf os");
			

				return;			}
			//browse
			
			switch(br.toLowerCase()) {
			case "chrome" : capabilities.setBrowserName("chrome");break;
			case "edge"  : capabilities.setBrowserName("MicrosoftEdge");break;
			default : System.out.println("not matching browser"); return;
			}
			driver=new RemoteWebDriver(new URL(" http://192.168.0.109:4444/wd/hub"),capabilities);
		}
		
		
		
		if(pro.getProperty("execution_env").equalsIgnoreCase("local")) {
			
			switch(br.toLowerCase()) {
	        
	        case "chrome" : driver= new ChromeDriver(); break;
	        case "firefox" : driver = new FirefoxDriver();break;
	        case "edge"   : driver = new EdgeDriver();break;
	        default : System.out.println("invalid Browser name");
	        return;
	        }
		}
		
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(pro.getProperty("url"));
    }

    @AfterClass(groups = {"Sanity","Regression","Master"})
    public void tearDown() {
        driver.quit();
    }

    public String randomString() {
        return RandomStringUtils.randomAlphabetic(10);
    }

    public String randomNumber() {
        return RandomStringUtils.randomNumeric(10);
    }

    public String randomStringNumber() {
        String generateString = RandomStringUtils.randomAlphabetic(10);
        String generateNumber = RandomStringUtils.randomNumeric(10);
        return generateString + "@" + generateNumber;
    }
    
    public String captureScreen(String tname) {
    	
    	String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date() );
    	TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
    	File sourcefile = takesScreenshot.getScreenshotAs(OutputType.FILE);
    	
    	String targetFilePath = System.getProperty("user.dir")+".\\screenshots\\" +tname+ "-" + timeStamp + ".png";
    	File targetFile = new File(targetFilePath);
    	
    	sourcefile.renameTo(targetFile);
    	
    	return targetFilePath;
    }
    
    
    
}
