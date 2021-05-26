package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

//classe UsedProduct herda a classe Product
public class UsedProduct extends Product {
	
	//atributo da classe
	private Date manufactureDate;
	
	//cria construtor padrão conforme construtor padrão da classe herdada
	public UsedProduct(){
		super();
	}
	
	//cria construtor personalizado com base no construtor personalizado da classe herdada, e também com o atributo da própria classe
	public UsedProduct(String name, Double price, Date manufactureDate) {
		super(name, price);
		this.manufactureDate = manufactureDate;
	}
	
	//cria formatação para printar o manufactureDate
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	//retorna manufactureDate
	public Date getManufactureDate() {
		return manufactureDate;
	}
	
	//seta uma data para manufactureDate
	public void setManufactureDate(Date manufactureDate) {
		this.manufactureDate = manufactureDate;
	}
	
	//informa para o compilador que o método é uma sobreposição do método contido na classe Product
	@Override
	//cria uma etiqueta de preço conforme dados do produto usado
	public String priceTag() {
		//retorna o nome do produto printando ele
		return name
			//retorna a informação de que o produto é usado printando ela
			+  " (used) "
			//retorna o preço do produto printando ele conforme formatação
			+  String.format(" $%.3f", price)
			//retorna a data de fabricação(manufactureDate) printando ela confome formatação
			+  " (Manufacture date: " + sdf.format(manufactureDate) + ")";
	}
}
