package com.example.demo.service.core4;

import com.example.demo.model.dto.core4.Emp;
import com.example.demo.model.dto.core4.EmpData;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

@Service
public class ServiceJV4 {
    public List<EmpData> readEXcel(MultipartFile f){
        InputStream file;
        XSSFWorkbook workbook;
        try {
            file = f.getInputStream();
            workbook = new XSSFWorkbook(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        XSSFSheet sheet = workbook.getSheetAt(0);

        // Create a list to contain every type of work
        LinkedList<String> t_work = new LinkedList<>();
        // Index to save all type of work
        int start_save_index = 3;
        // Read all type of work
        Row rx = sheet.getRow(5);
        Cell cx = rx.getCell(start_save_index);
        while (cx.getCellType() != CellType.BLANK) {
            if (!cx.getStringCellValue().toString().equals("$")) {
                t_work.add(cx.getStringCellValue().toString());
            }
            cx = rx.getCell(start_save_index + 1);
            start_save_index += 1;
        }

        //Create a list to save every day data
        LinkedList<LinkedList<HashMap<String, Double>>> day_list = new LinkedList<>();
        //Create a linked list to save month result
        LinkedList<HashMap<String, Double>> m_list = new LinkedList<>();
        //Save every day's data
        for (Row row : sheet) {
            int day_index = start_save_index + 1;
            //Create a hashmap to save day data
            HashMap<String, Double> day_dt = new HashMap<>();
            if (row.getRowNum() < 6) {
                continue;
            }
            if (row.getCell(0).getCellType() == CellType.BLANK) {
                break;
            }

            for (Cell cell : row) {
                switch (cell.getCellType()) {
                    case STRING:
                        break;
                    case NUMERIC:
                        Row rt = sheet.getRow(5);
                        Cell ct = rt.getCell(cell.getColumnIndex());
                        Cell day_check = sheet.getRow(3).getCell(day_index);
                        double data = cell.getNumericCellValue();
                        if (cell.getColumnIndex() > start_save_index) {
                            if (day_check.getCellType() != CellType.BLANK) {
                                if (!day_dt.isEmpty()) {
                                    m_list.add(new HashMap<>(day_dt));
                                    day_dt.clear();
                                }
                                day_index += 1;
                                day_dt.put(ct.getStringCellValue().toString(), data);

                            } else {
                                day_dt.put(ct.getStringCellValue().toString(), data);
                                day_index += 1;
                            }
                        }
                        break;
                    case FORMULA:
                        break;
                    case BLANK:
                        if (cell.getColumnIndex() > start_save_index) {
                            Row r_check = sheet.getRow(3);
                            Cell c_check = r_check.getCell(day_index);
                            if (c_check.getCellType() != CellType.BLANK) {
                                if (!day_dt.isEmpty()) {
                                    m_list.add(new HashMap<>(day_dt));
                                    day_dt.clear();
                                    Row r_null = sheet.getRow(5);
                                    Cell c_null = r_null.getCell(day_index);
                                    day_dt.put(c_null.getStringCellValue().toString(), 0.0);
                                } else {
                                    Row r_null = sheet.getRow(5);
                                    Cell c_null = r_null.getCell(day_index);
                                    day_dt.put(c_null.getStringCellValue().toString(), 0.0);
                                }
                            } else {
                                Row r_null = sheet.getRow(5);
                                Cell c_null = r_null.getCell(day_index);
                                day_dt.put(c_null.getStringCellValue().toString(), 0.0);
                            }
                            day_index += 1;
                        }
                        break;
                }
            }
            day_list.add(new LinkedList<>(m_list));
            m_list.clear();
        }

        // Create a list to save all employee data
        LinkedList<Emp> emp_list = new LinkedList<>();
        for (Row row : sheet) {
            if (row.getRowNum() < 6) {
                continue;
            }
            if (row.getCell(0).getCellType() == CellType.BLANK) {
                break;
            }
            Emp emp = new Emp();
            for (Cell cell : row) {
                switch (cell.getCellType()) {
                    case STRING:
                        if (cell.getColumnIndex() == 1) {
                            emp.setID(cell.getRichStringCellValue().getString());
                        } else if (cell.getColumnIndex() == 2) {
                            emp.setNAME(cell.getRichStringCellValue().getString());
                        } else {
                            break;
                        }
                        break;
                    case BLANK:
                        break;
                }
                if (cell.getColumnIndex() >= 3) {
                    break;
                }
            }
            emp_list.add(emp);
        }

        // Create list to save salary table
        LinkedList<HashMap<String, Double>> salary_table = new LinkedList<>();

        for (Row row : sheet) {
            if (row.getRowNum() < 6) {
                continue;
            }
            if (row.getCell(0).getCellType() == CellType.BLANK) {
                break;
            }
            HashMap<String, Double> m_salary = new HashMap<>();
            for (Cell cell : row) {
                switch (cell.getCellType()) {
                    case STRING:
                        break;
                    case BLANK:
                        Row r_salary_b = sheet.getRow(5);
                        Cell c_salary_b = r_salary_b.getCell(cell.getColumnIndex());
                        if (cell.getColumnIndex() < 3) {
                            break;
                        }
                        if (c_salary_b.getCellType() != CellType.BLANK) {
                            if (c_salary_b.getStringCellValue().toString().equals("$")) {
                                int reverse_index = 1;
                                while (true) {
                                    if (cell.getColumnIndex() < 1) {
                                        break;
                                    }
                                    Row rt = sheet.getRow(5);
                                    Cell ct = rt.getCell(cell.getColumnIndex() - reverse_index);
                                    if (ct.getStringCellValue().toString().equals("$")) {
                                        break;
                                    } else if (ct.getCellType() == CellType.BLANK) {
                                        break;
                                    }
                                    if (cell.getColumnIndex() < start_save_index) {
                                        m_salary.put(ct.getStringCellValue().toString(), cell.getNumericCellValue());
                                        reverse_index += 1;
                                    }
                                }

                            } else {
                                break;
                            }
                        } else if (c_salary_b.getCellType() == CellType.BLANK) {
                            if (c_salary_b.getStringCellValue().toString().equals("$")) {
                                int reverse_index = 1;
                                while (true) {
                                    Row rt = sheet.getRow(5);
                                    Cell ct = rt.getCell(cell.getColumnIndex() - reverse_index);
                                    if (ct.getStringCellValue().toString().equals("$")) {
                                        break;
                                    }
                                    if (cell.getColumnIndex() < start_save_index) {
                                        m_salary.put(ct.getStringCellValue().toString(), cell.getNumericCellValue());
                                        reverse_index += 1;
                                    }
                                }

                            } else {
                                break;
                            }
                        }
                        break;
                    case NUMERIC, FORMULA:
                        Row r_salary = sheet.getRow(5);
                        Cell c_salary = r_salary.getCell(cell.getColumnIndex());
                        if (cell.getColumnIndex() < 3) {
                            break;
                        }
                        if (c_salary.getCellType() != CellType.BLANK) {
                            if (c_salary.getStringCellValue().toString().equals("$")) {
                                int reverse_index = 1;
                                while (true) {
                                    Row rt = sheet.getRow(5);
                                    Cell ct = rt.getCell(cell.getColumnIndex() - reverse_index);
                                    if (ct.getStringCellValue().toString().equals("$")) {
                                        break;
                                    }
                                    if (cell.getColumnIndex() < start_save_index) {
                                        m_salary.put(ct.getStringCellValue().toString(), cell.getNumericCellValue());
                                        reverse_index += 1;
                                    }
                                }

                            } else {
                                break;
                            }
                        } else if (c_salary.getCellType() == CellType.BLANK) {
                            if (c_salary.getStringCellValue().toString().equals("$")) {
                                int reverse_index = 1;
                                while (true) {
                                    Row rt = sheet.getRow(5);
                                    Cell ct = rt.getCell(cell.getColumnIndex() - reverse_index);
                                    if (ct.getStringCellValue().toString().equals("$")) {
                                        break;
                                    }
                                    if (cell.getColumnIndex() < start_save_index) {
                                        m_salary.put(ct.getStringCellValue().toString(), cell.getNumericCellValue());
                                        reverse_index += 1;
                                    }
                                }

                            } else {
                                break;
                            }
                        }
                        break;
                }
                if (cell.getColumnIndex() >= start_save_index) {
                    break;
                }
            }
            salary_table.add(new HashMap<>(m_salary));
            m_salary.clear();
        }

        // Total salary from file
        LinkedList<Double> file_salary = new LinkedList<>();
        for (Row r : sheet) {
            if (r.getRowNum() < 6) {
                continue;
            }
            if (r.getCell(0).getCellType() == CellType.BLANK) {
                break;
            }
            for (Cell c : r) {
                if (c.getColumnIndex() != start_save_index) {
                    continue;
                }
                file_salary.add(c.getNumericCellValue());
            }
        }
        return saveEmp(emp_list,salary_table,day_list,file_salary);
    }

    public static List<EmpData> saveEmp(LinkedList<Emp> emp, LinkedList<HashMap<String, Double>> salary, LinkedList<LinkedList<HashMap<String, Double>>> month, LinkedList<Double> file_salary) {
        int total_index = emp.size();
        List<EmpData> list = new ArrayList<>();
        for (int i = 0; i < total_index; i++) {
            List<HashMap<String, HashMap<String, Double>>> day_data = new ArrayList<>();
            EmpData eData = new EmpData();
            double m_salary = 0;
            System.out.println("= = = = = = = = = = = = = = = = = = =");
            System.out.println("\tID            : " + emp.get(i).getID());
            System.out.println("\tEmployee name : " + emp.get(i).getNAME());
            // Get emp data first
            eData.setEMP(emp.get(i));

            LinkedList<HashMap<String, Double>> e_month = month.get(i);
            HashMap<String, Double> e_salary = salary.get(i);
            double month_salary = 0;
            HashMap<String, HashMap<String, Double>> dayDataDetail = new HashMap<>();
            for (int j = 0; j < e_month.size(); j++) {
                HashMap<String, Double> temp = new HashMap<>();
                HashMap<String, Double> e_day = e_month.get(j);
                dayDataDetail.clear();
                double total_day_work_hour = 0;
                for (double data : e_day.values()) {
                    total_day_work_hour += data;
                }
                if (total_day_work_hour == 0) {
                    continue;
                }
                System.out.print("\tDay " + String.format("%-2s", j + 1) + " [ ");
                String dayName = "Day " + (j + 1);
                double day_salary = 0;
                for (String work_type : e_day.keySet()) {
                    if (e_day.get(work_type) > 0) {
                        day_salary += e_salary.get(work_type) * e_day.get(work_type);
                        System.out.print(work_type + " : " + e_day.get(work_type) + " | ");
                        temp.put(work_type,e_day.get(work_type));
                    }
                }
                System.out.print("Total work hour: " + total_day_work_hour);
                temp.put("Total work hour", total_day_work_hour);
                System.out.println(" | Day salary: " + String.format("%.0f", day_salary) + " ]");
                temp.put("Day salary",day_salary);
                month_salary += day_salary;
                dayDataDetail.put(dayName, temp);
                day_data.add(new HashMap<>(dayDataDetail));
            }
            m_salary = month_salary;
            eData.setDAY_SALARY(day_data);
            eData.setMONTH_SALARY(m_salary);
            list.add(eData);
        }
        return list;
    }

}
