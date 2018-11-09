package Locators;

public class GoogleResultsPageLocators {

    public static final String ALL_TAB_CSS_LOCATOR = "div.hdtb-mitem:nth-child(1)";

    public String getLinkTextXpath(String linkText){
        return "//h3[contains(text(),'"+linkText+"')]";
    }
}
