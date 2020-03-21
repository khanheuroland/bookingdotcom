package booking.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class BookingBox {
    public static Target SEARCH_FIELD = Target.the("destination field")
            .locatedBy("//input[@type=\"search\"]");

    public static Target SUGGESTION_TOP_ITEM = Target.the("first item from suggestion box")
            .locatedBy("//ul[@data-list]/li[1]");
}
