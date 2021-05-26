package entities;

//classe ImportedProduct herda a classe Product
public class ImportedProduct extends Product{
	
	//atributo da classe
	private Double customsFee;
	
	//cria construtor padr�o com base no construtor padr�o da classe herdada
	public ImportedProduct() {
		super();
	}
	
	//cria construtor prsonalizado com base no construtor personalizado da classe herdada, e tamb�m com o atributo da pr�pria classe
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
	
	//calculando o pre�o total, valor do produto + taxa alfandega
	public Double totalPrice() {
		return price + customsFee;
	}
	
	//informa que o m�todo priceTag � uma sobreposi��o do m�todo priceTag contido na classe Product
	@Override
	//cria uma etiqueta de pre�o conforme dados do produto importado
	public String priceTag() {
		//retorna o nome do produto printando ele
		return name
			//chama a fun��o que calcula o pre�o total(pre�o do produto + txa da alfandega) e retorna printando conforme formata��o desejada
			+ String.format(" $%.2f", totalPrice())
			//retorna printando a taxa da alfandega conforme formata��o desejada
			+ String.format(" (Customs fee: $ %.2f)", customsFee);
	}
	
}
