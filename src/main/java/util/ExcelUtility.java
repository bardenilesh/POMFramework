package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ExcelUtility {
  
  
  public static void main(String[] args) throws IOException{

        String fileName = "W:\\data1.xls";
        String cellContent = "username";
//        set(cellContent, "testmeplease");
//        System.out.println("nValue is "+set(cellContent, "testmeplease"));
//        int rownr=0, colnr = 2; 
//        String nValue="";
//        FileInputStream input = new FileInputStream(fileName);
//
//        HSSFWorkbook wb = new HSSFWorkbook(input);
//        HSSFSheet sheet = wb.getSheetAt(0);
//
//        nValue = findValue(sheet, cellContent);
//        cellContent = "surname";
//        nValue = findValue(sheet, cellContent);
//        cellContent = "anything";
//        nValue = findValue(sheet, cellContent);
       

        //output(sheet, rownr, colnr);

//        finish();
//    System.out.println(get("suspended"));

    }
//  public static String get(String content)
  public String get(String content)
  {
    String nValue = "";
    
    try {
      FileInputStream input;
      if(Global.dataFile ==null)
      {
        input = new FileInputStream(Global.workDir+"\\TestData\\licensing.xls");
      }
      else if((Global.dataFile.equals("")))
      {
        input = new FileInputStream(Global.workDir+"\\TestData\\licensing.xls");
      }
      else
      {
        input = new FileInputStream(Global.dataFile);
      }
      HSSFWorkbook wb = new HSSFWorkbook(input);
      HSSFSheet sheet = wb.getSheetAt(0);
      nValue = findValue(sheet, content);
      return nValue;
    } catch (Exception e) {
      // TODO Auto-generated catch block
//      e.printStackTrace();
      return nValue="";
    } 
  }
  
  public String set(String columnName, String content)
  {
    String nValue = "";
    Global glb = new Global(); 
    try {
      FileInputStream input;
      if(!Global.dataFile.equals(""))
      {
        input = new FileInputStream(Global.dataFile);
      }
      else
      {
        input = new FileInputStream(new File(Global.workDir+"\\TestData\\data.xls"));
      }
      HSSFWorkbook wb = new HSSFWorkbook(input);
      HSSFSheet sheet = wb.getSheetAt(0);
      setValue(sheet, columnName, content);
      input.close();
      FileOutputStream output_file;
      if(!Global.dataFile.equalsIgnoreCase(""))
      {
        output_file = new FileOutputStream(Global.dataFile);
      }
      else{
        output_file =new FileOutputStream(new File(Global.workDir+"\\TestData\\data.xls"));
      }
      //write changes
      wb.write(output_file);
     //close the stream
     output_file.close();
      return content;
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
      
    } 
    return content;
  }
//    private static void output(HSSFSheet sheet, int rownr, int colnr) {
//        /*
//         * This method displays the total value of the month
//         */
//
//        HSSFRow row = sheet.getRow(rownr);
//        HSSFCell cell = row.getCell(colnr);
//
//                System.out.println("Your total is: " + cell);           
//    }

    private static String findValue(HSSFSheet sheet, String cellContent){
        /*
         *  This is the method to find the row number
         */

        int rowNum = 0; 
        int colNum = 0; 
        String value="";
        for(Row row : sheet) {
            for(Cell cell : row) {
//              boolean bul =cell.getStringCellValue().trim().equalsIgnoreCase(cellContent.trim());
//              System.out.println(bul);

                    if(cell.getStringCellValue().trim().equalsIgnoreCase(cellContent.trim())){

                            rowNum = row.getRowNum();
                            colNum = cell.getColumnIndex();
                            HSSFRow nRow= sheet.getRow(1);
                            HSSFCell nCell = nRow.getCell(colNum);
                            if(nCell.getCellType() == HSSFCell.CELL_TYPE_STRING)
                            {
                              value = (nCell.getStringCellValue() == null) ? "" : nCell.getStringCellValue();
                            }
                            else if(nCell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC)
                            {
                              value = (String) (((Double)nCell.getNumericCellValue() == null) ? "" : nCell.getNumericCellValue());
                            }
                            else if(nCell.getCellType() == HSSFCell.CELL_TYPE_BLANK)
                            {
                              value = "";
                            }  
                            break;
                    }
            }
            break;
        }               
        return value;  
    }
    private static String setValue(HSSFSheet sheet, String cellContent, String value){
      /*
       *  This is the method to find the row number
       */

      int rowNum = 0; 
      int colNum = 0; 
      for(Row row : sheet) {
          for(Cell cell : row) {
//            boolean bul =cell.getStringCellValue().trim().equalsIgnoreCase(cellContent.trim());
//            System.out.println(bul);

                  if(cell.getStringCellValue().trim().equalsIgnoreCase(cellContent.trim())){

                          rowNum = row.getRowNum();
                          colNum = cell.getColumnIndex();
                          HSSFRow nRow= sheet.getRow(1);
                          HSSFCell nCell = nRow.getCell(colNum);
                          if(nCell.getCellType() == HSSFCell.CELL_TYPE_STRING)
                          {
                            nCell.setCellValue(value);
//                            value = (nCell.getStringCellValue() == null) ? "" : nCell.getStringCellValue();
                          }
                          else if(nCell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC)
                          {
//                            value = (String) (((Double)nCell.getNumericCellValue() == null) ? "" : nCell.getNumericCellValue());
                          }
                          else if(nCell.getCellType() == HSSFCell.CELL_TYPE_BLANK)
                          {
//                            value = "";
                          }  
                          break;
                  }
          }
          break;
      }               
      return value;  
  }
    private static String findValueTemp(HSSFSheet sheet, String cellContent){
      /*
       *  This is the method to find the row number
       */

      int colNum = 0; 
      String value="";
      for(Row row : sheet) {
          for(Cell cell : row) {
//            boolean bul =cell.getStringCellValue().trim().equalsIgnoreCase(cellContent.trim());
//            System.out.println(bul);

                  if(cell.getStringCellValue().trim().equalsIgnoreCase(cellContent.trim())){


                          colNum = cell.getColumnIndex();
                          HSSFRow nRow= sheet.getRow(1);
                          HSSFCell nCell = nRow.getCell(colNum);
                          if(nCell.getCellType() == HSSFCell.CELL_TYPE_STRING)
                          {
                            value = (nCell.getStringCellValue() == null) ? "" : nCell.getStringCellValue();
                          }
                          else if(nCell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC)
                          {
                            value = (String) (((Double)nCell.getNumericCellValue() == null) ? "" : nCell.getNumericCellValue());
                          }
                          else if(nCell.getCellType() == HSSFCell.CELL_TYPE_BLANK)
                          {
                            value = "";
                          }
//                          try {
//                            
//                            value=nCell.getStringCellValue();
//            } catch (NullPointerException e) {
//              // TODO Auto-generated catch block
//              value="";
//              e.printStackTrace();
//            }
//                          if(nCell.getStringCellValue()!=null)
//                          {
//                            System.out.println(value);
//                          }
                          
                          
                  }
                  
          }
          break;
      }               
      return value;  
  }
 
    private static void finish() {

        System.exit(0);
    }
 
}

