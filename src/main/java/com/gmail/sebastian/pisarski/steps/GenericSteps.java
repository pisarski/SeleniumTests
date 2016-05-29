package com.gmail.sebastian.pisarski.steps;

import java.util.Collection;
import java.util.function.Consumer;
import java.util.function.Function;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;

import org.hamcrest.Matcher;
import org.junit.Assert;

public abstract class GenericSteps<T extends PageObject, R> {

	@Step("Assert that {0} {2}")
	public <P> R assertThat(String name, Function<T, P> fun, Matcher<P> matcher) {
		Assert.assertThat(fun.apply(getPage()), matcher);
		return (R) this;
	}

	@StepGroup("Multiple assertions")
	public R muliAssert(MultiAssert multiAssert) {
		multiAssert.multiAssert();
		return (R) this;
	}

	public R runInLoop(Collection<Object[]> params, Consumer<Object[]> consumer) {
		for (Object[] param : params) {
			consumer.accept(param);
		}
		return (R) this;
	}

	abstract T getPage();

	public static interface MultiAssert {
		void multiAssert();
	}
}
