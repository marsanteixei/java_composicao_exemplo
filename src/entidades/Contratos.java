package entidades;

import java.util.Date;

public class Contratos {
private Date data;
private double valorpHora;
private Integer horas;
public Contratos() {
	
}
public Contratos(Date data, double valorpHora, Integer horas) {
	this.data = data;
	this.valorpHora = valorpHora;
	this.horas = horas;
}
public Date getData() {
	return data;
}
public void setData(Date data) {
	this.data = data;
}
public double getValorpHora() {
	return valorpHora;
}
public void setValorpHora(double valorpHora) {
	this.valorpHora = valorpHora;
}
public Integer getHoras() {
	return horas;
}
public void setHoras(Integer horas) {
	this.horas = horas;
}
public double valorTotal() {
	return(valorpHora*horas);
}
}
