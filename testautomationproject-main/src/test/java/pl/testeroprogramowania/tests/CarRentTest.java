package pl.testeroprogramowania.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.testeroprogramowania.utils.CarRentPage;
import pl.testeroprogramowania.utils.CarResultsPage;

import java.util.List;

public class CarRentTest extends BaseTest{

    @Test
    public void rentCarTest() {

        CarRentPage carRentPage = new CarRentPage(driver);
        carRentPage.pickUpLocation("Manchester");
        carRentPage.dropOffLocation("Manchester");
        carRentPage.setDates("21/11/2022", "22/11/2022");
        carRentPage.setTimeRent("10:00","12:00");
        carRentPage.performSearch();

        CarResultsPage carResultsPage = new CarResultsPage(driver);
        List<String> carNames = carResultsPage.getCarNames();

        Assert.assertEquals(carNames.get(0), "Kia Pacanto 2014                  ");
    }

    @Test
    public void rentCarDifferentCities() {

        CarRentPage carRentPage = new CarRentPage(driver);
        carRentPage.pickUpLocation("Manchester");
        carRentPage.dropOffLocation("Kapaa");
        carRentPage.setDates("21/11/2022", "22/11/2022");
        carRentPage.setTimeRent("10:00","12:00");
        carRentPage.performSearch();

        CarResultsPage carResultsPage = new CarResultsPage(driver);
        List<String> carNames = carResultsPage.getCarNames();

        CarResultsPage resultsPage = new CarResultsPage(driver);

        Assert.assertTrue(resultsPage.resultHeading.isDisplayed());
        Assert.assertEquals(resultsPage.getHeadingText(), "No Results Found");
    }
}
