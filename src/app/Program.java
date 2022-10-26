package app;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.WorkerLevel;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Program {
    public static void main(String[] args) {
        String data;
        Double valueHour;
        Integer durationHours;
        Locale.setDefault(Locale.ENGLISH);
        List <HourContract> contratos = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter yearMonth = DateTimeFormatter.ofPattern("MM/yyyy");
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter department's name: ");
        Department department = new Department(sc.next());
        System.out.println("Enter worker data:");
        System.out.print("Name: ");
        String name = sc.nextLine();
        sc.nextLine();
        System.out.print("Level: ");
        String level = sc.next();
        System.out.print("Base salary: ");
        Double salary = sc.nextDouble();
        System.out.print("How many contracts to this worker? ");
        int qtdContracts = sc.nextInt();
        for (int i = 1; i <= qtdContracts; i++) {
            System.out.println("Enter contract #" +i+" data:");
            System.out.print("Date (DD/MM/YYYY): ");
            data = sc.next();
            System.out.print("Value per hour: ");
            valueHour = sc.nextDouble();
            System.out.print("Duration (hours): ");
            durationHours = sc.nextInt();
            contratos.add(new HourContract(LocalDate.parse(data, formatter), valueHour, durationHours));
        }
        Worker trab = new Worker(name, WorkerLevel.valueOf(level), salary, department,contratos );
        System.out.print("Enter month and year to calculate (MM/YYYY): ");
        String date = sc.next();

        LocalDate yearAndMonth = LocalDate.parse(date, yearMonth);
        int mes = yearAndMonth.getMonthValue();
        int year = yearAndMonth.getYear();

        System.out.println("Name: "+trab.getName());
        System.out.println("Department: "+trab.getDepartamento());
        System.out.println("Income for "+ yearAndMonth.format(yearMonth)+" : "+trab.income(year,mes));

    }
}
