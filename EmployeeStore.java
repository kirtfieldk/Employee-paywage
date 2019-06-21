import java.util.Iterator;


//Author: Keith Kirtfield
//This class Stores the employees in an array
public class EmployeeStore {
    int numEmployee;
    Employee [] employee;
    double [] payout;
    public EmployeeStore(){
        numEmployee = 0;
        employee = new Employee[2];
        payout = new double[2];
    }
    /*ADDING EMPLOYEE IF ARRAY IS FULL DOUBLE THE SIZE*/
    public void addEmployee(Employee addEmployee){
        if(employee.length == numEmployee)
            doubleArray();
        employee[numEmployee++] = addEmployee;
        }
        /*DELETEING SPECIFIC EMPLOYEE*/
    public void deleteEmployee(String name){
        for(int i = 0; i < employee.length; i++){
            if(employee[i].getName().equals(name)){
                employee[i] = null;
                numEmployee--;
                break;
            }
        }
    }
    /*IF NAME OCCURS TWICE DELETE THE EARLIEST ENTRY*/
    public void doubleName() {
        for (int i = 0; i < employee.length; i++) {
            if (employee[i] != null)
                for (int j = i; j < employee.length - 1; j++) {
                    if (employee[j] != null) {
                        if (employee[i].getName().equalsIgnoreCase(employee[j].getName())) {
                            employee[i] = null;
                        }
                    }
                }
        }
    }
    /*DELETE LAST EMPLOYEE FOR THE CLEAR METHOD*/
    private void deleteLastEmployee(){
        numEmployee--;
        employee[numEmployee] = null;
    }
    /*CLEAR*/
    public void clear(){
        while(!isEmpty()){
            deleteLastEmployee();
        }
    }
    /*DOUBLE ARRAY*/
    public void doubleArray(){
        Employee [] temp = new Employee[numEmployee * 2];
        for(int i = 0; i < employee.length; i++){
            temp[i] = employee[i];
        }
        employee = temp;
    }
    public int printNumEmployee(){
        return numEmployee;
    }
    /*SIMPLY PRINT EMPLOYEE ARRAY*/
    public void printArray(){
        doubleName();
        System.out.println(employee.length);
        for(Employee x: employee){
            if(x == null){
                continue;
            }else
                System.out.println(x.getStatus() + " " + x.getName() + " " + x.getWage() + " " + x.getHours());
        }
    }
    /*CHECK IF IT IS EMPTY*/
    public boolean isEmpty(){
        return numEmployee == 0;
    }
    /*
    * EMPLOYEE WAGE PAYOUT INFORMATION
    */
    private void sizePayout(){
        double [] temp = new double[numEmployee];
        for(int i = 0; i < payout.length; i++){
            temp[i] = payout[i];
        }
        payout = temp;
    }
    private void addIncome(){
        int i = 1;
        sizePayout();
        while(i != employee.length){
            if(employee[i] == null){
                continue;
            }else
                payout[i] = employee[i].getWage() * employee[i].getHours();
            i++;
        }
    }
    public void printPayout(){
        addIncome();
        for(double x: payout){
            System.out.println(x);
        }
    }
    /*RETURNS THE PAYOUT ARRAY TO BE USED IN MAY METHOD*/
    public double [] payoutArray(){
        addIncome();
        return payout;
    }
    /*END*/
    public double totalEmployeePayout(){
        double total = 0;
        for(int i = 0; i < payout.length; i++){
            total+=payout[i];
        }
        return total;
    }
}
