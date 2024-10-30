import java.util.Scanner;
class Employee
{
    int employeeId;
    String employeeName;
    String designation;

    Scanner sc=new Scanner(System.in);
    void input()
    {
        //Prompt and accept user details
        System.out.println("Enter Employee ID: ");
        employeeId=sc.nextInt();
        sc.nextLine();
        System.out.println("Enter full name : ");
        employeeName = sc.nextLine();
        System.out.println("Enter job title within the university: ");
        designation =sc.nextLine();
    }
    void display()
    {
        //Display user details for confirmation
        System.out.println("Confirming User Information");
        System.out.println("***************************");
        System.out.println("Employee ID : "+employeeId);
        System.out.println("Employee Name : "+employeeName);
        System.out.println("Employee Designation : "+designation);
        System.out.println();
    }
    public double calcBonus() 
    {
        return 0.0;
    }
}
class HourlyEmployee extends Employee
{
    double hourlyRate;
    int hoursWorked;

    //Overriding
    public void input() 
    {
        super.input();
        System.out.print("Enter hourly rate: ");
        hourlyRate=sc.nextDouble();
        System.out.print("Enter hours worked in a week: ");
        hoursWorked=sc.nextInt();
    }
    public double calculateBonus() 
    {
        //Calculated as 10% of weekly salary
        return hourlyRate*hoursWorked * 0.1;
    }
    public double calcWeeklySalary()
    {
        return hourlyRate*hoursWorked;
    }
    //Overriding base class method
    public void display() 
    {
        super.display();
        System.out.println("Hourly Rate: $" + hourlyRate);
        System.out.println("Hours Worked: " + hoursWorked);
        System.out.println("Weekly Salary: $" + calcWeeklySalary());
        System.out.println("Bonus: $" + calcBonus());
    }    
}
class SalariedEmployee extends Employee
{  
    double monthlySalary;

    public void input() 
    {
        super.input();
        System.out.print("Enter monthly salary: ");
        monthlySalary = sc.nextDouble();
    }
    public double calcBonus() 
    {
        //Calculated as 15% of weekly salary
        return (monthlySalary/4)*0.15; 
    }
    public double calcWeeklySalary() 
    {
        return monthlySalary/4;
    }
    public void display() 
    {
        super.display();
        System.out.println("Monthly Salary: $" + monthlySalary);
        System.out.println("Weekly Salary: $" + calcWeeklySalary());
        System.out.println("Bonus: $" + calcBonus());
    }
}
class ExecutiveEmployee extends SalariedEmployee
{
    double bonusPercentage;

    public void input() 
    {
        super.input();
        System.out.print("Enter bonus percentage: ");
        bonusPercentage=sc.nextDouble();
    }
    public double calcBonus()
    {
        double baseBonus=super.calcBonus();
        return baseBonus + (monthlySalary*12*(bonusPercentage/100));
    }
    public void display() 
    {
        super.display();
        System.out.println("Bonus Percentage: "+bonusPercentage+"%");
        System.out.println("Total Bonus: $" + calcBonus());
    }
}
public class Payroll
{
    public static void main(String[] args)
    {
        //Deatails of Hourly Employee
        HourlyEmployee hourlyEmployee = new HourlyEmployee();
        System.out.println("Hourly Employee Information:");
        hourlyEmployee.input();
        hourlyEmployee.display();

        System.out.println();
        System.out.println("-----------------------------");
        System.out.println();

        //Details of Salaried Employee
        SalariedEmployee salariedEmployee = new SalariedEmployee();
        System.out.println("Salaried Employee Information:");
        salariedEmployee.input();
        salariedEmployee.display();

        System.out.println();
        System.out.println("-----------------------------");
        System.out.println();

        //Details of Executive Employee
        ExecutiveEmployee executiveEmployee = new ExecutiveEmployee();
        System.out.println("Executive Employee Information:");
        executiveEmployee.input();
        executiveEmployee.display();

        System.out.println();
        System.out.println("-----------------------------");
    }
}
