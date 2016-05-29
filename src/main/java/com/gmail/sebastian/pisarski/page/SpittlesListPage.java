package com.gmail.sebastian.pisarski.page;

import java.util.ArrayList;
import java.util.List;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.annotations.DefaultUrl;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.gmail.sebastian.pisarski.model.Spittle;

@DefaultUrl("/spittle/list")
public class SpittlesListPage extends SpittrPage {

	@FindBy(css = ".newSpittleLink>a")
	private WebElement addSpittleLink;

	@FindBy(css = ".userManagementLink>a")
	private WebElement userManagementLink;

	@FindBy(css = ".spittle")
	private List<WebElement> spittles;

	public SpittlesListPage openList() {
		open();
		return this;
	}

	public WebElement getAddSpittleLink() {
		return addSpittleLink;
	}

	public WebElement getUserManagementLink() {
		return userManagementLink;
	}

	public List<Spittle> getSpittles() {
		List<Spittle> result = new ArrayList<Spittle>();

		for (WebElement listElement : spittles) {
			Spittle spittle = new Spittle();
			setAuthorInfo(listElement, spittle);
			setTitle(listElement, spittle);
			setMessage(listElement, spittle);
			result.add(spittle);
		}

		return result;
	}

	private void setAuthorInfo(WebElement listElement, Spittle spittle) {
		spittle.setAuthor(listElement
				.findElement(By.cssSelector(".userInfo .userName")).getText()
				.substring("by: ".length()));
	}

	private void setTitle(WebElement listElement, Spittle spittle) {
		spittle.setTitle(listElement.findElement(
				By.cssSelector(".spittleInfo .titleText")).getText());
	}

	private void setMessage(WebElement listElement, Spittle spittle) {
		spittle.setMessage(listElement.findElement(
				By.cssSelector(".spittleInfo .message")).getText());

	}
}
