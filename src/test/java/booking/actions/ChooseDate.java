package booking.actions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        driver.findElement(By.xpath("//td[@data-date=\""+ this.dateInString+ "\"]")).click();
    }
}
