package miniproject;

import java.io.*;

interface StudentInterface {

    public void addRecords();

    public void deleteRecords();
}
class Student implements StudentInterface{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    @Override
    public void addRecords(){
        
    }
    @Override
    public void deleteRecords(){
        
    }
    void menu() throws IOException
    {
        System.out.println("Student Management");
        System.out.println("""
                           1)Add Records
                           2)Display Records
                           3)Delete Records
                           4)Exit""");
        System.out.println("Enter Your Choice");
        int choice = Integer.parseInt(br.readLine());
        System.out.println("Choice is "+choice);
    }
}
public class StudentManagement {

    public static void main(String[] args) throws IOException {
        new Student().menu();
    }

}
