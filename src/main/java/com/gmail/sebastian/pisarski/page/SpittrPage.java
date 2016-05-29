package com.gmail.sebastian.pisarski.page;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;

import org.openqa.selenium.WebElement;

public class SpittrPage extends PageObject {

	@FindBy(css = ".loginWrapper")
	private WebElement loginInfo;

	@FindBy(css = ".loginWrapper>a")
	private WebElement loginInfoLink;

	public String getLoginInfoText() {
		return loginInfo.getText();
	}

	public WebElement getLoginInfoLink() {
		return loginInfoLink;
	}

}
