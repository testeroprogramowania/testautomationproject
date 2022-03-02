package pl.testeroprogramowania.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.testeroprogramowania.pages.HomePage;
import pl.testeroprogramowania.pages.ResultPage;

public class FlightSearchTest extends BaseTest{

    @Test
    public void flightSearchTest(){
        new HomePage(driver).openFlightSearchPage()
                .setLocations("NUE","BCN")
                .setTripType("Round Trip")
                .setDepartureDate("2022-03-12")
                .setReturnDate("2022-03-20")
                .setClass("business")
                .setNumberOfPassengers(1,3,3)
                .performSearch();

        ResultPage resultPage = new ResultPage(driver);
        Assert.assertEquals(resultPage.getFlightResultHeadingText(), "DATES AVAILABILITY") ;



        /*Tips
        Location can by selected by City name or by ICAO code.
        setTripType options: "Round Trip", "One Way". Use copy/paste.
        setClass options: "economy", "business","first".


        */
    }
    @Test
    public void flightSearchAndBookTest() {
        new HomePage(driver).openFlightSearchPage()
                .setLocations("NUE", "BCN")
                .setTripType("Round Trip")
                .setDepartureDate("2022-03-12")
                .setReturnDate("2022-03-20")
                .setClass("business")
                .setNumberOfPassengers(2, 1, 1)
                .performSearch()
                .bookAFlight(1)
                .fillTheForm()
                .proceedToPayment();
    }

}
