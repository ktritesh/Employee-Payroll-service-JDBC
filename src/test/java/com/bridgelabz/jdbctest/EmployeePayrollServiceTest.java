/**
 * UC2 : Testcases to retrieve data from Database.
 *
 * @author : Ritesh KT
 * @since : 18.07.2021
 */

package com.bridgelabz.jdbctest;

import com.bridgelabz.jdbcmain.EmployeePayrollData;
import com.bridgelabz.jdbcmain.EmployeePayrollService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class EmployeePayrollServiceTest {

    @Test
    public void givenEmployeePayrollInDB_WhenRetrieved_ShouldMatchEmployeeCount(){
        EmployeePayrollService employeePayrollService = new EmployeePayrollService();
        List<EmployeePayrollData> employeePayrollData = employeePayrollService.readEmployeePayrollData(
                EmployeePayrollService.IOService.DB_IO);
        Assertions.assertEquals(3, employeePayrollData.size());
    }
}
