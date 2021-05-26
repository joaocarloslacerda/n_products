package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

//classe UsedProduct herda a classe Product
public class UsedProduct extends Product {
	
	//atributo da classe
	private Date manufactureDate;
	
	//cria construtor padr�o conforme construtor padr�o da classe herdada
	public UsedProduct(){
		super();
	}
	
	//cria construtor personalizado com base no construtor personalizado da classe herdada, e tamb�m com o atributo da pr�pria classe
	public UsedProduct(String name, Double price, Date manufactureDate) {
		super(name, price);
		this.manufactureDate = manufactureDate;
	}
	
	//cria formata��o para printar o manufactureDate
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	//retorna manufactureDate
	public Date getManufactureDate() {
		return manufactureDate;
	}
	
	//seta uma data para manufactureDate
	public void setManufactureDate(Date manufactureDate) {
		this.manufactureDate = manufactureDate;
	}
	
	//informa para o compilador que o m�todo � uma sobreposi��o do m�todo contido na classe Product
	@Override
	//cria uma etiqueta de pre�o conforme dados do produto usado
	public String priceTag() {
		//retorna o nome do produto printando ele
		return name
			//retorna a informa��o de que o produto � usado printando ela
			+  " (used) "
			//retorna o pre�o do produto printando ele conforme formata��o
			+  String.format(" $%.3f", price)
			//retorna a data de fabrica��o(manufactureDate) printando ela confome formata��o
			+  " (Manufacture date: " + sdf.format(manufactureDate) + ")";
	}
}
