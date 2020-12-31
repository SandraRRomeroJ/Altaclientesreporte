package steps;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadExcelFile extends Base {
    private Base base;



    public ReadExcelFile() {

    }

    By searchBoxLocator=By.id("search_query_top");
    By searchBtnLocator=By.name("submit_search");
    By resultTextLocator=By.cssSelector("span.heading-counter");

    public void readExcel(String filepath, String sheetName) throws IOException {

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
        System.out.println("numero de filas es: "+rowCount);
        for(int i=1;i<=rowCount;i++){
            //objeto para leer cada fila de la hoja excel
            XSSFRow row=newSheet.getRow(i);
            for (int j=0;j<row.getLastCellNum();j++){

                XSSFRow row2=newSheet.getRow(0);
                //System.out.println("--"+row2.getCell(j).getStringCellValue()+"--");;
                //System.out.println(row.getCell(j).getStringCellValue()+"||");

                if(!(row.getCell(j).getStringCellValue()).equals("")){
                    System.out.println("--"+row2.getCell(j).getStringCellValue()+"--");
                    System.out.println(row.getCell(j).getStringCellValue());

                    switch (row2.getCell(j).getStringCellValue()){
                        case "USER":
                            System.out.println("ejecuta lo que hay en la celda user");
                            System.out.println(row.getCell(j).getStringCellValue());


                            break;
                        case "DESCRIPTION":
                            System.out.println("ejecuta lo que hay en la celda description");
                            break;
                        default:
                            System.out.println("valor invalido");
                    }
                }
                else{
                    break;
                }


            }
        }
    }

    public String getCellValue(String filepath, String sheetName, int rowNumber, int cellNumber) throws IOException{
        File file = new File(filepath);
        //objeto que almacenará los datos del archivo Excel
        FileInputStream inputStream=new FileInputStream(filepath);
        //Objeto donde se va a guardar el archivo excel
        XSSFWorkbook newWorbook=new XSSFWorkbook(inputStream);
        //objeto donde se va a guardar la hoja de excel, obteniendolo del objeto donde se guarda el archivo excele pasandole el nombre d ela hoja shhetName
        XSSFSheet newSheet=newWorbook.getSheet(sheetName);

        XSSFRow row=newSheet.getRow(rowNumber);
        XSSFCell cell=row.getCell(cellNumber);

        return cell.getStringCellValue();
    }

}
