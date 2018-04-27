package xml;

import java.util.Arrays;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "cidades")
@XmlType(propOrder = {"cidade"})
public class Cidades {
	@Override
	public String toString() {
		return "Cidades [cidade=" + Arrays.toString(cidade) + "]";
	}

	public Cidade[] getCidade() {
		return cidade;
	}


	@XmlElement
	private Cidade[] cidade;
}