package booking.actions;

import booking.ui.BookingBox;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.webdriver.WebDriverFacade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Book implements Interaction{
    private int adult;
    private int child;
    private int room;

    public Book(int room, int adult, int child)
    {
        this.room = room;
        this.adult = adult;
        this.child = child;
    }

    public static GuestBuilder rooms(int room)
    {
        return new GuestBuilder(room);
    }

    @Step("{0} books #room Rooms for #adult Adult and #child Children")
    @Override
    public <T extends Actor> void performAs(T actor) {
        BookingBox.GUESTS.resolveFor(actor).click();

        //Adult
        int numberOfAdult = Integer.parseInt(BookingBox.NUMBER_OF_ADULT.resolveFor(actor).getText());
        if(numberOfAdult>adult)
        {
            for(int i =numberOfAdult; i>adult; i--)
            {
                BookingBox.DECREASE_NUMBER_OF_ADULT.resolveFor(actor).click();
            }
        }
        else if(adult> numberOfAdult)
        {
            for(int i =numberOfAdult; i<adult; i++)
            {
                BookingBox.INCREASE_NUMBER_OF_ADULT.resolveFor(actor).click();
            }
        }

        //Children
        int numberOfChildren = Integer.parseInt(BookingBox.NUMBER_OF_CHILDREN.resolveFor(actor).getText());
        if(numberOfChildren> child)
        {
            for(int i=child; i<numberOfChildren; i++)
            {
                BookingBox.DECREASE_NUMBER_OF_CHILDREN.resolveFor(actor).click();
            }
        }
        else if(numberOfChildren<child)
        {
            for(int i=numberOfChildren; i<child; i++)
            {
                BookingBox.INCREASE_NUMBER_OF_CHILDREN.resolveFor(actor).click();
            }
        }

        //Room
        int numberOfRoom = Integer.parseInt(BookingBox.NUMBER_OF_ROOM.resolveFor(actor).getText());

        if(numberOfRoom> room)
        {
            for(int i=room; i<numberOfRoom; i++)
            {
                BookingBox.DECREASE_NUMBER_OF_ROOM.resolveFor(actor).click();
            }
        }
        else if(numberOfRoom<room)
        {
            for(int i=numberOfRoom; i<room; i++)
            {
                BookingBox.INCREASE_NUMBER_OF_ROOM.resolveFor(actor).click();
            }
        }

        WebDriver facade = BrowseTheWeb.as(actor).getDriver();
        WebDriver driver= ((WebDriverFacade) facade).getProxiedDriver();
        String platformName = ((RemoteWebDriver) driver).getCapabilities().getPlatform().toString();
        if (platformName.toUpperCase() == "ANDROID") {
            BookingBox.DONE_GUESS.resolveFor(actor).click();
        }
    }

    public static class GuestBuilder
    {
        private int adult;
        private int child;
        private int room;

        public GuestBuilder(int room)
        {
            this.room = room;
        }

        public Interaction andChildren(int child)
        {
            return instrumented(Book.class, room, adult, child);
        }

        public GuestBuilder forAdult(int adult)
        {
            this.adult = adult;
            return this;
        }
    }
}
