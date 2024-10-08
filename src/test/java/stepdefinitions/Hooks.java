package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;

public class Hooks {
	
	private String currentStepName;
	public static final String ANSI_BOLD = "\u001B[1m";
	public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLUE = "\u001B[34m";
    
    @Before
    public void beforeScenario(Scenario scenario) {
        System.out.print(ANSI_BOLD+ANSI_BLUE+"Starting Scenario: " +ANSI_RESET);
    }

    @After
    public void afterScenario(Scenario scenario) {
        System.out.print(ANSI_BOLD+ANSI_BLUE+"Ending Scenario: " + ANSI_RESET);
    }

    @BeforeStep
    public void beforeStep(Scenario scenario) {
        System.out.print(ANSI_BOLD+ANSI_BLUE+"Starting Step: " + ANSI_RESET);
    }

    @AfterStep
    public void afterStep(Scenario scenario) {
        System.out.println(ANSI_BOLD+ANSI_BLUE+"Ending Step: " +ANSI_RESET);
    }
    
    public void setCurrentStepName(String stepName) {
        this.currentStepName = stepName;
    }
}

