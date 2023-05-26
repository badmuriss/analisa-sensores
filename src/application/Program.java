package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import entities.Sensor;

public class Program {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File("./resources/sensores.csv")));
			
		String linha;
		ArrayList<Sensor> listaSensoresGrupo1 = new ArrayList<>();
		ArrayList<Sensor> listaSensoresGrupo2 = new ArrayList<>();
		ArrayList<Sensor> listaSensoresGrupo3 = new ArrayList<>();
		int iD, areaMonitorada, taxaTransferencia;
		double alcanceTransmissao, pH;
		int somaArea = 0, count = 1;
		String[] maiorAlcance = {"0","0"};
		String[] menorAlcance = {"0","99999"};
		String[] maiorTaxa = {"0","0"};
		
		//remove o cabecalho do csv
		String headerLine = br.readLine();
		
		while((linha = br.readLine()) != null){
			String[] arrayLinhaString = linha.split(",");
			iD = Integer.parseInt(arrayLinhaString[0]);
			areaMonitorada = Integer.parseInt(arrayLinhaString[1]);
			alcanceTransmissao = Double.parseDouble(arrayLinhaString[2]);
			taxaTransferencia = Integer.parseInt(arrayLinhaString[3]);
			
			//valida o ID
			if(iD >= 1001 && iD <= 3999 ){
				//valida o alcance
				if(alcanceTransmissao >= 5 && alcanceTransmissao <= 10 && alcanceTransmissao*1000 % 200 == 0) {
					//valida a taxa
					if(taxaTransferencia >= 250 && taxaTransferencia <= 500 && taxaTransferencia % 10 == 0) {
						if(iD <= 1999 ){
							pH = Double.parseDouble(arrayLinhaString[4]);
							//valida o pH
							if (pH >= 4 && pH <= 8) {
								listaSensoresGrupo1.add(new Sensor(iD, areaMonitorada, alcanceTransmissao, taxaTransferencia, pH)); 
							} else {
								System.out.println("pH invalido no Sensor de ID: " + iD + ", Linha " + count);
								System.exit(0);
							}
							
							if (!(pH >= 5.5 && pH <= 6.5)) {
								System.out.println("SENSOR " + iD + ", pH ALTERADO!");
							}
							
						} 
						
						if(iD >= 2000 && iD <= 2999 ){ 
							listaSensoresGrupo2.add(new Sensor(iD, areaMonitorada, alcanceTransmissao, taxaTransferencia));
						
						} if(iD >= 3000 && iD <= 3999 ) {
							listaSensoresGrupo3.add(new Sensor(iD, areaMonitorada, alcanceTransmissao, taxaTransferencia));
						}
					} else {
						System.out.println("Taxa de transferencia invalida no Sensor de ID: " + iD + ", Linha " + count);
						System.exit(0);
					}
				} else {
					System.out.println("Alcance de Transmissao invalido no Sensor de ID: " + iD + ", Linha " + count);
					System.exit(0);
				}
			} else {
				System.out.println("ID invalido no Sensor de ID: " + iD + ", Linha " + count);
				System.exit(0);
			}
			
			//checa o maior alcance
			if (alcanceTransmissao >= Double.parseDouble(maiorAlcance[1])) {
				if (alcanceTransmissao == Double.parseDouble(maiorAlcance[1])) {
					maiorAlcance[0] = maiorAlcance[0] + ", " + Integer.toString(iD);
				} else {
					maiorAlcance[0] = Integer.toString(iD);
					maiorAlcance[1] = Double.toString(alcanceTransmissao);
				}
			}
			
			//checa o menor alcance
			if (alcanceTransmissao <= Double.parseDouble(menorAlcance[1])) {
				if (alcanceTransmissao == Double.parseDouble(maiorAlcance[1])) {
					menorAlcance[0] = menorAlcance[0] + ", " + Integer.toString(iD);
				} else {
					menorAlcance[0] = Integer.toString(iD);
					menorAlcance[1] = Double.toString(alcanceTransmissao);
				}
			}
			
			//checa a maior taxa
			if (taxaTransferencia >= Integer.parseInt(maiorTaxa[1])) {
				if (taxaTransferencia == Double.parseDouble(maiorTaxa[1])) {
					maiorTaxa[0] = maiorTaxa[0] + ", " + Integer.toString(iD);
				} else {
					maiorTaxa[0] = Integer.toString(iD);
					maiorTaxa[1] = Integer.toString(taxaTransferencia);
				}
			}
			
			count++;
			somaArea += areaMonitorada;
			
		}
		
		if (count > 1) {
		
			System.out.println();
			System.out.println("Quantidade de Sensores do Grupo 1: " + listaSensoresGrupo1.size());
			System.out.println("Quantidade de Sensores do Grupo 2: " + listaSensoresGrupo2.size());	
			System.out.println("Quantidade de Sensores do Grupo 3: " + listaSensoresGrupo3.size());
			System.out.println();
			System.out.println("Soma da área monitorada: " + somaArea + " m2");
			System.out.println("Maior alcance de transmissao: " + (maiorAlcance[0].length() > 4 ? "Sensores " : "Sensor ") + maiorAlcance[0] + " - " + maiorAlcance[1] + " km");
			System.out.println("Menor alcance de transmissao: " + (menorAlcance[0].length() > 4 ? "Sensores " : "Sensor ") + menorAlcance[0] + " - " + menorAlcance[1] + " km");
			System.out.println("Maior taxa de transmissao: " + (maiorTaxa[0].length() > 4 ? "Sensores " : "Sensor ") + maiorTaxa[0] + " - " + maiorTaxa[1] + " kbit/s");
			
		}
		
		} 
		
		
	}

