package booking.actions;

import booking.ui.BookingBox;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;

public class ChooseDestination implements Interaction {
    String destination;
    @Step("{0} select #destination as a destination")
    @Override
    public <T extends Actor> void performAs(T actor) {
        BookingBox.SEARCH_FIELD.resolveFor(actor).click();
        BookingBox.SEARCH_FIELD.resolveFor(actor).sendKeys(destination);
        BookingBox.SUGGESTION_TOP_ITEM.resolveFor(actor).click();
    }

    public ChooseDestination(String destination)
    {
        this.destination = destination;
    }
}
