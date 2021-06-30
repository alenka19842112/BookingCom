package steps;

import com.codeborne.selenide.Condition;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;

public class BookingSteps {
    String city;
    private static final String RATING_LOCATOR = "//*[contains (text(),'%s')]/ancestor::*[@class='sr_property_block_main_row']//*[@class='bui-review-score__badge']";

    @Given("User is looking for hotels in {string} city")
    public void userIsLookingForHotelsInCity(String city) {
        this.city = city;
    }

    @When("user does search")
    public void userDoesSearch() {
        open("https://www.booking.com/");
        $(By.id("ss")).sendKeys(city);
        $(".sb-searchbox__button").click();
    }

    @Then("Hotel {string} should be on the Search results page")
    public void hotelApartmentShouldBeOnTheSearchResultsPage(String hotel) {
        $(By.xpath("//span[contains(.,'Show prices')]")).shouldBe(Condition.visible);
        assertThat($$(".sr-hotel__name").texts(), hasItem(hotel));
    }

    @Then("Hotel {string} rating is {string}")
    public void hotelHostelUrbanRatingIs(String hotel, String rating) {
        $(By.xpath("//span[contains(.,'Show prices')]")).shouldBe(Condition.visible);
        assertThat($$(By.xpath(String.format(RATING_LOCATOR,hotel))).texts(), hasItem(rating));
    }
}
