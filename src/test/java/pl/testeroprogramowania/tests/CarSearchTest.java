package pl.testeroprogramowania.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pl.testeroprogramowania.pages.CarSearchPage;
import pl.testeroprogramowania.utils.ExcelImport;

import java.io.IOException;

public class CarSearchTest extends BaseTest {

    @Test
    public void searchForCarToRent() {
        CarSearchPage carSearchPage = new CarSearchPage(driver);
        carSearchPage.clickCarsButton(driver);
        carSearchPage.setLocation("Manchester");
        carSearchPage.setDepDate("12/02/2022");
        carSearchPage.setDepTime();
        carSearchPage.setReturnDate("16/02/2022");
        carSearchPage.setReturnTime();
        carSearchPage.performSearch();

    }
    @Test
    public void searchForCarToRentWithNonExistentDate() {
        CarSearchPage carSearchPage = new CarSearchPage(driver);
        carSearchPage.clickCarsButton(driver);
        carSearchPage.setLocation("Manchester");
        carSearchPage.setDepDate("32/02/2022");
        carSearchPage.setDepTime();
        carSearchPage.setReturnDate("55/14/2022");
        carSearchPage.setReturnTime();
        carSearchPage.performSearch();
    }
    @Test
    public void searchForCarToRentWithDateFromThePast() {
        CarSearchPage carSearchPage = new CarSearchPage(driver);
        carSearchPage.clickCarsButton(driver);
        carSearchPage.setLocation("Manchester");
        carSearchPage.setDepDate("18/02/922");
        carSearchPage.setDepTime();
        carSearchPage.setReturnDate("18/04/1918");
        carSearchPage.setReturnTime();
        carSearchPage.performSearch();
    }

    @Test
    public void searchForCarToRentWithoutCityName() {
        CarSearchPage carSearchPage = new CarSearchPage(driver);
        carSearchPage.clickCarsButton(driver);
        carSearchPage.clearLocationField();
        carSearchPage.setDepDate("12/02/2022");
        carSearchPage.setDepTime();
        carSearchPage.setReturnDate("16/02/2022");
        carSearchPage.setReturnTime();
        carSearchPage.performSearch();

//Uwaga - należy jeszcze sprawdzić czy pojawia się komunikat "Wybierz element z listy"
    }
    @Test(dataProvider = "data")
    public void searchForCarToRentWithDataProvider(String city) {
        CarSearchPage carSearchPage = new CarSearchPage(driver);
        carSearchPage.clickCarsButton(driver);
        carSearchPage.setLocation(city);
        carSearchPage.setDepDate("12/02/2022");
        carSearchPage.setDepTime();
        carSearchPage.setReturnDate("16/02/2022");
        carSearchPage.setReturnTime();
        carSearchPage.performSearch();


    }
    @DataProvider
    public Object[][] data() throws IOException {
        return ExcelImport.readExcel("citiesData.xls");
    }



}