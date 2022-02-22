package pl.testeroprogramowania.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.testeroprogramowania.pages.ResultPage;
import pl.testeroprogramowania.pages.ToursSearchPage;

import java.util.List;

public class ToursSearchTest extends BaseTest {

    @Test
    public void searchToursWithCityName(){
        ToursSearchPage toursSearchPage = new ToursSearchPage(driver);
        toursSearchPage.clickToursButton();
        toursSearchPage.setLocation("Egypt");
        toursSearchPage.setCheckInDate("20/12/2022");
        toursSearchPage.setNumbersOfGuests("3");
        toursSearchPage.setTypeTour("Private");
        toursSearchPage.performSearch();

        ResultPage resultPage = new ResultPage(driver);
        List<String> toursPlace = resultPage.getToursPlace();
        System.out.println(resultPage.getToursPlace());
        Assert.assertEquals(toursPlace.get(0), "Spectaculars Of The…                  ");
    }

    @Test
    public void searchToursByListing(){
        ToursSearchPage toursSearchPage = new ToursSearchPage(driver);
        toursSearchPage.clickToursButton();
        toursSearchPage.setLocation("Bus");
        toursSearchPage.setCheckInDate("20/12/2022");
        toursSearchPage.setNumbersOfGuests("3");
        toursSearchPage.setTypeTour("Private");
        toursSearchPage.performSearch();
    }

    @Test
    public void searchToursWithNoExistCity(){
        ToursSearchPage toursSearchPage = new ToursSearchPage(driver);
        toursSearchPage.clickToursButton();
        toursSearchPage.setNoExistCityName("Neverland");
    }

    @Test
    public void searchToursWithoutListingOrCityName(){
        ToursSearchPage toursSearchPage = new ToursSearchPage(driver);
        toursSearchPage.clickToursButton();
        toursSearchPage.setCheckInDate("20/12/2022");
        toursSearchPage.setNumbersOfGuests("3");
        toursSearchPage.setTypeTour("Private");
        toursSearchPage.performSearch();
    }

    @Test
    public void searchToursWithoutDate(){
        ToursSearchPage toursSearchPage = new ToursSearchPage(driver);
        toursSearchPage.clickToursButton();
        toursSearchPage.setLocation("Egypt");
        toursSearchPage.clearDate();
        toursSearchPage.setNumbersOfGuests("3");
        toursSearchPage.setTypeTour("Private");
        toursSearchPage.performSearch();
    }

    @Test
    public void searchToursWithNoExistDate(){
        ToursSearchPage toursSearchPage = new ToursSearchPage(driver);
        toursSearchPage.clickToursButton();
        toursSearchPage.setLocation("Egypt");
        toursSearchPage.setCheckInDate("00/13/209");
        toursSearchPage.setNumbersOfGuests("3");
        toursSearchPage.setTypeTour("Private");
        toursSearchPage.performSearch();
    }

    @Test
    public void searchToursWithWrongDateForm(){
        ToursSearchPage toursSearchPage = new ToursSearchPage(driver);
        toursSearchPage.clickToursButton();
        toursSearchPage.setLocation("Egypt");
        toursSearchPage.setCheckInDate("Data ;p");
        toursSearchPage.setNumbersOfGuests("3");
        toursSearchPage.setTypeTour("Private");
        toursSearchPage.performSearch();
    }

    @Test
    public void searchToursWithoutGuests(){
        ToursSearchPage toursSearchPage = new ToursSearchPage(driver);
        toursSearchPage.clickToursButton();
        toursSearchPage.setLocation("Egypt");
        toursSearchPage.setCheckInDate("20/12/2022");
        toursSearchPage.setNumbersOfGuests("0");
        toursSearchPage.setTypeTour("Private");
        toursSearchPage.performSearch();
    }

    @Test
    public void searchToursWithoutType(){
        ToursSearchPage toursSearchPage = new ToursSearchPage(driver);
        toursSearchPage.clickToursButton();
        toursSearchPage.setLocation("Egypt");
        toursSearchPage.setCheckInDate("20/12/2022");
        toursSearchPage.setNumbersOfGuests("3");
        toursSearchPage.setNoExistToursType("xyz");
    }
}
