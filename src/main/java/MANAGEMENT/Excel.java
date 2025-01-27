package MANAGEMENT;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {

    private static final String FILE_PATH = "C:\\Users\\praga\\OneDrive\\Documents\\New folder\\Book2.xlsx";

    public void add(String food, String email) throws IOException {
        int cost = 0;

       
        System.out.println(food);
        if (food.equals("Chicken Briyani")) cost = 120;
        else if (food.equals("Egg Gravy")) cost = 100;
        else if (food.equals("Chicken Gravy")) cost = 100;
        else if (food.equals("Cauliflower")) cost = 40;
        else if (food.equals("Chicken 65")) cost = 90;
        else if (food.equals("Bread Omelet")) cost = 30;
        else if (food.equals("Boiled Egg")) cost = 20;

        File file = new File(FILE_PATH);
        Workbook workbook;
        Sheet sheet;

       
        if (file.exists()) {
            try (FileInputStream fis = new FileInputStream(file)) {
                workbook = new XSSFWorkbook(fis);
            }
            sheet = workbook.getSheetAt(0);
        } else {
            workbook = new XSSFWorkbook();
            sheet = workbook.createSheet("Order Sheet");

          
            Row headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("Email");
            headerRow.createCell(1).setCellValue("Total Cost");
        }

        boolean emailExists = false;
        int lastRowNum = sheet.getLastRowNum();

 
        for (int i = 1; i <= lastRowNum; i++) {
            Row row = sheet.getRow(i);
            if (row != null) {
                Cell emailCell = row.getCell(0);

            
                if (emailCell != null && emailCell.getStringCellValue().equalsIgnoreCase(email)) {
                    Cell costCell = row.getCell(1);

                 
                    double existingCost = costCell != null ? costCell.getNumericCellValue() : 0;
                    costCell.setCellValue(existingCost + cost); 
                    emailExists = true;
                    break;
                }
            }
        }

       
        if (!emailExists) {
            Row newRow = sheet.createRow(lastRowNum + 1);
            newRow.createCell(0).setCellValue(email);
            newRow.createCell(1).setCellValue(cost);
        }

      
        try (FileOutputStream fos = new FileOutputStream(file)) {
            workbook.write(fos);
        } finally {
            workbook.close();
        }
       
    }

  
}
