package com.qajdbc.main;

import java.sql.SQLException;
import java.util.Scanner;

import com.qajdbc.main.util.DBConfig;

public class Runner {
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		DBConfig.getConnection();

		try {
			DBConnection dbc = new DBConnection();

			int selection = 0;

			boolean flag = true;

			do {
				System.out.println("main menu \nselect an option \n1 to add a customer \n2 read a specific customer "
						+ "\n3 to read all customers \n4 to update a customer \n5 to delete a customer \n0 to exit and close ");
				selection = Integer.parseInt(sc.nextLine());
				System.out.println("");
				switch (selection) {
				case 1:
					int id = 0;
					System.out.println("enter a customer first name");
					String fName = sc.nextLine();
					System.out.println("enter customer last name");
					String lName = sc.nextLine();
					DBConnection.create(id, fName, lName);
					System.out.println("customer succesfully created");
					break;
				case 2:
					System.out.println("please enter customer id to view info");
					int id1 = sc.nextInt();
					dbc.readSingle(id1);
					break;

				case 3:
					DBConnection.read();
					break;

				case 4:
					System.out.println("enter the customer id for customer being updated");
					int id2 = sc.nextInt();
					sc.nextLine();
					System.out.println("enter the new first name for customer");
					String fName1 = sc.nextLine();
					System.out.println("enter the new last name for customer");
					String lName1 = sc.nextLine();

					DBConnection.update(id2, fName1, lName1);
					System.out.println("customer succesfully updated");
					break;
				case 5:
					System.out.println("enter the customer id for customer being deleted");
					int id3 = sc.nextInt();
					sc.nextLine();
					DBConnection.delete(id3);
					System.out.println("customer succesfully deleted");
					break;
				case 0:
					System.out.println("Exiting. GOODBYE!");
					flag = false;
					break;

				default:
					System.out.println("invalid selection");
					break;

				}
			} while (flag = true);
			sc.close();
			System.out.println("scanner closed succefully");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
