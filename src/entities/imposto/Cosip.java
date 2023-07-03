package entities.imposto;

public class Cosip {

	private int subGrupo;
	private double pis;
	private double cofins;
	private double cosip;
	
	
	
	public Cosip(int subSubGrupo) {
		this.subGrupo = subSubGrupo;
	}
	
	public int getSubGrupo() {
		return subGrupo;
	}
	public void setSubGrupo(int sububGrupo) {
		this.subGrupo = sububGrupo;
	}
	
	public double getValorPis() {
		if(subGrupo == 1 || subGrupo == 2 || subGrupo == 3) {
			return pis = 0.79;
		}
		if(subGrupo == 4) {
			return pis = 0;
		}
		if(subGrupo == 5) {
			return pis = 1.65;
		}
		return pis;
	}
	public double getValorCofins() {
		if(subGrupo == 1 || subGrupo == 2 || subGrupo == 3) {
			return cofins = 3.62;
		}
		if(subGrupo == 4) {
			return cofins = 0;
		}
		if(subGrupo == 5) {
			return cofins = 7.60;
		}
		return cofins;
	}
	
	public double getValorCosip() {
		if(subGrupo == 1) {
			return cosip = 4.5;
		}
		if(subGrupo == 2) {
			return cosip = 0;
		}
		if(subGrupo == 3 || subGrupo == 5) {
			return cosip = 29.96;
		}
		if(subGrupo == 4) {
			return cosip = 0;
		}
		return cosip;
	}
}
