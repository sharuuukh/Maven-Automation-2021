package Day11_041021;

import ReusableLibrary.Abstract_Class;
import ReusableLibrary.Reusable_Actions;
import com.relevantcodes.extentreports.LogStatus;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class MlCalc_DataDriven_TestNG_Abstract extends Abstract_Class {

    @Test
    public void MlCalcMonthlyPayment() throws InterruptedException, WriteException, IOException, BiffException {

        Workbook readableBook = Workbook.getWorkbook(new File("src/main/resources/MlCalcData.xls"));
        WritableWorkbook writableWorkbook = Workbook.createWorkbook(new File("src/main/resources/MlCalcResults.xls"), readableBook);
        WritableSheet writableSheet = writableWorkbook.getSheet(0);
        int rowCount = writableSheet.getRows();

        for(int i =1; i <rowCount; i++){

            String pPrice = writableSheet.getCell(0,i).getContents();
            String dPayment = writableSheet.getCell(1,i).getContents();
            String mTerm = writableSheet.getCell(2,i).getContents();
            String iRate = writableSheet.getCell(3,i).getContents();
            String stMonth = writableSheet.getCell(4,i).getContents();
            String stYear = writableSheet.getCell(5,i).getContents();

            driver.navigate().to("https://www.mlcalc.com");
            Thread.sleep(1000);
            Reusable_Actions.sendKeysMethod(driver,"//input[@id='ma']",pPrice,logger,"Purchase Price");
            Reusable_Actions.sendKeysMethod(driver,"//input[@id='dp']",dPayment,logger,"Down Payment");
            Reusable_Actions.sendKeysMethod(driver,"//input[@id='mt']",mTerm,logger,"Mortgage Term");
            Reusable_Actions.sendKeysMethod(driver,"//input[@id='ir']",iRate,logger,"Interest Rate");
            Reusable_Actions.clickOnElement(driver, "//*[text()='Show advanced options']", logger, "Advanced Options");
            Reusable_Actions.dropdownByText(driver,"//select[@name='sm']",stMonth,logger,"Start Month");
            Reusable_Actions.dropdownByText(driver,"//select[@name='sy']",stYear,logger,"Start Year");
            Reusable_Actions.clickOnElement(driver,"//input[@value='Calculate']",logger,"Calculate");
            Thread.sleep(1000);

            String monthlyPayment = Reusable_Actions.captureText(driver,"//td[@align='center']",0,logger,"Monthly Payment");
            logger.log(LogStatus.INFO,"The monthly payment is: " + monthlyPayment);

            Label label = new Label(6,i, monthlyPayment);
            writableSheet.addCell(label);

        }
        writableWorkbook.write();
        writableWorkbook.close();
    }

}


