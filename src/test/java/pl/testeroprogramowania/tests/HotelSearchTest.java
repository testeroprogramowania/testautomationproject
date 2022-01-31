package pl.testeroprogramowania.tests;

import org.testng.annotations.Test;
import pl.testeroprogramowania.pages.HotelSearchPage;

public class HotelSearchTest extends BaseTest{

    @Test

    public void searchForHotelTest() {
        HotelSearchPage hotelSearchPage = new HotelSearchPage(driver);
        hotelSearchPage.setCityName("Dubai");
        hotelSearchPage.setCheckInOutDates("01/02/2022", "06/02/2022");
        hotelSearchPage.setNumberOfGuests(2,3);
        hotelSearchPage.performSearch();

    }

}
