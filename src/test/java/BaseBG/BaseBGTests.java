package BaseBG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.security.IdentityScope;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class BaseBGTests {
    private WebDriver webDriver;

    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.get("https://mercadolibre.com/");

        WebElement inputBO = webDriver.findElement(By.id("BO"));
        inputBO.click();

        WebElement eliminarCookie = webDriver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/button[1]"));
        eliminarCookie.click();

        WebElement eliminarMensaje = webDriver.findElement(By.xpath("/html/body/div[2]/div[2]/div/button"));
        eliminarMensaje.click();


        WebElement botonBuscar = webDriver.findElement(By.name("as_word"));
        botonBuscar.sendKeys("Laptos");
        botonBuscar.submit();

        WebElement nuevoFiltro = webDriver.findElement(By.xpath("/html/body/main/div/div/aside/div[3]/div[4]/ul/li[1]/form/button"));
        nuevoFiltro.click();

        List<WebElement> productos = webDriver.findElements(By.className("ui-search-layout__item"));
        System.out.println("productos " + productos.size());
        if (productos.size() >= 3) {
            System.out.println("Hay mas de 3 produtos");
        }

        webDriver.quit();
    }

    public static void main(String arg[]){
        BaseBGTests baseTest = new BaseBGTests();
        baseTest.setUp();
    }
}


