package MANAGEMENT;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {

    private static final String FILE_PATH = "C:\\Users\\praga\\Downloads\\Book4.xlsx";

    public void add(String food, String email) throws IOException {
        int cost = 0;

        // Food price mapping
        switch (food) {
            case "Chicken Briyani": cost = 120; break;
            case "Egg Gravy": cost = 100; break;
            case "Chicken Gravy": cost = 100; break;
            case "Cauliflower": cost = 40; break;
            case "Chicken 65": cost = 90; break;
            case "Bread Omelet": cost = 30; break;
            case "Boiled Egg": cost = 20; break;
            default: cost = 0; break;
        }

        File file = new File(FILE_PATH);

        // ✅ Ensure parent directories exist
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }

        Workbook workbook;
        Sheet sheet;

        if (file.exists()) {
            try (FileInputStream fis = new FileInputStream(file)) {
                workbook = new XSSFWorkbook(fis);
            }
            sheet = workbook.getSheetAt(0);
        } else {
            // Create new workbook and header
            workbook = new XSSFWorkbook();
            sheet = workbook.createSheet("Order Sheet");

            Row headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("Email");
            headerRow.createCell(1).setCellValue("Total Cost");
        }

        boolean emailExists = false;
        int lastRowNum = sheet.getLastRowNum();

        // ✅ Update cost if email already exists
        for (int i = 1; i <= lastRowNum; i++) {
            Row row = sheet.getRow(i);
            if (row != null) {
                Cell emailCell = row.getCell(0);

                if (emailCell != null && emailCell.getStringCellValue().equalsIgnoreCase(email)) {
                    Cell costCell = row.getCell(1);

                    double existingCost = costCell != null ? costCell.getNumericCellValue() : 0;
                    if (costCell == null) {
                        costCell = row.createCell(1);
                    }
                    costCell.setCellValue(existingCost + cost);
                    emailExists = true;
                    break;
                }
            }
        }

        // ✅ Add new email if not found
        if (!emailExists) {
            Row newRow = sheet.createRow(lastRowNum + 1);
            newRow.createCell(0).setCellValue(email);
            newRow.createCell(1).setCellValue(cost);
        }

        // ✅ Save changes (creates file if not present)
        try (FileOutputStream fos = new FileOutputStream(file)) {
            workbook.write(fos);
        } finally {
            workbook.close();
        }
    }
}
