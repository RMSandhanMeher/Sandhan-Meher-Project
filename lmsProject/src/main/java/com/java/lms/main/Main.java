package com.java.lms.main;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.java.lms.bal.LeaveBal;
import com.java.lms.dao.LeaveDaoImpl;
import com.java.lms.model.Leave;
import com.java.lms.model.LeaveStatus;
import com.java.lms.model.LeaveType;

public class Main {
    static LeaveBal leaveBal;
    static Leave leave;
    static Scanner scanner;

    static {
        leaveBal = new LeaveBal();
        scanner=new Scanner(System.in);
    }

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\nLeave Management System Options:");
            System.out.println("1. Apply for Leave");
            System.out.println("2. View All Leave Taken by Employee");
            System.out.println("3. DIsplay Managers Subordinates pending leaves history");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            try {
                switch (choice) {
                    case 1:
                        applyLeave();
                        break;
                    case 2:
                        viewAllLeaveTaken();
                        break;
                    case 3:
                        showRequestedLeaves();
                        System.out.println(" wanna update leave status (yes/no) : ");
                        if(scanner.next().equals("yes")) {
                        	System.out.println("Enter Leave id from above : ");
                        	int leaveId=scanner.nextInt();
                        	System.out.println("Enter Leave status (APPROVED,DENIED) : ");
                        	LeaveStatus leaveStatus=LeaveStatus.valueOf(scanner.next().toUpperCase());
                        	scanner.nextLine();
                        	System.out.println("Enter Leave comment : ");
                        	String managerComment=scanner.nextLine();
                        	System.out.println(new LeaveDaoImpl().changeLeaveStatusDaoImple(leaveId, leaveStatus,managerComment));
                        }
                        break;
                   
                    case 0:
                        System.out.println("Exiting Leave Management System. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        } while (choice != 0);

        scanner.close();
    }

    public static void applyLeave() throws ClassNotFoundException, SQLException {
        leave = new Leave();

        System.out.print("Enter Employee ID: ");
        leave.setEmpId(scanner.nextInt());
        scanner.nextLine();

        System.out.print("Enter Start Date (yyyy-mm-dd): ");
        leave.setStartDate(Date.valueOf(scanner.nextLine()));

        System.out.print("Enter End Date (yyyy-mm-dd): ");
        leave.setEndDate(Date.valueOf(scanner.nextLine()));

        System.out.print("Enter Leave Reason: ");
        leave.setLeaveReason(scanner.nextLine());

        System.out.print("Enter Leave Type (EL/SL/ML): ");
        String type = scanner.nextLine().toUpperCase();
        leave.setLeaveType(LeaveType.valueOf(type));

        leave.setLeaveStatus(LeaveStatus.PENDING);

        String result = leaveBal.applyALeaveBal(leave);
        System.out.println("Leave Application Result: " + result);
    }

    public static void viewAllLeaveTaken() throws ClassNotFoundException, SQLException {
        System.out.print("Enter Employee ID to view leave history: ");
        int empId = scanner.nextInt();
        scanner.nextLine();

        List<Leave> leaveHistory = leaveBal.allLeaveTakenByEmpBal(empId);

        if (leaveHistory.isEmpty()) {
            System.out.println("No leave history found for Employee ID: " + empId);
        } else {
            System.out.println("\nLeave History for Employee ID: " + empId);
            for (Leave leave : leaveHistory) {
                System.out.println("Leave ID: " + leave.getLeaveId() +
                                   ", Start Date: " + leave.getStartDate() +
                                   ", End Date: " + leave.getEndDate() +
                                   ", Reason: " + leave.getLeaveReason() +
                                   ", Type: " + leave.getLeaveType() +
                                   ", Status: " + leave.getLeaveStatus());
            }
        }
    }

    public static void showRequestedLeaves() throws ClassNotFoundException, SQLException {
        System.out.print("Enter your Manager ID to view pending leave requests: ");
        int managerId = scanner.nextInt();
        scanner.nextLine();

        List<Leave> pendingLeaves = leaveBal.showRequestedLeaves(managerId);

        if (pendingLeaves.isEmpty()) {
            System.out.println("No pending leave requests found for Manager ID: " + managerId);
        } else {
            System.out.println("\nPending Leave Requests for Manager ID: " + managerId);
            for (Leave leave : pendingLeaves) {
                System.out.println("Leave ID: " + leave.getLeaveId() +
                                   ", Employee ID: " + leave.getEmpId() +
                                   ", Start Date: " + leave.getStartDate() +
                                   ", End Date: " + leave.getEndDate() +
                                   ", Reason: " + leave.getLeaveReason() +
                                   ", Type: " + leave.getLeaveType() +
                                   ", Status: " + leave.getLeaveStatus());
            }
        }
    }
}