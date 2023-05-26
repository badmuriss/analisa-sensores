package entities;

public class Sensor {
	
	public String toString() {
		return pH > 0 ? "ID: " + iD + " - Area Monitorada (m2): " + areaMonitorada + " - Alcance (km): " + alcanceTransmissao + " - Taxa transf (kbit/s): " + taxaTransferencia + " - pH: " + pH: "ID: " + iD + " - Area Monitorada (m2): " + areaMonitorada + " - Alcance (km): " + alcanceTransmissao + " - Taxa transf (kbit/s): " + taxaTransferencia;
	  }
	
	public Sensor(int iD, int areaMonitorada, double alcanceTransmissao, double taxaTransferencia) {
		super();
		this.iD = iD;
		this.areaMonitorada = areaMonitorada;
		this.alcanceTransmissao = alcanceTransmissao;
		this.taxaTransferencia = taxaTransferencia;
	}
	
	public Sensor(int iD, int areaMonitorada, double alcanceTransmissao, double taxaTransferencia, double pH) {
		super();
		this.iD = iD;
		this.areaMonitorada = areaMonitorada;
		this.alcanceTransmissao = alcanceTransmissao;
		this.taxaTransferencia = taxaTransferencia;
		this.pH = pH;
	}
	
	int iD;
	int areaMonitorada;
	double alcanceTransmissao;
	double taxaTransferencia;
	double pH;	
	
	public int getID() {
		return iD;
	}
	public void setID(int iD) {
		this.iD = iD;
	}
	public int getAreaMonitorada() {
		return areaMonitorada;
	}
	public void setAreaMonitorada(int areaMonitorada) {
		this.areaMonitorada = areaMonitorada;
	}
	public double getAlcanceTransmissao() {
		return alcanceTransmissao;
	}
	public void setAlcanceTransmissao(double alcanceTransmissao) {
		this.alcanceTransmissao = alcanceTransmissao;
	}
	public double getTaxaTransferencia() {
		return taxaTransferencia;
	}
	public void setTaxaTransferencia(double taxaTransferencia) {
		this.taxaTransferencia = taxaTransferencia;
	}
	public double getpH() {
		return pH;
	}
	public void setpH(double pH) {
		this.pH = pH;
	}


	
	
}
