/**
 * UC2 : Retrieve data from Database
 *
 * @author : Ritesh KT
 * @since : 18.07.2021
 */
package com.bridgelabz.jdbcmain;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeePayrollService {

    public enum IOService {CONSOLE_IO, FILE_IO, DB_IO, REST_IO}

    private List<EmployeePayrollData> employeePayrollList;

    public EmployeePayrollService() {

    }

    EmployeePayrollDBService employeePayrollDBService = new EmployeePayrollDBService();

    public List<EmployeePayrollData> readEmployeePayrollData(IOService ioService) {
        if(ioService.equals(IOService.DB_IO))
            this.employeePayrollList = employeePayrollDBService.readData();
        return this.employeePayrollList;
    }

}
