package entities;

//classe ImportedProduct herda a classe Product
public class ImportedProduct extends Product{
	
	//atributo da classe
	private Double customsFee;
	
	//cria construtor padrão com base no construtor padrão da classe herdada
	public ImportedProduct() {
		super();
	}
	
	//cria construtor prsonalizado com base no construtor personalizado da classe herdada, e também com o atributo da própria classe
	public ImportedProduct(String name, Double price, Double customsFee) {
		super(name, price);
		this.customsFee = customsFee;
	}

	//retorna a taxa da alfandega
	public Double getCustomsFee() {
		return customsFee;
	}
	
	//seta uma taxa da alfandega
	public void setCustomsFee(Double customsFee) {
		this.customsFee = customsFee;
	}
	
	//calculando o preço total, valor do produto + taxa alfandega
	public Double totalPrice() {
		return price + customsFee;
	}
	
	//informa que o método priceTag é uma sobreposição do método priceTag contido na classe Product
	@Override
	//cria uma etiqueta de preço conforme dados do produto importado
	public String priceTag() {
		//retorna o nome do produto printando ele
		return name
			//chama a função que calcula o preço total(preço do produto + txa da alfandega) e retorna printando conforme formatação desejada
			+ String.format(" $%.2f", totalPrice())
			//retorna printando a taxa da alfandega conforme formatação desejada
			+ String.format(" (Customs fee: $ %.2f)", customsFee);
	}
	
}
