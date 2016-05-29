package com.gmail.sebastian.pisarski.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;

import com.gmail.sebastian.pisarski.page.LoginPage;

public class LoginSteps extends GenericSteps<LoginPage, LoginSteps> {

	private LoginPage loginPage;

	@Step
	public LoginSteps openLoginPage() {
		loginPage.open();
		return this;
	}

	@StepGroup("Enter credentials and press login")
	public <T> T enterCredentialsAndLogin(String login, String password,
			T resultSteps) {
		return enterCredentials(login, password).pressLogin(resultSteps);
	}

	@Step("Enter credentials: '{0}', '{1}'")
	public LoginSteps enterCredentials(String login, String password) {
		loginPage.getLoginInput().sendKeys(login);
		loginPage.getPasswordInput().sendKeys(password);

		return this;
	}

	@Step("Press login button")
	public <T> T pressLogin(T resultSteps) {
		loginPage.getLoginButton().click();
		return resultSteps;
	}

	@Override
	LoginPage getPage() {
		return loginPage;
	}

}
