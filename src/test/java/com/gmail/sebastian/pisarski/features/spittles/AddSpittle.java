package com.gmail.sebastian.pisarski.features.spittles;

import net.thucydides.core.annotations.Steps;

import org.junit.Test;

import com.gmail.sebastian.pisarski.SeleniumTest;
import com.gmail.sebastian.pisarski.matchers.SpittleMatchers;
import com.gmail.sebastian.pisarski.model.Spittle;
import com.gmail.sebastian.pisarski.page.SpittlesListPage;
import com.gmail.sebastian.pisarski.steps.SpittleListSteps;

public class AddSpittle extends SeleniumTest {

	@Steps
	private SpittleListSteps spittleListSteps;

	@Test
	public void shouldAddNewSpittle() {
		Spittle spittle = new Spittle("selenium title", "selenium message");
		spittle.setAuthor("admin admin");

		spittleListSteps
				.openLoginPage()
				.enterCredentialsAndLogin("admin", "admin", spittleListSteps)
				.clickOnAddNewSpittleLink()
				.addSpittle(spittle, spittleListSteps)
				.assertThat("", SpittlesListPage::getSpittles,
						SpittleMatchers.hasFirstSpittleEqualTo(spittle));
	}
}
