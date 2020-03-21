package booking.features;

import booking.tasks.BookARoom;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import booking.tasks.OpenTheApplication;

import java.time.LocalDateTime;

import static org.hamcrest.Matchers.hasItem;

@RunWith(SerenityRunner.class)
public class BookingRoomStory {

    Actor anna = Actor.named("Visitor");

    @Managed(uniqueSession = true)
    public WebDriver herBrowser;

    @Steps
    OpenTheApplication openTheApplication;

    @Before
    public void annaCanBrowseTheWeb() {
        anna.can(BrowseTheWeb.with(herBrowser));
    }

    @Test
    public void booking_a_room_on_booking_site_for_5_days() {
        LocalDateTime today = LocalDateTime.now();
        LocalDateTime backday = today.plusDays(5);

        anna.wasAbleTo(openTheApplication);

        anna.attemptsTo(
            BookARoom.toDestination("Phu Quoc").from(today).to(backday).build()
        );

    }
}