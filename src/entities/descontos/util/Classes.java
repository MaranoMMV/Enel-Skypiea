package entities.descontos.util;

import entities.imposto.Cosip;
import entities.imposto.Icms;

public class Classes {

	public static double energiaTE = 0.26046;
	public static double energiaTUSD = 0.39603;
	
	private int consumoEnergia;
	private int subGrupo;
	private int subClasse;
	
	public Classes(int consumoEnergia, int subGrupo, int subClasse, Cosip cosip, Icms icms) {
		this.consumoEnergia = consumoEnergia;
		this.subGrupo = subGrupo;
		this.subClasse = subClasse;
	}
	
	public Classes() {
	}
	
	public int getConsumoEnergia() {
		return consumoEnergia;
	}
	
	public void setConsumoEnergia(int consumoEnergia) {
		this.consumoEnergia = consumoEnergia;
	}
	
	public int getSubGrupo() {
		return subGrupo;
	}
	
	public void setSubGrupo(int subGrupo) {
		this.subGrupo = subGrupo;
	}
	
	public int getSubClasse() {
		return subClasse;
	}
	
	public void setSubClasse(int subClasse) {
		this.subClasse = subClasse;
	}
	
	
	
}
