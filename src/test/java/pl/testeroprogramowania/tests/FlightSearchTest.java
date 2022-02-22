package pl.testeroprogramowania.tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pl.testeroprogramowania.pages.FlightSearchPage;
import pl.testeroprogramowania.pages.HomePage;

public class FlightSearchTest extends BaseTest{

    @Test
    public void flightSearchTest(){
        new HomePage(driver).openFlightSearchPage()
                .setLocations("WAW","PMI")
                .setTripType("Round Trip")
                .setDepartureDate("2022-03-01")
                .setReturnDate("2022-03-25")
                .performSearch();



        /*Tips
        Location can by selected by City name or by ICAO code.
        TripType options: "Round Trip", "One Way". Use copy/paste.


        */
    }

}
