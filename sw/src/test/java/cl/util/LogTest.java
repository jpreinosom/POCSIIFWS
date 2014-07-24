package cl.util;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.switchyard.component.test.mixins.cdi.CDIMixIn;
import org.switchyard.test.Invoker;
import org.switchyard.test.ServiceOperation;
import org.switchyard.test.SwitchYardRunner;
import org.switchyard.test.SwitchYardTestCaseConfig;
import org.switchyard.test.SwitchYardTestKit;

@RunWith(SwitchYardRunner.class)
@SwitchYardTestCaseConfig(config = SwitchYardTestCaseConfig.SWITCHYARD_XML, mixins = { CDIMixIn.class })
public class LogTest {

	private SwitchYardTestKit testKit;
	private CDIMixIn cdiMixIn;
	@ServiceOperation("Log")
	private Invoker service;

	@Test
	public void testManejaLog() throws Exception {
		// TODO Auto-generated method stub
		// initialize your test message
		String message = null;
		int result = service.operation("manejaLog").sendInOut(message)
				.getContent(int.class);

		// validate the results
		//Assert.assertTrue("Implement me", false);
	}

}
