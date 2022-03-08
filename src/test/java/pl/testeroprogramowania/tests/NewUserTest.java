package pl.testeroprogramowania.tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.testeroprogramowania.models.Customer;
import pl.testeroprogramowania.pages.HomePage;

public class NewUserTest extends BaseTest {
    @Test
    public void newUserTest(){
        Customer customer = new Customer();
        customer.setEmail("adamnuessler5@gmx.de");


        WebElement loggedUserHeading = new HomePage(driver)
                .openSignUpForm()
                .fillTheForm(customer)
                .getLoggedUserHeading();

        Assert.assertEquals(loggedUserHeading.getText(),"Hi, "+customer.getFirstName()+" "+ customer.getLastName());
    }
}
