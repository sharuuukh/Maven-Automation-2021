package Day11_041021;

import Day9_040321.Reusable_Methods;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class MlCalc_DataDriven_TestNG {

    WebDriver driver;
    WritableWorkbook writableWorkbook;
    WritableSheet writableSheet;
    int rowCount;

    @BeforeSuite
    public void preConditions() throws IOException, BiffException {
        driver = Reusable_Methods.defineTheDriver();

        Workbook readableBook = Workbook.getWorkbook(new File("src/main/resources/MlCalcData.xls"));
        writableWorkbook = Workbook.createWorkbook(new File("src/main/resources/MlCalcResults.xls"), readableBook);
        writableSheet = writableWorkbook.getSheet(0);
        rowCount = writableSheet.getRows();
    }

    @Test
    public void testing() throws InterruptedException, WriteException {
        for(int i =1; i <rowCount; i++){

            String pPrice = writableSheet.getCell(0,i).getContents();
            String dPayment = writableSheet.getCell(1,i).getContents();
            String mTerm = writableSheet.getCell(2,i).getContents();
            String iRate = writableSheet.getCell(3,i).getContents();
            String stMonth = writableSheet.getCell(4,i).getContents();
            String stYear = writableSheet.getCell(5,i).getContents();

            driver.navigate().to("https://www.mlcalc.com");
            Thread.sleep(3000);
            Reusable_Methods.sendKeysMethod(driver,"//input[@id='ma']",pPrice,"Purchase Price");
            Reusable_Methods.sendKeysMethod(driver,"//input[@id='dp']",dPayment,"Down Payment");
            Reusable_Methods.sendKeysMethod(driver,"//input[@id='mt']",mTerm,"Mortgage Term");
            Reusable_Methods.sendKeysMethod(driver,"//input[@id='ir']",iRate,"Interest Rate");
            //Reusable_Methods.dropdownByText(driver,"//select[@name='sm']",stMonth,"Start Month");
            //Reusable_Methods.dropdownByText(driver,"//select[@name='sy']",stYear,"Start Year");
            Reusable_Methods.clickOnElement(driver,"//input[@value='Calculate']","Calculate");

            String monthlyPayment = Reusable_Methods.captureText(driver,"//td[@class='big']",0,"Monthly Payment");

            Label label = new Label(6,i, monthlyPayment);
            writableSheet.addCell(label);
        }
    }

    @AfterSuite
            public void closeWorkbook() throws IOException, WriteException {
        writableWorkbook.write();
        writableWorkbook.close();
    }

}
