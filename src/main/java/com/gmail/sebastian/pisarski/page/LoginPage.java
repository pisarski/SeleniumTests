package com.gmail.sebastian.pisarski.page;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;

import org.openqa.selenium.WebElement;

@DefaultUrl("/login")
public class LoginPage extends PageObject {

	@FindBy(css = "input[name = 'username'")
	private WebElement loginInput;

	@FindBy(css = "input[name = 'password'")
	private WebElement passwordInput;

	@FindBy(css = ".formErrorMessage")
	private WebElement errorMessage;

	@FindBy(css = "button[type='submit']")
	private WebElement loginButton;

	public WebElement getLoginInput() {
		return loginInput;
	}

	public WebElement getPasswordInput() {
		return passwordInput;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}

	public String getErrorMessage() {
		return errorMessage.getText();
	}

}
