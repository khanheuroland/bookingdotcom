package booking.tasks;

import booking.actions.Choose;
import booking.actions.ChooseDate;
import booking.ui.BookingBox;
import com.google.common.base.Converter;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import java.time.LocalDateTime;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class BookARoom implements Task {
    private  String destination;
    private  LocalDateTime from;
    private  LocalDateTime to;

    public BookARoom(String destination, LocalDateTime from, LocalDateTime to) {
        this.destination = destination;
        this.from = from;
        this.to = to;
    }

    public static BookARoomBuilder toDestination(String destination) {
        return new BookARoomBuilder(destination);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Choose.aDestination(this.destination),
                Choose.aDateForCheckIn(this.from),
                Choose.aDateForCheckOut(this.to)
        );
    }

    public static class BookARoomBuilder
    {
        private  String destination;
        private  LocalDateTime from;
        private  LocalDateTime to;
        public BookARoomBuilder(String destination)
        {
            this.destination = destination;
        }

        public BookARoomBuilder from(LocalDateTime from)
        {
            this.from = from;
            return this;
        }

        public BookARoomBuilder to(LocalDateTime to)
        {
            this.to = to;
            return this;
        }

        public BookARoom build()
        {
            return instrumented(BookARoom.class, destination, from, to);
        }
    }
}
