package com.gmail.sebastian.pisarski.matchers;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;

import com.gmail.sebastian.pisarski.model.Spittle;

public class SpittleMatchers {

	public static Matcher<List<Spittle>> hasFirstSpittleEqualTo(Spittle spittle) {
		return new BaseMatcher<List<Spittle>>() {

			@Override
			public boolean matches(Object item) {
				List<Spittle> spittles = (List<Spittle>) item;
				if (CollectionUtils.isEmpty(spittles)) {
					return false;
				}
				return spittle.equals(spittles.get(0));
			}

			@Override
			public void describeTo(Description description) {
				description.appendText(String.format(
						"first spittle on the list is equal to %s", spittle));
			}

		};
	}
}
