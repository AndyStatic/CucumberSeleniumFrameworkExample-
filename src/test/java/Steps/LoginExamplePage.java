package Steps;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.ArrayList;
import java.util.List;

public class LoginExamplePage {
    @Then("^I navigate to page with title \"([^\"]*)\"$")
    public void iNavigateToPageWithTitle(String linkText) throws Throwable {
        System.out.println("I navigate to page with title");
    }

    @And("^I press the \"([^\"]*)\" button on login example page$")
    public void iPressTheButtonOnLoginExamplePage(String button) throws Throwable {
        System.out.println("I press the");
    }

    @When("^I enter email address and password via DataTable$")
    public void iEnterEmailAddressAndPassword(DataTable dataTable) throws Throwable {

        //Option 1 via straight access to row/column stored values
        /*
        List<List<String>> credentials = dataTable.raw();
        String email = credentials.get(1).get(0);
        String password = credentials.get(1).get(1);
        System.out.println(email);
        System.out.println(password);
        */

        //Option 2 via separate class
        List<Account> accounts = new ArrayList<Account>();
        //Store all accounts
        accounts = dataTable.asList(Account.class);

        for (Account account: accounts) {
            System.out.println(account.email);
            System.out.println(account.password);
        }

    }

    @When("^I enter \"([^\"]*)\" email address and \"([^\"]*)\" password$")
    public void iEnterAddressAnd(String email, String password) throws Throwable {
        System.out.println("Scenario Outline");
    }

    public class Account {
        public String email;
        public String password;

        public Account(String email, String password) {
            this.email = email;
            this.password = password;
        }
    }
}
