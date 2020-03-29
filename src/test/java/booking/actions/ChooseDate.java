package booking.actions;

import booking.ui.BookingBox;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.webdriver.WebDriverFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ChooseDate implements Interaction {
    LocalDateTime value;
    String dateInString;
    String fieldTitle;
    public ChooseDate(LocalDateTime value, String fieldTitle)
    {
        this.value = value;
        this.fieldTitle = fieldTitle;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        this.dateInString = this.value.format(formatter);

    }
    @Step("{0} select as date #dateInString for #fieldTitle")
    @Override
    public <T extends Actor> void performAs(T actor) {
       /* WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        driver.findElement(By.xpath("//td[@data-date=\""+ this.dateInString+ "\"]")).click();*/
        Target dateSelector = Target.the("") .locatedBy("//td[@data-date=\""+ this.dateInString+ "\"]");
        dateSelector.resolveFor(actor).click();

        if(fieldTitle=="Check-out date") {
            WebDriver facade = BrowseTheWeb.as(actor).getDriver();
            WebDriver driver= ((WebDriverFacade) facade).getProxiedDriver();
            String platformName = ((RemoteWebDriver) driver).getCapabilities().getPlatform().toString();
            if (platformName.toUpperCase() == "ANDROID") {
                BookingBox.DONE_BUTTON.resolveFor(actor).click();
            }
        }
    }
}
