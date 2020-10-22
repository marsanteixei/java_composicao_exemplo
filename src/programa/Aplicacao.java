package programa;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entidades.Contratos;
import entidades.Departamento;
import entidades.NivelTrabalhador;
import entidades.Trabalhador;

public class Aplicacao {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner (System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println("entre com o nome do departamento: ");
		String nomeDep= sc.nextLine();
		System.out.println("Funcion�rio: ");
		System.out.println("entre com o nome do Funcion�rio: ");
		String nome = sc.nextLine();
		System.out.println("entre com o n�vel de experi�ncia do funcion�rio: ");
		String nivel = sc.nextLine();
		System.out.println("entre com o sal�rio base do funcion�rio: ");
		double sb= sc.nextDouble();
		Trabalhador tb = new Trabalhador(nome,NivelTrabalhador.valueOf(nivel),sb,new Departamento(nomeDep));
		
		System.out.println("quantos contratos ter� o funcion�rio? ");
		int quant = sc.nextInt();
		for(int i=0;i<quant;i++) {
			System.out.println("Dados do contrato n�"+ i+": ");
			System.out.println("Data FORMATO DD/MM/AAAA: ");
			Date dataCont =sdf.parse(sc.next());
			System.out.println("entre com o valor por horar do contrato: ");
			double vph = sc.nextDouble();
			System.out.println("entre com as horas trabalhadas: ");
			int hort = sc.nextInt();
			Contratos contrato = new Contratos(dataCont,vph,hort);
			tb.addContrato(contrato);
		}
		System.out.println();
		System.out.println("entre com o m�s e o ano para calculo de ganhos FORMATO MM/AAAA: ");
		String dado = sc.next();
		int mes = Integer.parseInt(dado.substring(0,2));
		int ano =Integer.parseInt(dado.substring(3));
		
		System.out.println("Nome do funcion�rio: "+tb.getNome());
		System.out.println("Departamento: "+tb.getDep().getNome());
		System.out.println("Ganhos em "+dado+": "+ String.format("%.2f",tb.quantoGanhou(ano, mes)));
		
        sc.close();
	}

}
