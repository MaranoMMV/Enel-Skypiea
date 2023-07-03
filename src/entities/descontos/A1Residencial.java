package entities.descontos;

import entities.descontos.interfaces.CalcEnergia;
import entities.descontos.util.Classes;
import entities.imposto.Cosip;
import entities.imposto.Icms;

public class A1Residencial extends Classes implements CalcEnergia{

	public A1Residencial() {
		super();
	}
	public A1Residencial(int consumoEnergia, int subGrupo, int subClasse, Cosip cosip, Icms icms) {
		super(consumoEnergia, subGrupo, subClasse, cosip, icms);
	}
	
	public int calcDescontoTe() {
		return 0;
	}
	
	public int calcDescontoTusd() {
		return 0;
	}
	
	public double getDescontoEnergiaTusd() {
		return Classes.energiaTUSD * getConsumoEnergia();
	}
	
	public double getDescontoEnergiaTe() {
		return (Classes.energiaTE * getConsumoEnergia());
	}
	
	public double getValoresImpostosTe() {
		Cosip cosip = new Cosip(1);
		Icms icms = new Icms(getSubGrupo(), getConsumoEnergia());
		
		System.out.println();
		System.out.println("Energia TE");
		System.out.println("Valor cosip =" + cosip.getValorCosip());
		System.out.println("Valor pis = " + (getDescontoEnergiaTe() - (getDescontoEnergiaTe() - (getDescontoEnergiaTe() * cosip.getValorPis()/100))));
		System.out.println("Valor Cofins = " + (getDescontoEnergiaTe() - (getDescontoEnergiaTe() - (getDescontoEnergiaTe() * cosip.getValorCofins()/100))));
		System.out.println("Valor icms: " + (getDescontoEnergiaTe() - (getDescontoEnergiaTe() - (getDescontoEnergiaTe() * icms.getValorIcms()/100))));
		

		return cosip.getValorCosip() 
				+ getDescontoEnergiaTe() - (getDescontoEnergiaTe() - (getDescontoEnergiaTe() * cosip.getValorCofins()/100)) 
				+ getDescontoEnergiaTe() - (getDescontoEnergiaTe() - (getDescontoEnergiaTe() * cosip.getValorPis()/100))
				+ getDescontoEnergiaTe() - (getDescontoEnergiaTe() - (getDescontoEnergiaTe() * icms.getValorIcms()/100));
	}
	
	public double getValoresImpostosTusd() {
		Cosip cosip = new Cosip(1);
		Icms icms = new Icms(getSubGrupo(), getConsumoEnergia());
		System.out.println();
		System.out.println("Energia TUSD");
		System.out.println("Valor cosip =" + cosip.getValorCosip());
		System.out.println("Valor pis = " + (getDescontoEnergiaTusd() - (getDescontoEnergiaTusd() - (getDescontoEnergiaTusd() * cosip.getValorPis()/100))));
		System.out.println("Valor Cofins = " + (getDescontoEnergiaTusd() - (getDescontoEnergiaTusd() - (getDescontoEnergiaTusd() * cosip.getValorCofins()/100))));
		System.out.println("Valor icms: " + (getDescontoEnergiaTusd() - (getDescontoEnergiaTusd() - (getDescontoEnergiaTusd() * icms.getValorIcms()/100))));
		

		return cosip.getValorCosip() 
				+ getDescontoEnergiaTusd() - (getDescontoEnergiaTusd() - (getDescontoEnergiaTusd() * cosip.getValorCofins()/100)) 
				+ getDescontoEnergiaTusd() - (getDescontoEnergiaTusd() - (getDescontoEnergiaTusd() * cosip.getValorPis()/100))
				+ getDescontoEnergiaTusd() - (getDescontoEnergiaTusd() - (getDescontoEnergiaTusd() * icms.getValorIcms()/100));
	}
	
	public double getValorTotalTe() {
		return getDescontoEnergiaTe() + getValoresImpostosTe();
	}
	
	public double getValorTotalTusd() {
		return getDescontoEnergiaTusd() + getValoresImpostosTusd();
	}
	@Override
	public String toString() {
		return "A1Residencial [calcDescontoTe()=" + calcDescontoTe() + ", calcDescontoTusd()=" + calcDescontoTusd()
				+ ", getDescontoEnergiaTusd()=" + getDescontoEnergiaTusd() + ", getDescontoEnergiaTe()="
				+ getDescontoEnergiaTe() + ", getValoresImpostosTe()=" + getValoresImpostosTe()
				+ ", getValoresImpostosTusd()=" + getValoresImpostosTusd() + ", getValorTotalTe()=" + getValorTotalTe()
				+ ", getValorTotalTusd()=" + getValorTotalTusd() + "]";
	}
	
	
	
	
	
	
	
}
