package application;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.domainException;

public class Program {

	public static void main(String[] args) {
		 
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		
			try {
				System.out.println("Digite as informações da conta");
				System.out.print("Numero da conta: ");
				Integer number = sc.nextInt();
				System.out.print("Nome: ");
				sc.next();
				String holder = sc.nextLine();
				System.out.print("Saldo inicial: ");
				Double balance = sc.nextDouble();
				System.out.print("Limite de saque: ");
				Double withdrawLimit = sc.nextDouble();
				
				Account account = new Account(number, holder, balance, withdrawLimit);
				
				System.out.print("Digite o valor para saque: ");
				Double amount = sc.nextDouble();
				account.withdraw(amount);
				System.out.printf("Saldo atual %.2f: ", account.getBalance());
				
				
			} 
			catch (domainException e) {
				System.out.println(e.getMessage());
				
			}
			catch (InputMismatchException e) {
				System.out.println("Erro: Digite apenas numeros sem ponto ou vígula");
				
			}
		
		
		
		sc.close();
	}

}
