//package
package com.company;

import java.io.*;

//interface
interface StudentInterface {

    void addRecords() throws Exception;

    void deleteRecords() throws Exception;

    void displayRecords() throws Exception;
}

class Records {
    String Name;
    String ClassName;
    String FName;
    String MName;
    String DOB;
    int Age;
    long PhoneNo;
    String Address;

    Records() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter Your Name:");
        this.Name = br.readLine();
        System.out.println("Enter Your Class Name:");
        this.ClassName = br.readLine();
        System.out.println("Enter Your Father's Name:");
        this.FName = br.readLine();
        System.out.println("Enter Your Mother's Name:");
        this.MName = br.readLine();
        System.out.println("Enter Your DOB[DD/MM/YYYY]:");
        this.DOB = br.readLine();
        System.out.println("Enter Your Age:");
        this.Age = Integer.parseInt(br.readLine());
        System.out.println("Enter Your Phone Number:");
        this.PhoneNo = Long.parseLong(br.readLine());
        System.out.println("Enter Your Address:");
        this.Address = br.readLine();
        System.out.println("Input Completed");
    }
}

//class
//inheritance
class Student implements StudentInterface {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    //overriding //polymorphism
    @Override
    final public void addRecords() throws Exception {
        //exceptional handling
        try {
            //file handling
            File f = new File("F:student.txt");
            FileWriter fw = new FileWriter(f);
            if (f.exists()) {
                System.out.println("File Existed");
                Records r = new Records();
                fw.append("\n" + r.Name + "\n" + r.ClassName + "\n" + r.FName + "\n" + r.MName + "\n" + r.DOB + "\n" + r.Age + "\n" + r.PhoneNo + "\n" + r.Address + "\n");
                fw.close();
            } else {
                System.err.println("File Error");
            }

        } catch (FileNotFoundException e) {
            System.err.println("File Error");

        } finally {
            this.menu();
        }

    }

    @Override
    final public void deleteRecords() throws Exception {
        new FileWriter("F:student.txt");
        System.out.println("All Files Cleared");
        this.menu();
    }

    final public void displayRecords() throws Exception {
        try {
            BufferedReader br = new BufferedReader(new FileReader("F:student.txt"));
            String s;
            if (br.readLine() == null) {
                System.out.println("File is Empty");
            }
            System.out.println("\n**************************");
            while ((s = br.readLine()) != null) {
                System.out.println(s);
            }
            System.out.println("**************************\n");
        } catch (Exception e) {
            System.out.println("File Error");
        } finally {
            menu();
        }

    }

    public void menu() throws Exception {
        System.out.println("Student Management");
        System.out.println("""
                1)Add Records
                2)Display Records
                3)Delete Records
                4)Exit""");
        System.out.println("Enter Your Choice");
        int choice = Integer.parseInt(br.readLine());
        switch (choice) {
            case 1:
                addRecords();
                break;
            case 2:
                displayRecords();
                break;
            case 3:
                deleteRecords();
                break;
            case 4:
                System.exit(0);
                break;
        }
    }
}

public class StudentManagement extends Student {
    StudentManagement() throws Exception {
        super.menu();
    }

    public static void main(String[] args) throws Exception {
        new StudentManagement();
    }
}
