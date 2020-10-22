package entidades;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Trabalhador {
 private String nome;
 private NivelTrabalhador nivel;
 private double baseSalario;
 private Departamento dep;
 List<Contratos> contratos= new ArrayList<>();
 public Trabalhador() {
	 
 }
 public Trabalhador(String nome, NivelTrabalhador nivel, double baseSalario, Departamento dep) {
		this.nome = nome;
		this.nivel = nivel;
		this.baseSalario = baseSalario;
		this.dep = dep;
	}
public String getNome() {
	return nome;
}
public void setNome(String nome) {
	this.nome = nome;
}
public NivelTrabalhador getNivel() {
	return nivel;
}
public void setNivel(NivelTrabalhador nivel) {
	this.nivel = nivel;
}
public double getBaseSalario() {
	return baseSalario;
}
public void setBaseSalario(double baseSalario) {
	this.baseSalario = baseSalario;
}
public Departamento getDep() {
	return dep;
}
public List<Contratos> getContratos() {
	return contratos;
}
public void addContrato(Contratos cont) {
	contratos.add(cont);
}
public void removeContrato(Contratos cont) {
	contratos.remove(cont);
}
public double quantoGanhou(int ano, int mes) {
	double soma=baseSalario;
	Calendar calendario = Calendar.getInstance();
	for(Contratos it: contratos) {
		calendario.setTime(it.getData());
		int itAno=calendario.get(Calendar.YEAR);
		int itMes=1+calendario.get(Calendar.MONTH);	
		if(itAno==ano && itMes==mes) {
			soma+=it.valorTotal();
		}
	}
	return soma;
}
 
}
