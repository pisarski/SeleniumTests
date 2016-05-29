package com.gmail.sebastian.pisarski.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;

import com.gmail.sebastian.pisarski.model.Spittle;
import com.gmail.sebastian.pisarski.page.SpittlePage;

public class SpittleSteps extends SpittrSteps<SpittlePage, SpittleSteps> {

	private SpittlePage spittlePage;

	@StepGroup("add new spittle")
	public <T> T addSpittle(Spittle spittle, T resultSteps) {
		return enterSpittleData(spittle).clickOnCreateButton(resultSteps);
	}

	@Step
	public SpittleSteps enterSpittleData(Spittle spittle) {
		spittlePage.getTitleInput().clear();
		spittlePage.getMessageInput().clear();
		spittlePage.getTitleInput().sendKeys(spittle.getTitle());
		spittlePage.getMessageInput().sendKeys(spittle.getMessage());

		return this;
	}

	@Step("Click on create button")
	public <T> T clickOnCreateButton(T resultSteps) {
		spittlePage.getCreateButton().click();
		return resultSteps;
	}

	@Override
	SpittlePage getPage() {
		return spittlePage;
	}

}
