package pl.testeroprogramowania.tests;

import org.testng.annotations.Test;
import pl.testeroprogramowania.models.Customer;
import pl.testeroprogramowania.pages.HomePage;

public class NewUserTest extends BaseTest {
    @Test
    public void newUserTest(){
        Customer customer = new Customer();
        customer.setFirstName("Adam");
        customer.setLastName("Nüßler");
        customer.setPhone("+49123123123");
        customer.setEmail("adamnuessler@gmx.de");
        customer.setPassword("nuessler@gmx.de");

        new HomePage(driver).openSignUpForm().fillTheForm(customer);
    }
}
