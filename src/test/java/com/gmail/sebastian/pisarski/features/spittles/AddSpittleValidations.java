package com.gmail.sebastian.pisarski.features.spittles;

import static com.gmail.sebastian.pisarski.matchers.WebElementMatchers.textIs;

import java.util.Arrays;
import java.util.List;

import net.thucydides.core.annotations.Steps;

import org.junit.Test;

import com.gmail.sebastian.pisarski.SeleniumTest;
import com.gmail.sebastian.pisarski.model.Spittle;
import com.gmail.sebastian.pisarski.page.SpittlePage;
import com.gmail.sebastian.pisarski.steps.SpittleListSteps;
import com.gmail.sebastian.pisarski.steps.SpittleSteps;

public class AddSpittleValidations extends SeleniumTest {

	@Steps
	private SpittleListSteps spittleListSteps;

	@Steps
	private SpittleSteps spittleSteps;

	@Test
	public void shouldValidateSpittleForm() {
		String titleErrorMsg = "This field is required. Min size is 1, max size is 1024 characters.";
		String messageErrorMsg = "This field is required. Min size is 1, max size is 1024 characters.";
		
		List<Object[]> params = Arrays.asList(new Object[][] { 
				{ new Spittle(), titleErrorMsg, messageErrorMsg }, 
				{ new Spittle("", "msg"), titleErrorMsg, "" },
				{ new Spittle("title", ""), "", messageErrorMsg }
				});
		
		spittleListSteps
				.openLoginPage()
				.enterCredentialsAndLogin("admin", "admin", spittleListSteps)
				.clickOnAddNewSpittleLink()
				.runInLoop(params, data -> {
					Spittle spittle = (Spittle) data[0];
					String expectedTitleError = data[1].toString();
					String expectedMessageError = data[2].toString();
					
					spittleSteps
					.addSpittle(spittle, spittleSteps)
					.muliAssert(
							() -> spittleSteps
							.assertThat("title error", SpittlePage::getTitleErrorMsg, textIs(expectedTitleError))
							.assertThat("message error", SpittlePage::getMessageErrorMsg, textIs(expectedMessageError))
					);
				});
	}
}
