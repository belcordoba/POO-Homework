package ui;

import Models.Customer;
import Models.Employee;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Home extends JFrame {
    private JPanel homePanel;
    private JTable employeesTbl;
    private JTextField firstNameEmpTxt;
    private JTextField lastNameEmpTxt;
    private JTextField salaryTxt;
    private JButton addEmployeeBtn;
    private JTabbedPane tabbedPane1;
    private JTextField firstNameCusTxt;
    private JTextField lastNameCusTxt;
    private JTextField accountNumberTxt;
    private JTable customersTbl;
    private JButton addCustomerBtn;
    private ArrayList<Employee> employees = new ArrayList<Employee>();
    private ArrayList<Customer> customers = new ArrayList<Customer>();

    public Home() {
        loadEmployeesTable();
        loadCustomersTable();
        setContentPane(homePanel);
        setLocationRelativeTo(null);
        setSize(800, 600);
        setDefaultCloseOperation((JFrame.EXIT_ON_CLOSE));
        setTitle("Bank POO");
        setVisible(true);
        addEmployeeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                employees.add(new Employee(
                        firstNameEmpTxt.getText(),
                        lastNameEmpTxt.getText(),
                        Integer.parseInt(salaryTxt.getText())
                ));
                loadEmployeesTable();
                firstNameEmpTxt.setText("");
                lastNameEmpTxt.setText("");
                salaryTxt.setText("");
            }
        });
        addCustomerBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                customers.add(new Customer(
                        firstNameCusTxt.getText(),
                        lastNameCusTxt.getText(),
                        Integer.parseInt(accountNumberTxt.getText())
                ));
                loadCustomersTable();
                firstNameCusTxt.setText("");
                lastNameCusTxt.setText("");
                accountNumberTxt.setText("");
            }
        });
    }

    public void loadEmployeesTable() {
        String[] columns = { "ID", "First Name", "Last Name", "Salary"};
        Object[][] data = new Object[(employees.size())][columns.length];
        for (int i = 0; i < employees.size(); i++){
            data [i][0] = employees.get(i).getId();
            data [i][1] = employees.get(i).getFirstName();
            data [i][2] = employees.get(i).getLastName();
            data [i][3] = employees.get(i).getSalary();
        }
        employeesTbl.setModel(
                new DefaultTableModel(
                        data,
                        columns
                )
        );
    }

    public void loadCustomersTable() {
        String[] columns = { "ID", "First Name", "Last Name", "Account Number"};
        Object[][] data = new Object[(customers.size())][columns.length];
        for (int i = 0; i < customers.size(); i++) {
            data[i][0] = customers.get(i).getId();
            data[i][1] = customers.get(i).getFirstName();
            data[i][2] = customers.get(i).getLastName();
            data[i][3] = customers.get(i).getAccountNumber();
        }
        customersTbl.setModel(
                new DefaultTableModel(
                        data,
                        columns
                )
        );
    }
}