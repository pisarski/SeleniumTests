package com.gmail.sebastian.pisarski.steps;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Steps;

public abstract class SpittrSteps<T extends PageObject, R> extends
		GenericSteps<T, R> {

	@Steps
	private LoginSteps loginSteps;

	public LoginSteps openLoginPage() {
		return loginSteps.openLoginPage();
	}

}
