package runners;


import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/AltaCliente.feature",
		glue={"StepsAltaClientes"},
		plugin = {"json:target/cucumber.json"}
)
		

public class RunCucumberTest {


}
