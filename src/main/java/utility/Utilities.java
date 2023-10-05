package utility;

import com.google.gson.JsonObject;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Date;
import java.util.Random;

public class Utilities {
    //ToDo: Select random methods
    public static int generateRandomNumber(int lowerBound, int upperBound) {
        // Create a new instance of the Random class
        Random random = new Random();

        // Generate a random number between lowerBound and upperBound, inclusive
        int randomNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;

        return randomNumber;
    }

    //ToDo: Capture screenshots
    public static void Capturescreenshots(WebDriver driver, String screenshotName) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        Date currntDate = new Date();
        String screenshot = screenshotName + currntDate.toString().replace(" ", "-").replace(":", "-");
        try {
            FileHandler.copy(takesScreenshot.getScreenshotAs(OutputType.FILE), new File(System.getProperty("user.dir") + "/src/test/resources/screenshots/" + screenshot + ".png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static float removeFirstLetterAndReturnFloat(String string) {
        if (string == null || string.isEmpty()) {
            return Float.NaN;
        }
        try {
            return Float.parseFloat(string.substring(1));
        } catch (NumberFormatException e) {
            return Float.NaN;
        }
    }

    //read data from json file
    public static String getdata(String jsonpath, String filed)  {
        try {
        //define object of json
        JSONParser parser = new JSONParser();
        //define object of file reader
        FileReader reader = new FileReader(jsonpath);
        Object object = parser.parse(reader);

        JsonObject jsonObject=(JsonObject) object;
        return jsonObject.get(filed).toString();}

        catch (Exception e){
            e.printStackTrace();
        }
        return "";
    }

    // TODO: Read Data From Excel Sheet
    public static String getExcelData(int RowNum, int ColNum, String SheetName) {
        XSSFWorkbook workBook;
        XSSFSheet sheet;
        String projectPath = System.getProperty("user.dir");
        String cellData = null;
        try {
            workBook = new XSSFWorkbook(projectPath + "/src/test/resources/data/logindata.xlsx");
            sheet = workBook.getSheet(SheetName);
            cellData = sheet.getRow(RowNum).getCell(ColNum).getStringCellValue();

        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            e.printStackTrace();
        }
        return cellData;
    }
}