/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author vital
 */
public class AdminLoginTest {
    static private WebDriver driver;
    public AdminLoginTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        System.setProperty("webdriver.chrome.driver", "lib/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://localhost:8080/SPTVR19WebShop-master/");
        //Строчки, которые необходимые, чтобы указать драйверу, что ему нужно открыть
        //хром, если будут задержки ( на выполнение то будет дожидаться, 
        //указать, хром нужно открывать по такому адресу
        //и дальше выполнять тесты
        
        
    }
    
    @AfterClass
    public static void tearDownClass() throws InterruptedException {
        //метод  quit закроет браузер и освободит ресурсы
        //остановим наш поток, чтобы он смог нам показать результат работы теса (thread)
        Thread.sleep(2000);
        driver.quit();
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void login  () {
         System.out.println("Admin login Test");
         WebElement el = driver.findElement(By.id("loginForm"));//взяли со странички элемент, который имеет 
         //идентификатор loginform, 
         el.click();
         el = driver.findElement(By.id("login")); 
         el.sendKeys("admin"); 
         el = driver.findElement(By.id("password")); 
         el.sendKeys("12345");          
         el = driver.findElement(By.xpath("//button[@type='submit']")); 
         el.click();
         //Когда мы нажмём, сервер получит login и password, сделает авторизацию и вернет страничку входа
         //Теперь можем найти информацию, которая есть в info
         el = driver.findElement(By.id("info")); 
         System.out.println("Ожидается: Вы вошли как admin");
         System.out.println("Выводится: ВЫ ВОШЛИ КАК АДМИН"+el.getText());
         Assert.assertEquals("Вы вошли как админ ", el.getText());
     }
     
}
