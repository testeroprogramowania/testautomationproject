package pl.testeroprogramowania.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.testeroprogramowania.pages.ResultPage;
import pl.testeroprogramowania.pages.ToursSearchPage;

import java.util.List;

public class ToursSearchTest extends BaseTest {

    @Test
    public void searchTours(){
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
}
