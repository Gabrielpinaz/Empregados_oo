package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Address;
import entities.Department;
import entities.Employee;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Nome do departamento: ");
		String departmentName = sc.nextLine();
		System.out.print("Dia do pagamento: ");
		int payDay = sc.nextInt();
		sc.nextLine();
		System.out.print("Email: ");
		String email = sc.nextLine();
		System.out.print("Telefone: ");
		String phone = sc.nextLine();
		Department dept = new Department(departmentName, payDay, new Address(email, phone));
		
		System.out.print("Quantos funcionários tem o departamento? ");
		int n = sc.nextInt();
		
		for (int i=1; i<=n; i++) {
			System.out.println("Dados do funcionário " + i + ":");
			System.out.print("Nome: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Salário: ");
			double salary = sc.nextDouble();
			Employee employee = new Employee(name, salary);
			dept.addEmployee(employee);
		}
		
		showReport(dept);
		
		sc.close();
	}

	private static void showReport(Department dept) {
		System.out.println();
		System.out.println("FOLHA DE PAGAMENTO:");
		System.out.printf("Departamento %s = R$ %.2f%n", dept.getName(), dept.payroll());
		System.out.println("Pagamento realizado no dia: " + dept.getPayDay());
		System.out.println("Funcionários:");
		
		for (int i=0; i < dept.getEmployees().size(); i++) {
			
			System.out.println(dept.getEmployees().get(i).getName());
			
		}
		
		System.out.println("Para dúvidas favor entrar em contato: " + dept.getAddress().getEmail());
		
		}
		
	}
