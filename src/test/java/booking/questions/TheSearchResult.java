package booking.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TheSearchResult{

    public static Question<Integer> totalRoom()
    {
        return new SearchItemsTotal();
    }

    public static class  SearchItemsTotal implements Question<Integer>
    {

        @Override
        public Integer answeredBy(Actor actor) {
            Target resultTotal = Target.the("result count")
                    .locatedBy("//div[@data-block-id=\"heading\"]//h1");

            String totalValue = Text.of(resultTotal).viewedBy(actor).resolve();

            Pattern numberPattern = Pattern.compile("\\d+");
            Matcher m = numberPattern.matcher(totalValue);

            String matchedNumber = "0";
            while(m.find()) {
                matchedNumber = m.group();
            }

            return Integer.parseInt(matchedNumber);
        }
    }
}
