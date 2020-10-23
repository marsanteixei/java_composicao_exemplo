package programa;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import entidades.Contratos;
import entidades.Departamento;
import entidades.NivelTrabalhador;
import entidades.Trabalhador;

public class Aplicacao {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner (System.in);
		List<Trabalhador>lista= new ArrayList<>();
		System.out.println("entre com a quantidade de funcion�rios: ");
		int q=sc.nextInt();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		for(int j=0;j<q;j++) {
			System.out.println("entre com o c�digo do funcionario "+j+": ");
			sc.nextLine();
			String codigo= sc.nextLine();
			System.out.println("entre com o nome do departamento do funcion�rio "+j+": ");
			String nomeDep= sc.nextLine();
			System.out.println("Funcion�rio: ");
			System.out.println("entre com o nome do Funcion�rio "+j+": ");
			String nome = sc.nextLine();
			System.out.println("entre com o n�vel de experi�ncia do funcion�rio "+j+": ");
			String nivel = sc.nextLine();
			System.out.println("entre com o sal�rio base do funcion�rio "+j+": ");
			double sb= sc.nextDouble();
			Trabalhador tb = new Trabalhador(codigo,nome,NivelTrabalhador.valueOf(nivel),sb,new Departamento(nomeDep));
			
			System.out.println("quantos contratos ter� o funcion�rio? ");
			int quant = sc.nextInt();
			for(int i=0;i<quant;i++) {
				System.out.println("Dados do contrato n�"+ i+": ");
				System.out.println("Data FORMATO DD/MM/AAAA: ");
				Date dataCont =sdf.parse(sc.next());
				System.out.println("entre com o valor por horar do contrato "+i+": ");
				double vph = sc.nextDouble();
				System.out.println("entre com as horas trabalhadas para o contrato "+i+": ");
				int hort = sc.nextInt();
				Contratos contrato = new Contratos(dataCont,vph,hort);
				tb.addContrato(contrato);
			}
		    lista.add(tb);
		}
		System.out.println();
		System.out.println("entre com o c�digo do funcionario para calcular ganhos: ");
		sc.nextLine();
		String cod= sc.nextLine();
		System.out.println("entre com o m�s e o ano para calculo de ganhos FORMATO MM/AAAA: ");
		String dado = sc.next();
		int mes = Integer.parseInt(dado.substring(0,2));
		int ano =Integer.parseInt(dado.substring(3));
		for(Trabalhador it:lista) {
			if(it.getCodigo().equals(cod)) {
				System.out.println("Nome do funcion�rio: "+it.getNome());
				System.out.println("Departamento: "+it.getDep().getNome());
				System.out.println("N�vel: "+it.getNivel());
				System.out.println("Ganhos em "+dado+": "+ String.format("%.2f",it.quantoGanhou(ano, mes)));
			}
		}
		sc.close();
	}

}
