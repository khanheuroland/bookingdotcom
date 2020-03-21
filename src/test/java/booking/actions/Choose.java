package booking.actions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;

import java.time.LocalDateTime;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Choose {
    public static Interaction aDateForCheckIn(LocalDateTime dateTime)
    {
        return instrumented(ChooseDate.class, dateTime, "Check-in date");
    }

    public static Interaction aDateForCheckOut(LocalDateTime dateTime)
    {
        return instrumented(ChooseDate.class, dateTime, "Check-out date");
    }

    public static Interaction aDestination(String destination)
    {
        return instrumented(ChooseDestination.class, destination);
    }
}
