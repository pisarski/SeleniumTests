package com.gmail.sebastian.pisarski.features.guest_user_access;

import static org.hamcrest.CoreMatchers.is;
import net.thucydides.core.annotations.Steps;

import org.junit.Test;

import com.gmail.sebastian.pisarski.SeleniumTest;
import com.gmail.sebastian.pisarski.page.SpittrPage;
import com.gmail.sebastian.pisarski.steps.SpittleListSteps;

public class HomePageOfGuestUser extends SeleniumTest {

	@Steps
	private SpittleListSteps spittleListSteps;

	@Test
	public void shouldSeeLogoutMessage() {

		spittleListSteps.openSpittlesList().assertThat("login info text",
				SpittrPage::getLoginInfoText,
				is("You are logged out. Please log in."));

	}
}
