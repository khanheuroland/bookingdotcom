package booking.tasks;

import booking.actions.Book;
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
    private int numberOfRoom;
    private int numberOfAdult;
    private int numberOfChild;

    public BookARoom(String destination, LocalDateTime from, LocalDateTime to, int room, int adult, int child) {
        this.destination = destination;
        this.from = from;
        this.to = to;
        this.numberOfRoom=room;
        this.numberOfAdult=adult;
        this.numberOfChild=child;
    }

    public static BookARoomBuilder toDestination(String destination) {
        return new BookARoomBuilder(destination);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Choose.aDestination(this.destination),
                Choose.aDateForCheckIn(this.from),
                Choose.aDateForCheckOut(this.to),
                Book.rooms(numberOfRoom).forAdult(numberOfAdult).andChildren(numberOfChild),
                Click.on(BookingBox.SEARCH_BUTTON)
        );
    }

    public static class BookARoomBuilder
    {
        private  String destination;
        private  LocalDateTime from;
        private  LocalDateTime to;
        private  int room;
        private  int adult;
        private  int child;

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

        public BookARoomBuilder noOfRoom(int room)
        {
            this.room = room;
            return this;
        }

        public BookARoomBuilder forAdult(int adult)
        {
            this.adult = adult;
            return this;
        }

        public BookARoomBuilder andChildren(int child)
        {
            this.child = child;
            return this;
        }

        public BookARoom build()
        {
            return instrumented(BookARoom.class, destination, from, to, room, adult, child);
        }
    }
}
