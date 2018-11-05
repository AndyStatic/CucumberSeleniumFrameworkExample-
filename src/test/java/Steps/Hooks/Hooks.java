package Steps.Hooks;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {

    @Before
    public void InitializeTest(){
        System.out.println("Initialize Test");
    }

    @After
    public void CloseTest(){
        System.out.println("Close Test");
    }
}
