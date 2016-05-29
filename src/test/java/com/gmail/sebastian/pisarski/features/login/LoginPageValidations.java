package com.gmail.sebastian.pisarski.features.login;

import static org.hamcrest.CoreMatchers.is;
import net.thucydides.core.annotations.Steps;

import org.junit.Test;

import com.gmail.sebastian.pisarski.SeleniumTest;
import com.gmail.sebastian.pisarski.page.LoginPage;
import com.gmail.sebastian.pisarski.steps.LoginSteps;

public class LoginPageValidations extends SeleniumTest {

	@Steps
	private LoginSteps loginSteps;

	@Test
	public void shouldValidateRequiredFields() {
		loginSteps
				.openLoginPage()
				.enterCredentialsAndLogin("", "", loginSteps)
				.assertThat("errorMessage", LoginPage::getErrorMessage,
						is("Invalid login or password. Please try again."))
				.enterCredentialsAndLogin("login", "", loginSteps)
				.assertThat("errorMessage", LoginPage::getErrorMessage,
						is("Invalid login or password. Please try again."))
				.enterCredentialsAndLogin("", "password", loginSteps)
				.assertThat("errorMessage", LoginPage::getErrorMessage,
						is("Invalid login or password. Please try again."));
	}
}
