package xml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "cidades")
@XmlType(propOrder = {"cidade"})
public class Cidades {
	public Cidade[] getCidade() {
		return cidade;
	}

	public void setCidade(Cidade[] cidade) {
		this.cidade = cidade;
	}

	@XmlElement
	private Cidade[] cidade;
}