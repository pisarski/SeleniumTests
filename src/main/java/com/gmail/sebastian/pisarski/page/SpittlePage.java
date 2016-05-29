package com.gmail.sebastian.pisarski.page;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;

import org.openqa.selenium.WebElement;

@DefaultUrl("/spittle/new")
public class SpittlePage extends PageObject {

	@FindBy(css = "#title")
	private WebElement titleInput;

	@FindBy(css = "#message")
	private WebElement messageInput;

	@FindBy(css = "button[type='submit']")
	private WebElement createButton;

	@FindBy(xpath = "//*[@id='title.errors']")
	private WebElement titleErrorMsg;

	@FindBy(xpath = "//*[@id='message.errors']")
	private WebElement messageErrorMsg;

	public WebElement getTitleInput() {
		return titleInput;
	}

	public WebElement getMessageInput() {
		return messageInput;
	}

	public WebElement getCreateButton() {
		return createButton;
	}

	public WebElement getTitleErrorMsg() {
		return titleErrorMsg;
	}

	public WebElement getMessageErrorMsg() {
		return messageErrorMsg;
	}
}
