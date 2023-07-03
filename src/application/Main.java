package application;

import java.util.Locale;
import java.util.Scanner;

import entities.descontos.A1Residencial;
import entities.descontos.A2ResidencialBaixaRenda;
import entities.imposto.Cosip;
import entities.imposto.Icms;

public class Main {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		
		System.out.println("Hellow World!");
		System.out.println();
		
		System.out.println("Bem vindo ao calculador de energia!");
		System.out.println();
		
		System.out.println("Digite o seu consumo em kWh: ");
		int consumoEnergia = scan.nextInt();
		System.out.println();
		
		System.out.println("Digite o numero para calcular o valor da sua energia: ");
		System.out.println("1 - Residencial, 2 - Servico Publico , 3 - Outros (Nao Classificado)");
		int subGrupo = scan.nextInt();;
		
		
		if(subGrupo == 1) {
			System.out.println("Digite a sua subclasse:");
			System.out.println("1 - Residencial, 2 - Residencial baixa renda, 3 - Residencia Rural");
			int subClasse = scan.nextInt();
			
			if(subClasse == 1) {
				A1Residencial a1Residencial = new A1Residencial(consumoEnergia, subGrupo, subClasse, new Cosip(subGrupo), new Icms(subGrupo, consumoEnergia));
				System.out.println("Valor da energia: " + a1Residencial.getDescontoEnergiaTe());
				System.out.println("Teste A1B1");
				System.out.println("Valor total: " + a1Residencial.getValorTotalTe());
				System.out.println("Valor total: " + a1Residencial.getValorTotalTusd());
			}else if(subClasse == 2) {
				A2ResidencialBaixaRenda a2Residencial = new A2ResidencialBaixaRenda(consumoEnergia, subGrupo, subClasse, new Cosip(subGrupo), new Icms(subGrupo, consumoEnergia));
				System.out.println("Valor da energia: " + a2Residencial.getDescontoEnergiaTe());
				System.out.println("Teste A1B1");
				System.out.println("Valor total: " + a2Residencial.getValorTotalTe());
				System.out.println("Valor total: " + a2Residencial.getValorTotalTusd());
			}
		}
		if(subGrupo == 2) {
			System.out.println("Digite o numero do servico");
			System.out.println("1 - Poder publico [Municipal], 2 - Poder publico [Estadual]");
			int escolhaSubClasse = scan.nextInt();
		}
	
	}

}
