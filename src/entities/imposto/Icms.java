package entities.imposto;

public class Icms {
	
	private int escolhaSubGrupo;
	private int consumoKwh;
	private int icms;
	
	public Icms(int escolhaSubGrupo, int consumoKwh) {
		this.escolhaSubGrupo = escolhaSubGrupo;
		this.consumoKwh = consumoKwh;
	}

	public int getEscolhaSubGrupo() {
		return escolhaSubGrupo;
	}

	public void setEscolhaSubGrupo(int escolhaSubGrupo) {
		this.escolhaSubGrupo = escolhaSubGrupo;
	}

	public int getConsumoKwh() {
		return consumoKwh;
	}

	public void setConsumoKwh(int consumoKwh) {
		this.consumoKwh = consumoKwh;
	}

	public int getIcms() {
		return icms;
	}

	public int getValorIcms() {
		if(escolhaSubGrupo == 1) {
			if(consumoKwh >= 0 && consumoKwh <=90) {
				return icms = 0;
			}
			if(consumoKwh >= 91 && consumoKwh <= 200) {
				return icms = 12;
			}
			if(consumoKwh > 200) {
				return icms = 25;
			}
		}
		if(escolhaSubGrupo == 2) {
			return icms = 18;
		}
		if(escolhaSubGrupo == 3) {
			return icms = 0;
		}
		if(escolhaSubGrupo == 4) {
			return icms = 18;
		}
		return icms;
	}

	
	
	
	
}
	

