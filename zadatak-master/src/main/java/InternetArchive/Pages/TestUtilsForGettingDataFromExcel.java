package InternetArchive.Pages;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestUtilsForGettingDataFromExcel {
    static Workbook book;
    static Sheet sheet;
    public static String TEST_DATA_PATH="/home/pepe/Documents/internetArchiveFinalni/zadatak-master/excelData/userData.xlsx";
public static Object[][] getTestData(String sheetName){
    FileInputStream file=null;
    try {
        file=new FileInputStream(TEST_DATA_PATH);
    } catch (FileNotFoundException fileNotFoundExceptione) {
        fileNotFoundExceptione.printStackTrace();
    }
    try {
        book= WorkbookFactory.create(file);
    }
    catch (InvalidFormatException ex){
        ex.printStackTrace();
    }
    catch (IOException e) {
        e.printStackTrace();
    }
    sheet=book.getSheet(sheetName);
    Object[][] data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
    for (int i=0; i<sheet.getLastRowNum();i++){
        for (int j=0;j<sheet.getRow(0).getLastCellNum(); j++){
            data[i][j]=sheet.getRow(i+1).getCell(j).toString();
        }
    }
    System.out.println(data);
return data;
}
    @DataProvider
    public Object[][] getLoginData(){
        Object data[][]= TestUtilsForGettingDataFromExcel.getTestData("loginData");
        return data;
    }
}
