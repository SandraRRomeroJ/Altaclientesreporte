package steps;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class PageAltaCliente extends Base {
    private Base base;

    public PageAltaCliente(WebDriver driver) {
        base=new Base(this.driver);
    }

    private WriteExcelFile writeFile;
    private ReadExcelFile readFile;

    public void objetoExcel(){
        writeFile=new WriteExcelFile();
        readFile=new ReadExcelFile();
    }


    //identificador para boton clientes
    By btnCliente= By.id("btn_crearCte");

    //identificadores Datos minímos
    By listLineaNegocio=By.xpath("//input[@id='lineaNegocioSlct']/ancestor::div/preceding-sibling::div/preceding-sibling::div/input");
    By txtLineaNegocio=By.id("lineaNegocioSlct");
    By listRamo=By.xpath("//input[@id='ramoSlct']/ancestor::div/preceding-sibling::div/preceding-sibling::div/input");
    By txtRamo=By.id("ramoSlct");
    By listProducto=By.xpath("//input[@id='productoSlct']/ancestor::div/preceding-sibling::div/preceding-sibling::div/input");
    By txtProducto=By.id("productoSlct");
    By listRol=By.xpath("//input[@id='rolesSlct']/ancestor::div/preceding-sibling::div/preceding-sibling::div/input");
    By txtRol=By.id("rolesSlct");
    By btnPF=By.cssSelector("span[id='btnDatoPF']");

    //Datos Generales
    By listtitulo=By.xpath("//input[@id='tituloID']/ancestor::div/preceding-sibling::div/preceding-sibling::div/input");
    By txtNombre=By.cssSelector("input[id='nombreID']");
    By txtAPaterno=By.cssSelector("input[id='aPatID']");
    By txtAMaterno=By.cssSelector("input[id='aMatID']");
    By txtFNacimiento=By.cssSelector("input[id='fNacID']");
    By txtRFC=By.cssSelector("input[id='rfcID']");
    By txtCURP=By.id("curpID");
    By listGenero=By.xpath("//input[@id='generoID']/ancestor::div/preceding-sibling::div/preceding-sibling::div/input");
    By opcionGenero=By.id("generoID");
    By listEdoCivil=By.xpath("//input[@id='edoCivID']/ancestor::div/preceding-sibling::div/preceding-sibling::div/input");
    By opcionEdoCivil=By.id("edoCivID");
    By listIdentificación=By.xpath("//input[@id='tipoIdID']/ancestor::div/preceding-sibling::div/preceding-sibling::div/input");
    By txtNumIdent=By.id("numIdID");
    By txtNSS=By.id("nssID");

    //Seccion lugar de nacimiento
    By seccionLugarNacimiento=By.id("lugarNacId");
    By listPaisNacimiento=By.xpath("//input[@id='paisNacID']/ancestor::div/preceding-sibling::div/preceding-sibling::div/input");
    By txtPaisNacimiento=By.id("paisNacID");
    By txtEdoProv=By.id("edoNacID");
    By txtMpio=By.id("mpioNacID");
    By btnAgregarNacionalidad=By.xpath("//div[@id='nacionalidadId']/table/tbody/tr/td/span/span/span");
    By listNacionalidad=By.xpath("//div[@id='tblDGPF']/div[2]/div/div/div/div/div/table/tbody/tr/td[1]/div/div[1]/input");
    By txtNacionalidad=By.xpath("//div[@id='tblDGPF']/div[2]/div/div/div/div/div/table/tbody/tr/td[1]/div/div[3]/input");
    By btnCofiNacionalidad=By.xpath("//div[@id='tblDGPF']/div[2]/div/div/div/div/div/table/tbody/tr/td[2]/div/span[1]/span/span");

    //Domicilios
    By seccionDomicilios=By.id("direccionId");
    By btnAgregarDom=By.id("btnAgregarDomicilio");
    By listTipoDom=By.xpath("//div[@id='direccionId']/div[2]/div/div/div/div[2]/div/div/div/div/div/table/tbody/tr/td[1]/div[1]/div[1]");
    By txtTipoDom=By.xpath("//div[@id='direccionId']/div[2]/div/div/div/div[2]/div/div/div/div/div/table/tbody/tr/td[1]/div/div[3]/input");
    By opcionCalleAve=By.xpath("//div[@id='direccionId']/div[2]/div/div/div/div[2]/div/div/div/div/div/table/tbody/tr/td[2]");
    By txtCalleAve=By.cssSelector("input[id*='dijit_form_ValidationTextBox']");
    By opcionNumExt=By.xpath("//div[@id='direccionId']/div[2]/div/div/div/div[2]/div/div/div/div/div/table/tbody/tr/td[3]");
    By txtNumExt=By.xpath("//div[@id='direccionId']/div[2]/div/div/div/div[2]/div/div/div/div/div/table/tbody/tr/td[3]/div/div[2]/input");
    By opcionCP=By.xpath("//div[@id='direccionId']/div[2]/div/div/div/div[2]/div/div/div/div/div/table/tbody/tr/td[5]");
    By txtCP=By.xpath("//div[@id='direccionId']/div[2]/div/div/div/div[2]/div/div/div/div/div/table/tbody/tr/td[5]/div/div[3]/input");
    By opcionColonia=By.xpath("//div[@id='direccionId']/div[2]/div/div/div/div[2]/div/div/div/div/div/table/tbody/tr/td[6]");
    By txtColonia=By.xpath("//div[@id='direccionId']/div[2]/div/div/div/div[2]/div/div/div/div/div/table/tbody/tr/td[6]/div/div[3]/input");
    By opcionMunDel=By.xpath("//div[@id='direccionId']/div[2]/div/div/div/div[2]/div/div/div/div/div/table/tbody/tr/td[7]");
    By txtMunDel=By.cssSelector("input[id*='dijit_form_ComboBox']");
    By opcionCiudad=By.xpath("//div[@id='direccionId']/div[2]/div/div/div/div[2]/div/div/div/div/div/table/tbody/tr/td[8]");
    By txtCiudad=By.xpath("//div[@id='direccionId']/div[2]/div/div/div/div[2]/div/div/div/div/div/table/tbody/tr/td[8]/div/div[3]/input");
    By opcionEstado=By.xpath("//div[@id='direccionId']/div[2]/div/div/div/div[2]/div/div/div/div/div/table/tbody/tr/td[9]");
    By txtEstado=By.xpath("//div[@id='direccionId']/div[2]/div/div/div/div[2]/div/div/div/div/div/table/tbody/tr/td[9]/div/div[3]/input");
    By btnAgDom=By.xpath("//div[@id='direccionId']/div[2]/div/div/div/div[2]/div/div/div/div/div/table/tbody/tr/td[15]/div/span/span/span[@title='ok']");

    //Seccion telefonos
    By seccionTelefonos= By.id("telefonoIdPF");
    By btnAgregarTel=By.id("btnAgregarTel");
    By listTipoTel=By.xpath("//div[@id='tblTelPF']/div[2]/div/div/div/div/div/table/tbody/tr/td[1]/div/div[1]/input");
    By txtTipoTel=By.xpath("//div[@id='tblTelPF']/div[2]/div/div/div/div/div/table/tbody/tr/td[1]/div/div[3]/input");
    By columnaNumTel=By.xpath("//div[@id='tblTelPF']/div[2]/div/div/div/div/div/table/tbody/tr/td[2]");
    By txtNumTel=By.xpath("//div[@id='tblTelPF']/div[2]/div/div/div/div/div/table/tbody/tr/td[2]/div/div[2]/input");
    By btnOkTel=By.xpath("//div[@id='tblTelPF']/div[2]/div/div/div/div/div/table/tbody/tr/td[4]/div/span[1]/span/span");

    //Seccion ocupacion
    By pestOcupacion=By.id("tabUpdateCustomer_tablist_OcupacionID");
    By seccionOcupacion=By.id("ocupaPagoId_titleBarNode");
    By btnAgregarOcupacion=By.xpath("//div[@id='tblOC']/following-sibling::div/span/span/span");
    By listOcupacion=By.xpath("//div[@id='tblOC']/div[2]/div/div/div/div/div/table/tbody/tr/td[1]/div[1]/div[1]/input");
    By txtOcupacion= By.xpath("//div[@id='tblOC']/div[2]/div/div/div/div/div/table/tbody/tr/td[1]/div/div[3]/input");
    By columnaClaveOcupacion= By.xpath("//div[@id='tblOC']/div[2]/div/div/div/div/div/table/tbody/tr/td[2]");
    By listClaveOcupacion=By.xpath("//div[@id='tblOC']/div[2]/div/div/div/div/div/table/tbody/tr/td[2]/div/div[1]");
    By txtClaveOcupacion=By.xpath("//div[@id='tblOC']/div[2]/div/div/div/div/div/table/tbody/tr/td[2]/div/div[3]/input");
    By columnaDetalleOcupa= By.xpath("//div[@id='tblOC']/div[2]/div/div/div/div/div/table/tbody/tr/td[3]");
    By txtDetalleOcupa=By.xpath("//div[@id='tblOC']/div[2]/div/div/div/div/div/table/tbody/tr/td[3]/div/div[2]/input");
    By  btnOkOcupacion=By.xpath("//div[@id='tblOC']/div[2]/div/div/div/div/div/table/tbody/tr/td[4]/div/span[1]/span/span");

    //Sección ingreso mensual
    By txtIngresoMensual=By.id("ingMenID");

    //Declaraciones y perfil transaccional
    By btnPestañaDeclaPErfilTrans=By.id("tabUpdateCustomer_tablist_dptTab");
    By txtapoNumTranAnual=By.id("ptNumTransID");
    By txtretNumTranAnual=By.id("ptNumRetirosID");
    By txtapoMonTrnAnual=By.id("ptMontTransID");
    By txtretMonTrnAnual=By.id("ptMontRetirosID");

    //Seccion declaraciones
    By rbtnFuncionesPublicN=By.id("pepID_N");
    By rbtnFuncionesPublicS=By.id("pepID_S");

    //Aviso de privacidad
    By pestañaAvisoPrivacidad=By.id("tabUpdateCustomer_tablist_pdcTab");
    By rbtnDivulgacionDatosS=By.id("reusID_S");
    By rbtnDivulgacionDatosN=By.id("reusID_N");

    //confirmar cliente
    By btnGuardar=By.xpath("//div[@id='commentsCusId']/following-sibling::div/span[4]/span/span");
    By btnConfirGuardar=By.xpath("//div[contains(@id,'dijit_Dialog')]/div[2]/div[2]/span[1]/span/span");
    By btnAceptConfirm=By.xpath("//div[contains(@id,'dijit_Dialog')][3]/div[2]/div[2]/span/span/span");
    By txtIdCliente=By.xpath("//div[contains(@id,'dijit_layout_ContentPane')]/table/tbody/tr/td[2]/label/b");


    By txtSatisfactorio=By.xpath("//label[contains(text(),'Operación realizada satisfactoriamente')]");
    By txtError=By.xpath("//div[contains(text(), 'Consulte al administrador')]");
    By btnAceptarError=By.xpath("//div[@class='dijitContentPane'][2]/span/span/span");
    By btnSiPerderCambios=By.xpath("//span[contains(text(),'Confirmación')]/ancestor::div[1]/following-sibling::div/div[2]/span[1]/span/span");
    public void manejoExcel() throws IOException, InterruptedException {

        String filepath="data/DatosClientes.xlsx";
        String sheetName="Hoja1";

        //driver.findElement(searchBoxLocator).sendKeys("dresses");

        File file = new File(filepath);

        //objeto que almacenará los datos del archivo Excel
        FileInputStream inputStream=new FileInputStream(filepath);

        //Objeto donde se va a guardar el archivo excel
        XSSFWorkbook newWorbook=new XSSFWorkbook(inputStream);

        //objeto donde se va a guardar la hoja de excel, obteniendolo del objeto donde se guarda el archivo excele pasandole el nombre d ela hoja shhetName
        XSSFSheet newSheet=newWorbook.getSheet(sheetName);

        //variable en la que se guarda la cantidad de fila que tiene la hoja de excel
        int rowCount=newSheet.getLastRowNum()-newSheet.getFirstRowNum();
        //System.out.println("numero de filas es: "+rowCount);
        String errorComunicacion="";

        for(int i=1;i<=rowCount;i++){
            //objeto para leer cada fila de la hoja excel
            XSSFRow row=newSheet.getRow(i);
            Click(btnCliente);
            if(errorComunicacion.equals("Ocurrió un problema al procesar la petición. Consulte al administrador de la aplicación.")) {
                Thread.sleep(500);
                Click(btnSiPerderCambios);
            }


            int columna=0;
            for (int j=0;j<row.getLastCellNum();j++){

                XSSFRow row2=newSheet.getRow(0);

                if(!(row.getCell(j).getStringCellValue()).equals("")){
                   // System.out.println("--"+row2.getCell(j).getStringCellValue()+"--");
                    //System.out.println(row.getCell(j).getStringCellValue());

                    switch (row2.getCell(j).getStringCellValue()){
                        case "lineaNegocio":
                            Click(listLineaNegocio);
                            By etiquetaLineNegocio=By.xpath("//*[text()='"+row.getCell(j).getStringCellValue()+"']");
                            esperaListDesplegable(etiquetaLineNegocio);
                            keyEnter(txtLineaNegocio);
                            break;
                        case "ramo":
                            Click(listRamo);
                            By etiquetaRamo=By.xpath("//*[text()='"+row.getCell(j).getStringCellValue()+"']");
                            esperaListDesplegable(etiquetaRamo);
                            keyEnter(txtRamo);
                            break;
                        case "producto":
                            Click(listProducto);
                            By etiquetaProducto=By.xpath("//*[text()='"+row.getCell(j).getStringCellValue()+"']");
                            esperaListDesplegable(etiquetaProducto);
                            keyEnter(txtProducto);
                            break;
                        case "rol":
                            Click(listRol);
                            By etiquetaRol=By.xpath("//*[text()='"+row.getCell(j).getStringCellValue()+"']");
                            esperaListDesplegable(etiquetaRol);
                            keyTab(txtRol);
                            Click(btnPF);    //clic sobre botn Persona fisica
                            break;
                        case "titulo":
                            Click(listtitulo);
                            By etiquetaTitulo=By.xpath("//*[text()='"+row.getCell(j).getStringCellValue()+"']");
                            esperaListDesplegable(etiquetaTitulo);
                            keyEnter(listtitulo);
                            break;
                        case "nombre":
                            type(row.getCell(j).getStringCellValue(),txtNombre);
                            break;
                        case "aPaterno":
                            type(row.getCell(j).getStringCellValue(),txtAPaterno);
                            break;
                        case "aMaterno":
                            type(row.getCell(j).getStringCellValue(),txtAMaterno);
                            break;
                        case "fecNaci":
                            type(row.getCell(j).getStringCellValue(),txtFNacimiento);
                            break;
                        case "rfc":
                            type(row.getCell(j).getStringCellValue(),txtRFC);
                            break;
                        case "curp":
                            type(row.getCell(j).getStringCellValue(),txtCURP);
                            break;
                        case "genero":
                            Click(listGenero);
                            By etiquetaMasculino=By.xpath("//*[text()='"+row.getCell(j).getStringCellValue()+"']");
                            esperaListDesplegable(etiquetaMasculino);
                            keyEnter(opcionGenero);
                            break;
                        case "edoCivil":
                            Click(listEdoCivil);
                            By etiquetaEdoCivil=By.xpath("//*[text()='"+row.getCell(j).getStringCellValue()+"']");
                            esperaListDesplegable(etiquetaEdoCivil);
                            keyEnter(opcionEdoCivil);
                            break;
                        case "tipoIdent":
                            Click(listIdentificación);
                            By etiquetaTipoIdent=By.xpath("//*[text()='"+row.getCell(j).getStringCellValue()+"']");
                            esperaListDesplegable(etiquetaTipoIdent);
                            keyEnter(listIdentificación);
                            break;
                        case "numIdent":
                            type(row.getCell(j).getStringCellValue(),txtNumIdent);
                            break;
                        case "nss":
                            type(row.getCell(j).getStringCellValue(),txtNSS);
                            break;
                        case "paisNaci":
                            Thread.sleep(500);
                            Click(seccionLugarNacimiento); //abre seccion Lugar de nacimiento
                            Thread.sleep(700);
                            Click(listPaisNacimiento);
                            Thread.sleep(2000);
                            type(row.getCell(j).getStringCellValue(),txtPaisNacimiento);
                            keyTab(txtPaisNacimiento);
                            Thread.sleep(500);
                            break;
                        case "edoPro":
                            type(row.getCell(j).getStringCellValue(),txtEdoProv);
                            break;
                        case "ciuPoblacion":
                            type(row.getCell(j).getStringCellValue(),txtMpio);
                            break;
                        case "nacionalidad":
                            Click(btnAgregarNacionalidad); //clic sobre boton agregar nacionalidad
                            Thread.sleep(500);
                            Click(listNacionalidad);
                            Thread.sleep(1500);
                            type(row.getCell(j).getStringCellValue(),txtNacionalidad);
                            esperaListDesplegable(btnCofiNacionalidad); //clic sobre boton palomita verde seccion lugar nacionalidad
                            break;
                        case "tipoDomic":
                            Click(seccionDomicilios); //clic sobre seccion Domicilios
                            esperaListDesplegable(btnAgregarDom); //clic sobre boton agregar domicilios

                            Click(listTipoDom);
                            Thread.sleep(500);
                            type(row.getCell(j).getStringCellValue(),txtTipoDom);
                            keyTab(txtTipoDom);
                            Thread.sleep(500);
                            break;
                        case "calleAvenida":
                            Click(opcionCalleAve);
                            type(row.getCell(j).getStringCellValue(),txtCalleAve);
                            break;
                        case "numExt":
                        	Thread.sleep(1000);
                            Click(opcionNumExt);
                            Thread.sleep(1000);
                            type(row.getCell(j).getStringCellValue(),txtNumExt);
                            break;
                        case "cp":
                            Click(opcionCP);
                            type(row.getCell(j).getStringCellValue(),txtCP);
                            keyEnter(txtCP);
                            break;
                        case "colonia":
                            Thread.sleep(1000);
                            Click(opcionColonia);
                            type(row.getCell(j).getStringCellValue(),txtColonia);
                            keyEnter(txtColonia);
                            break;
                        case "municDeleg":
                            Click(opcionMunDel);
                            type(row.getCell(j).getStringCellValue(),txtMunDel);
                            keyEnter(txtMunDel);
                            break;
                        case "ciudad":
                            Click(opcionCiudad);
                            type(row.getCell(j).getStringCellValue(),txtCiudad);
                            keyEnter(txtCiudad);
                            break;
                        case "estado":
                            Click(opcionEstado);
                            type(row.getCell(j).getStringCellValue(),txtEstado);
                            keyEnter(txtEstado);
                            Thread.sleep(500);
                            Click(btnAgDom); //clic sobre boton palomita verde para agregar docmicilios
                            break;
                        case "Tipo":
                            Click(seccionTelefonos); //Clic sobre seccion telefonos
                            esperaListDesplegable(btnAgregarTel); //Clic sobre boton agregar telefonos

                            Click(listTipoTel);

                            //By etiquetaTipoTel=By.xpath("//*[text()='"+row.getCell(j).getStringCellValue()+"']");
                            //esperaListDesplegable(etiquetaTipoTel);
                            //keyEnter(listTipoTel);

                            Thread.sleep(500);
                            type(row.getCell(j).getStringCellValue(),txtTipoTel);
                            keyTab(txtTipoTel);
                            Thread.sleep(500);

                            break;
                        case "numTel":
                            Click(columnaNumTel);
                            Thread.sleep(1000);
                            type(row.getCell(j).getStringCellValue(),txtNumTel);
                            Click(btnOkTel);
                            break;
                        case "ocupacion":
                            Click(pestOcupacion); //Clic sobre pestaña ocupacion
                            Click(seccionOcupacion);   //clic sobre seccion ocupaciones
                            esperaListDesplegable(btnAgregarOcupacion); //clic sobre agregar ocupacion

                            Click(listOcupacion);
                            type(row.getCell(j).getStringCellValue(),txtOcupacion);
                            keyEnter(txtOcupacion);
                            Thread.sleep(500);
                            break;
                        case "claveOcupa":
                            esperaListDesplegable(columnaClaveOcupacion);
                            Click(listClaveOcupacion);
                            //By etiquetaClaveOcupacion=By.xpath("//*[text()='"+row.getCell(j).getStringCellValue()+"']");
                            //esperaListDesplegable(etiquetaClaveOcupacion);

                            Thread.sleep(500);
                            type(row.getCell(j).getStringCellValue(),txtClaveOcupacion);
                            keyTab(txtClaveOcupacion);
                            Thread.sleep(500);

                            break;
                        case "detalleOcupa":
                            Click(columnaDetalleOcupa);
                            type(row.getCell(j).getStringCellValue(),txtDetalleOcupa);
                            Click(btnOkOcupacion); //clic sobre boton palomita verde para agregar ocupacion
                            break;
                        case "ingresoMensual":
                            type(row.getCell(j).getStringCellValue(),txtIngresoMensual);
                            break;
                        case "apoNumTranAnual":
                            Click(btnPestañaDeclaPErfilTrans);
                            type(row.getCell(j).getStringCellValue(),txtapoNumTranAnual);
                            break;
                        case "retNumTranAnual":
                            type(row.getCell(j).getStringCellValue(),txtretNumTranAnual);
                            break;
                        case "apoMonTrnAnual":
                            type(row.getCell(j).getStringCellValue(),txtapoMonTrnAnual);
                            break;
                        case "retMonTrnAnual":
                            type(row.getCell(j).getStringCellValue(),txtretMonTrnAnual);
                            break;
                        case "funcionesPublicas":
                            if (!((row.getCell(j).getStringCellValue()).toUpperCase()).equals("NO")){
                                esperaListDesplegable(rbtnFuncionesPublicS);
                            }else{
                                esperaListDesplegable(rbtnFuncionesPublicN);
                            }
                            break;
                        case "divulgarDatos":
                            Click(pestañaAvisoPrivacidad);
                            if (!((row.getCell(j).getStringCellValue()).toUpperCase()).equals("NO")){
                                esperaListDesplegable(rbtnDivulgacionDatosS);
                            }else{
                                esperaListDesplegable(rbtnDivulgacionDatosN);
                            }
                            break;
                        default:
                            System.out.println("valor invalido");
                    }
                }
                else{
                    break;
                }


                columna=j;
            }
            System.out.println("sale de for para la fila"+i);

            Thread.sleep(500);
            Click(btnGuardar);
            Thread.sleep(500);
            Click(btnConfirGuardar);
            //Thread.sleep(500);
            //System.out.println("El ID del cliente es (en el try): "+obtieneTexto(txtIdCliente));
            Thread.sleep(1500);
            //EscribeExcel
            try{
                writeFile.writeCellValue(filepath,sheetName,i,columna+1,obtieneTexto(txtIdCliente));
                Click(btnAceptConfirm);
            }catch (Exception e){
                writeFile.writeCellValue(filepath,sheetName,i,columna+1,obtieneTexto(txtError));
                Thread.sleep(1000);
                errorComunicacion=obtieneTexto(txtError);
                Click(btnAceptarError);
            }
            Thread.sleep(3000);
        }
    }

     By user=By.id("login_usuario");
    By pwd=By.id("login_contrasenya");
    By ingresar=By.id("btn");
    By tituloObtenido=By.partialLinkText("Cerrar");

    public void SingIn(String usuario, String password) throws InterruptedException {
        if (isDisplayed(user)){
            type(usuario,user);
            type(password,pwd);
            Click(ingresar);
        }else{
            System.out.println("UserName textbox was not present");
        }
    }

    public boolean isHomeDisplayed(){
        return isDisplayed(tituloObtenido);
    }


}
