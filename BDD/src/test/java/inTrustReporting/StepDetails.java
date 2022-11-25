package inTrustReporting;

import io.cucumber.plugin.ConcurrentEventListener;
import io.cucumber.plugin.event.EventHandler;
import io.cucumber.plugin.event.EventPublisher;
import io.cucumber.plugin.event.PickleStepTestStep;
import io.cucumber.plugin.event.TestStepStarted;

public class StepDetails implements ConcurrentEventListener {
	public static String stepName;

	public EventHandler<TestStepStarted> stepHandler = new EventHandler<TestStepStarted>() {
		@Override
		public void receive(TestStepStarted event) {
			handleTestStepStarted(event);
		}

	};

	private void handleTestStepStarted(TestStepStarted event) {
		if (event.getTestStep() instanceof PickleStepTestStep) {
			PickleStepTestStep testStep = (PickleStepTestStep) event.getTestStep();
			stepName = testStep.getStep().getText();
		}

	}

	@Override
	public void setEventPublisher(EventPublisher publisher) {
		publisher.registerHandlerFor(TestStepStarted.class, stepHandler);
	}
}
