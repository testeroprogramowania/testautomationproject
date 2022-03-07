package pl.testeroprogramowania.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pl.testeroprogramowania.pages.BookFlightPage;
import pl.testeroprogramowania.pages.HomePage;
import pl.testeroprogramowania.pages.ResultPage;

import java.util.List;

public class FlightSearchTest extends BaseTest{

    @Test
    public void flightSearchTest(){
        new HomePage(driver).openFlightSearchPage()
                .setLocations("NUE","BCN")
                .setTripType("Round Trip")
                .setClass("business")
                .setDepartureDate("2022-03-12")
                .setReturnDate("2022-03-20")
                .setNumberOfPassengers(1,3,3)
                .performSearch();

        ResultPage resultPage = new ResultPage(driver);
        Assert.assertEquals(resultPage.getFlightResultHeadingText(), "AVAILABLE FLIGHTS") ;
        /*Tips
        Location can by selected by City name or by ICAO code.
        setTripType options: "Round Trip", "One Way". Use copy/paste.
        setClass options: "economy", "business","first".
        */
    }
    @Test
    public void flightSearchTestWithFilter(){
        new HomePage(driver).openFlightSearchPage()
                .setLocations("NUE","BCN")
                .setTripType("Round Trip")
                .setClass("business")
                .setDepartureDate("2022-03-12")
                .setReturnDate("2022-03-20")
                .setNumberOfPassengers(1,3,3)
                .performSearch()
                .setFilters();

        ResultPage resultPage = new ResultPage(driver);
        Assert.assertEquals(resultPage.getFlightResultHeadingText(), "AVAILABLE FLIGHTS") ;

    }

    @Test
    public void flightSearchAndBookTest() {
        new HomePage(driver).openFlightSearchPage()
                .setLocations("NUE", "BCN")
                .setTripType("Round Trip")
                .setClass("business")
                .setDepartureDate("2022-03-12")
                .setReturnDate("2022-03-20")
                .setNumberOfPassengers(2, 1, 1)
                .performSearch()
                .bookAFlight(1)
                .fillTheForm()
                .proceedToPayment();
    }

    @Test
    public void bookingTestWithoutDetails() {
        new HomePage(driver).openFlightSearchPage()
                .setLocations("NUE", "BCN")
                .setTripType("Round Trip")
                .setClass("business")
                .setDepartureDate("2022-03-12")
                .setReturnDate("2022-03-20")
                .setNumberOfPassengers(2, 1, 1)
                .performSearch()
                .bookAFlight(1)
                .proceedToPayment();

        BookFlightPage bookFlightPage = new BookFlightPage(driver);
        List<String> errors = bookFlightPage.getErrors();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(errors.contains("Email is required"));
        softAssert.assertTrue(errors.contains("Email is required"));
        softAssert.assertTrue(errors.contains("First Name is required"));
        softAssert.assertTrue(errors.contains("Last Name is required"));

    }

}
