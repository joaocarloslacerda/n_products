package entities;

public class Product {
	
	//atributos da classe
	protected String name;
	protected Double price;

	//cria construtor padrão
	public Product() {
	}
	
	//cria construtor personalizado com os parâmetros passados por referência
	public Product(String name, Double price) {
		this.name = name;
		this.price = price;
	}
	
	//retorna o nome do produto
	public String getName() {
		return name;
	}
	
	//seta o nome do produto
	public void setName(String name) {
		this.name = name;
	}
	
	//retorna o preço do produto
	public Double getPrice() {
		return price;
	}
	
	//seta o preço do produto
	public void setPrice(Double price) {
		this.price = price;
	}
	
	//cria uma etiqueta de preço conforme dados do produto
	public String priceTag() {
		//retorna o nome do produto printando ele
		return name
			//retorna o preço do produto printando ele conforme formatação desejada
			+ String.format(" $%.3f", price);
	}
}
