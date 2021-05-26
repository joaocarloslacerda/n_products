package aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Main {

	public static void main(String[] args) throws ParseException{
		
		//altera a localidade padrao do sistema
		Locale.setDefault(Locale.US);
		//cria objeto do tipo Scanner o qual permite que ocorram entrada de dados direto do teclado do usu�rio e armazenamento em algum atributo
		Scanner sc = new Scanner(System.in);
		
		//cria formata��o para printar o manufactureDate
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		//cria uma lista do tipo Product
		List<Product> list = new ArrayList<>();
		
		//pergunta quantos produtos
		System.out.println("Enter the number of products:");
		//numProducts recebe a quantidade de produtos que foi informada pelo usu�rio
		int numProducts = sc.nextInt();
		
		for(int i=0; i<numProducts; i++) {
			System.out.println("Product #" + (i+1) + " data: ");
			//pergunta qual o tipo do produto a ser adicionado na lista
			System.out.println("Common, used or imported (c/u/i)?");
			//typeProduct recebe o caracter digitado pelo usu�rio correspondente a algum dos tipos de produto
			char typeProduct = sc.next().charAt(0);
			
			sc.nextLine();
			System.out.println("Name: ");
			//name recebe o nome de um produto
			String name = sc.nextLine();
			System.out.println("Price: ");
			//price recebe o pre�o do produto informado
			double price = sc.nextDouble();
			
			//se o usu�rio tiver informado que o produto � do tipo c(comum) entra no if
			if(typeProduct == 'c') {
				//passa um new Product com os par�metros name e price para a lista
				list.add(new Product(name, price));
			}
			else if(typeProduct == 'u') {
				System.out.println("Manufacture Date (DD/MM/YYYY): ");
				//manufactureDate recebe a data de fabrica��o do produto
				Date manufactureDate = sdf.parse(sc.next());
				//passa um new UsedProduct com os par�metros name, price e manufactureDate para a lista
				list.add(new UsedProduct(name, price, manufactureDate));
			}
			//caso o else if anterior for falso verifica se este � verdadeiro, ou seja, se o usu�rio tiver informado que o produto � i(importado)
			else if(typeProduct == 'i') {
				System.out.println("Customs Fee: ");
				//customsFee recebe a taxa da alf�ndega referente ao produto importado
				double customsFee = sc.nextDouble();
				//passa um new ImportedProduct com os par�metros name, price e customsFee para a lista
				list.add(new ImportedProduct(name, price, customsFee));
			}
		}
		
		////printando cada etiqueta de servi�o conforme cada produto adicionado na list
		System.out.println("PRICE TAGS:");
		//percorre toda a lista
		for(Product x : list) {
			//chama a priceTag conforme o tipo de produto armazenado na list
			System.out.println(x.priceTag());
		}
		
	//encerra o objeto que realiza as entradas de dados direto do teclado	
	sc.close();
	}

}
