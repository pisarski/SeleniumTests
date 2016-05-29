package com.gmail.sebastian.pisarski.features.login;

import static org.hamcrest.CoreMatchers.is;
import net.thucydides.core.annotations.Steps;

import org.junit.Test;

import com.gmail.sebastian.pisarski.SeleniumTest;
import static com.gmail.sebastian.pisarski.matchers.WebElementMatchers.*;
import com.gmail.sebastian.pisarski.page.SpittlesListPage;
import com.gmail.sebastian.pisarski.page.SpittrPage;
import com.gmail.sebastian.pisarski.steps.LoginSteps;
import com.gmail.sebastian.pisarski.steps.SpittleListSteps;

public class LoginAsAdmin extends SeleniumTest {

	@Steps
	private LoginSteps loginSteps;

	@Steps
	private SpittleListSteps spittleListSteps;

	@Test
	public void shouldLoginAsAdmin() {
		loginSteps
				.openLoginPage()
				.enterCredentialsAndLogin("admin", "admin", spittleListSteps)
				.muliAssert(
						() -> spittleListSteps
						.assertThat("login info text", SpittrPage::getLoginInfoText, is("You are logged in as admin | Logout"))
						.assertThat("New spittle link", SpittlesListPage::getAddSpittleLink, isVisible())
						.assertThat("User management link", SpittlesListPage::getUserManagementLink, isVisible()));
		;
	}
}
