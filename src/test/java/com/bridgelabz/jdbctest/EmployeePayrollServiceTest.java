/**
 * UC2 : Testcases to retrieve data from Database.
 *
 * @author : Ritesh KT
 * @since : 18.07.2021
 */

package com.bridgelabz.jdbctest;

import com.bridgelabz.jdbcmain.EmployeePayrollData;
import com.bridgelabz.jdbcmain.EmployeePayrollException;
import com.bridgelabz.jdbcmain.EmployeePayrollService;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.List;

public class EmployeePayrollServiceTest {
    EmployeePayrollService employeePayrollService = null;

    @Before
    public void setUp() throws Exception {
        employeePayrollService = new EmployeePayrollService();
    }

    @Test
    public void givenEmployeePayrollInDB_WhenRetrieved_ShouldMatchEmployeeCount() throws EmployeePayrollException {
        List<EmployeePayrollData> employeePayrollData = employeePayrollService.readEmployeePayrollData(
                EmployeePayrollService.IOService.DB_IO);
        Assertions.assertEquals(3, employeePayrollData.size());
    }

    @Test
    void givenNewSalaryForEmployee_WhenUpdated_ShouldSyncWithDB() throws EmployeePayrollException {
        List<EmployeePayrollData> employeePayrollData = employeePayrollService.readEmployeePayrollData(
                EmployeePayrollService.IOService.DB_IO);
        employeePayrollService.updateEmployeeSalary("Terisa", 300000.00);
        boolean result = employeePayrollService.checkEmployeePayrollInSyncWithDB("Terisa");
        Assertions.assertTrue(result);
    }
}
