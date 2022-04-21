package application;

import java.util.Locale;
import java.util.Scanner;

import application.entities.Address;
import application.entities.Department;
import application.entities.Employee;

public class EmployeeProgram {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		Department dept = new Department();
		Address address = new Address();

		System.out.print("Nome do departamento: ");
		dept.setName(sc.nextLine());
		System.out.print("Dia do pagamento:");
		dept.setPayDay(sc.nextInt());
		sc.nextLine();
		System.out.print("Email: ");
		address.setEmail(sc.nextLine());
		System.out.print("Telefone: ");
		address.setPhone(sc.nextLine());
		dept.setAddress(address);

		System.out.print("Quantos funcionários tem o departamento? ");
		int n = sc.nextInt();
		sc.nextLine();

		for (int i = 0; i < n; i++) {
			Employee e = new Employee();
			System.out.printf("Dados do funcionário %s:%n", i + 1);
			System.out.print("Nome: ");
			e.setName(sc.nextLine());
			System.out.print("Salário: ");
			e.setSalary(sc.nextDouble());
			sc.nextLine();
			dept.addEmployee(e);
		}

		System.out.println();
		showReport(dept);
		sc.close();
	}

	private static void showReport(Department dept) {
		System.out.println("FOLHA DE PAGAMENTO:");
		System.out.printf("Departamento Vendas = R$ %.2f%n", dept.payroll());
		System.out.printf("Pagamento realizado no dia %d%n", dept.getPayDay());
		System.out.println("Funcionários:");
		
		for (Employee e : dept.getEmployees())
			System.out.println(e.getName());
		
		System.out.printf("Para dúvidas favor entrar em contato: %s", dept.getAddress().getEmail());
	}
}