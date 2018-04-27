package pacote;

import xml.Cidade;

public class Main {

	public static void main(String[] args) throws Exception {
		Cidade c = new Cidade();
		String r = c.getXMLCidade("cascalho");
		System.out.println(r);

	}

}
