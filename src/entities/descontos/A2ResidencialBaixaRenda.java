package entities.descontos;

import entities.descontos.interfaces.CalcEnergia;
import entities.descontos.util.Classes;
import entities.imposto.Cosip;
import entities.imposto.Icms;

public class A2ResidencialBaixaRenda extends Classes implements CalcEnergia{

	public A2ResidencialBaixaRenda() {
		super();
	}

	public A2ResidencialBaixaRenda(int consumoEnergia, int subGrupo, int subClasse, Cosip cosip, Icms icms) {
		super(consumoEnergia, subGrupo, subClasse, cosip, icms);
	}
	
	public double getEnergiaTusd() {
		return Classes.energiaTUSD * getConsumoEnergia();
	}
	
	public double getEnergiaTe() {
		return Classes.energiaTE * getConsumoEnergia();
	}
	
	@Override
	public double getDescontoEnergiaTusd() {
		int desconto = 0;
		if(getConsumoEnergia() <= 30) {
			return desconto = 72;
		}
		if(getConsumoEnergia() >= 31 && getConsumoEnergia() <= 100) {
			return desconto = 50;
		}
		if(getConsumoEnergia() >= 101 && getConsumoEnergia() <= 220) {
			return desconto = 30;
		}
		if(getConsumoEnergia() > 220) {
			return desconto = 25;
		}
		return desconto;
	}

	@Override
	public double getDescontoEnergiaTe() {
		int desconto = 0;
		if(getConsumoEnergia() <= 30) {
			return desconto = 65;
		}
		if(getConsumoEnergia() >= 31 && getConsumoEnergia() <= 100) {
			return desconto = 40;
		}
		if(getConsumoEnergia() >= 101 && getConsumoEnergia() <= 220) {
			return desconto = 10;
		}
		if(getConsumoEnergia() > 220) {
			return desconto = 0;
		}
		return desconto;
	}

	public double getValoresImpostosTe() {
		Cosip cosip = new Cosip(getSubGrupo());
		Icms icms = new Icms(getSubGrupo(), getConsumoEnergia());
		
		System.out.println();
		System.out.println("Energia TE");
		System.out.println("Valor cosip =" + cosip.getValorCosip());
		System.out.println("Valor pis = " + (getEnergiaTe() - (getEnergiaTe() - (getEnergiaTe() * cosip.getValorPis()/100))));
		System.out.println("Valor Cofins = " + (getEnergiaTe() - (getEnergiaTe() - (getEnergiaTe() * cosip.getValorCofins()/100))));
		System.out.println("Valor icms: " + (getEnergiaTe() - (getEnergiaTe() - (getEnergiaTe() * icms.getValorIcms()/100))));
		

		return cosip.getValorCosip() 
				+ getEnergiaTe() - (getEnergiaTe() - (getEnergiaTe() * cosip.getValorCofins()/100)) 
				+ getEnergiaTe() - (getEnergiaTe() - (getEnergiaTe() * cosip.getValorPis()/100))
				+ getEnergiaTe() - (getEnergiaTe() - (getEnergiaTe() * icms.getValorIcms()/100));

	}
	
	public double getValoresImpostosTusd() {
		Cosip cosip = new Cosip(1);
		Icms icms = new Icms(getSubGrupo(), getConsumoEnergia());
		System.out.println();
		System.out.println("Energia TUSD");
		System.out.println("Valor cosip =" + cosip.getValorCosip());
		System.out.println("Valor pis = " + (getEnergiaTusd() - (getEnergiaTusd() - (getEnergiaTusd() * cosip.getValorPis()/100))));
		System.out.println("Valor Cofins = " + (getEnergiaTusd() - (getEnergiaTusd() - (getEnergiaTusd() * cosip.getValorCofins()/100))));
		System.out.println("Valor icms: " + (getEnergiaTusd() - (getEnergiaTusd() - (getEnergiaTusd() * icms.getValorIcms()/100))));
		

		return cosip.getValorCosip() 
				+ getEnergiaTusd() - (getEnergiaTusd() - (getEnergiaTusd() * cosip.getValorCofins()/100)) 
				+ getEnergiaTusd() - (getEnergiaTusd() - (getEnergiaTusd() * cosip.getValorPis()/100))
				+ getEnergiaTusd() - (getEnergiaTusd() - (getEnergiaTusd() * icms.getValorIcms()/100));
	}
	
	public double getValorTotalTe() {
		return getEnergiaTe() + getValoresImpostosTe();
	}
	
	public double getValorTotalTusd() {
		return getEnergiaTusd() + getValoresImpostosTusd();
	}
}
