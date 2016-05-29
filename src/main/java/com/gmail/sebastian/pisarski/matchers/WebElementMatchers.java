package com.gmail.sebastian.pisarski.matchers;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.openqa.selenium.WebElement;

public class WebElementMatchers {

	public static Matcher<WebElement> isVisible() {
		return new BaseMatcher<WebElement>() {

			@Override
			public boolean matches(Object item) {
				WebElement element = (WebElement) item;
				return element.isDisplayed();
			}

			@Override
			public void describeTo(Description description) {
				description.appendText("is visible");
			}
		};
	}

	public static Matcher<WebElement> textIs(String text) {
		return new BaseMatcher<WebElement>() {

			@Override
			public boolean matches(Object item) {
				WebElement element = (WebElement) item;
				return text.equals(getText(element));
			}

			private String getText(WebElement element) {
				try {
					return element.getText();
				} catch (Exception e) {
					return "";
				}
			}

			@Override
			public void describeTo(Description description) {
				description.appendText(String.format("is '%s'", text));
			}

			@Override
			public void describeMismatch(Object item, Description description) {
				super.describeMismatch(getText((WebElement) item), description);
			}

		};
	}
}
