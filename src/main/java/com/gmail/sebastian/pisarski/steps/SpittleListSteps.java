package com.gmail.sebastian.pisarski.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;

import com.gmail.sebastian.pisarski.page.SpittlesListPage;

public class SpittleListSteps extends
		SpittrSteps<SpittlesListPage, SpittleListSteps> {

	private SpittlesListPage spittlesListPage;

	@Steps
	private SpittleSteps spittleSteps;

	@Step
	public SpittleListSteps openSpittlesList() {
		spittlesListPage.openList();
		return this;
	}

	@Step
	public SpittleSteps clickOnAddNewSpittleLink() {
		spittlesListPage.getAddSpittleLink().click();
		return spittleSteps;
	}

	@Override
	SpittlesListPage getPage() {
		return spittlesListPage;
	}

}
