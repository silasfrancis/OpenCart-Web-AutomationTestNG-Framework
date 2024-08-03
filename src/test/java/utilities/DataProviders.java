package utilities;

import org.testng.annotations.DataProvider;
import utilities.XLUtility;

import java.io.IOException;

public class DataProviders {

    @DataProvider(name = "prices")
    public String[][] getAllData() throws IOException {
        {
            String path = System.getProperty("user.dir") + "//testData//Prices.xlsx";
            XLUtility xl = new XLUtility(path);

            int rownum = xl.getRowCount("Prices");
            int colcount = xl.getCellCount("Prices", 1);

            String prices[][] = new String[rownum][colcount];

            for (int i = 1; i <= rownum; i++) {
                for (int j = 0; j < colcount; j++) {
                    prices[i - 1][j] = xl.getCellData("Prices", i, j);
                }
            }

            return prices;
        }
    }
}