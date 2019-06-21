import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.NoSuchElementException;
import java.util.Scanner;

//Author: Keith Kirtfield
//This class Stores the employees in an array
public class FileInput {
    public static void main(String [] args){
        String response = promptFileInput(args);

        try{
            /*GETTING FILE READ*/
            File file = new File(response);
            Scanner readFile = new Scanner(file);
            /*FINISH*/
            /*CREATING WRITE FILE*/
            PrintWriter writer = new PrintWriter("output.txt", "UTF-8");
            /*END*/
            EmployeeStore store = new EmployeeStore();
            while(readFile.hasNextLine()){
//              Getting the information from the document
                String[] splited = readFile.nextLine().split(" ");
                Employee e1 = new Employee();
                e1.setName(splited[1] + " " + splited[2]);
                e1.setWage(Double.parseDouble(splited[3]));
                e1.setHours(Double.parseDouble(splited[4]));
                char [] status = splited[0].toCharArray();
                e1.setStatus(status[0]);
                /*ADDING EMPLOYEE INTO THE ARRAY CLASS*/
                store.addEmployee(e1);
            }
//            writer.write("Total Employee Cost Per Week");
            store.printArray();
//            store.printPayout();
//            writer.write(store.totalEmployeePayout() + "");



            writer.close();
        }catch(FileNotFoundException e){
            System.err.println("File Not Found");
        }catch (IOException e){
            System.err.println("Move on");
        }catch(NoSuchElementException e){
            System.err.println("End Of FIle");
        }

    }
//    Prompts user to enter a file name
    private static String promptFileInput(String [] args){
        if(args.length > 0){
            return args[0];
        }
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a input file");
        return in.nextLine();


    }
}
