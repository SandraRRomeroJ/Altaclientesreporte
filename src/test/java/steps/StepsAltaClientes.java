    package steps;

    import io.cucumber.java.Before;
    import io.cucumber.java.en.Given;
    import io.cucumber.java.en.Then;
    import io.cucumber.java.en.When;
    import org.openqa.selenium.WebDriver;

    import java.io.IOException;

    public class StepsAltaClientes {
        private WebDriver driver;
        PageAltaCliente pageAltaCliente;


        @Before()
        public void setup() {
            pageAltaCliente =new PageAltaCliente(driver);
            driver= pageAltaCliente.chromeDriverConetion();
            pageAltaCliente.visit("http://mxsrvwasmui1t.alico.corp/ClienteUnico/login.jsp");
            driver.manage().window().maximize();
            pageAltaCliente.objetoExcel();
        }

        @Given("^Ingresa al sistema satisfactoriamente \"([^\"]*)\" y \"([^\"]*)\"$")
        public void ingresaSatisfactoriamente(String usuario, String password) throws InterruptedException {
            pageAltaCliente.SingIn(usuario,password);
        }

        @When("Usuario llena datos del cliente")
        public void IngresaDatosClientes() throws IOException, InterruptedException {
            pageAltaCliente.manejoExcel();
        }

        @Then("validar id de clientes")
        public void validar_id_de_clientes() {

        }

    }
