package com.hubspot.Hubspot;

import org.testng.annotations.Test;

public class ScrollTo extends LaunchAndExitDriver {

	@Test
	public void mains() {

		Reusables re = new Reusables(driver);

		re.scrollToCmsHub();

		re.scrollToGetHubSpot();

	}
}
