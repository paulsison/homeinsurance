package com.cts.homeinsurance.automation;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ Scenario_01.class, Scenario_02.class, Scenario_03.class, Scenario_04.class, Scenario_06.class,
		Scenario_07.class, Scenario_08.class, Scenario_09.class, Scenario_10.class })
public class AllTests {
	/* Using this test suite is required. There are serial dependencies with the Scenarios. 
	 * Running the Scenarios out of order may cause failures for other tests because  the data has not been created , yet.
	 * Scenario 5 was skipped because that functionality was not in the requirements.
	 */
	

}
