package booking.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class BookingBox {
    public static Target SEARCH_FIELD = Target.the("destination field")
            .locatedBy("//input[@type=\"search\"]");

    public static Target SUGGESTION_TOP_ITEM = Target.the("first item from suggestion box")
            .locatedBy("//ul[@data-list]/li[1]");

    public static Target GUESTS = Target.the("choose the guests")
            .locatedBy("(//div[contains(@class, 'xp__guests')])[1]");

    public static Target NUMBER_OF_ADULT = Target.the("number of adult")
            .locatedBy("(//span[@class=\"bui-stepper__display\"])[1]");

    public static Target DECREASE_NUMBER_OF_ADULT = Target.the("decrease number of adult")
            .locatedBy("(//button[@aria-describedby=\"group_adults_desc\"])[1]");

    public static Target INCREASE_NUMBER_OF_ADULT = Target.the("increase number of adult")
            .locatedBy("(//button[@aria-describedby=\"group_adults_desc\"])[2]");

    public static Target NUMBER_OF_CHILDREN = Target.the("number of children")
            .locatedBy("(//span[@class=\"bui-stepper__display\"])[2]");

    public static Target DECREASE_NUMBER_OF_CHILDREN = Target.the("decrease numnber of Children")
            .locatedBy("(//button[@aria-describedby=\"group_children_desc\"])[1]");

    public static Target INCREASE_NUMBER_OF_CHILDREN = Target.the("decrease numnber of Children")
            .locatedBy("(//button[@aria-describedby=\"group_children_desc\"])[2]");

    public static Target NUMBER_OF_ROOM = Target.the("number of room")
            .locatedBy("(//span[@class=\"bui-stepper__display\"])[3]");

    public static Target DECREASE_NUMBER_OF_ROOM = Target.the("decrease number of Room")
            .locatedBy("(//button[@aria-describedby=\"no_rooms_desc\"])[1]");

    public static Target INCREASE_NUMBER_OF_ROOM = Target.the("increase number of Room")
            .locatedBy("(//button[@aria-describedby=\"no_rooms_desc\"])[2]");

    public static Target SEARCH_BUTTON = Target.the("search button")
            .locatedBy("//button[@class=\"sb-searchbox__button \"]");
}
