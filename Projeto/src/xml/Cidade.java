package xml;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
@XmlRootElement(name = "cidade")
@XmlType(propOrder = {"nome", "uf", "id"})
public class Cidade {
	@Override
	public String toString() {
		return "Cidade [id=" + id + ", nome=" + nome + ", uf=" + uf + "]";
	}
	public Integer getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}
	public String getUf() {
		return uf;
	}
	@XmlElement(name = "id")
	private Integer id;
	@XmlElement(name = "nome")
	private String nome;
	@XmlElement(name = "uf")
	private String uf;
	
	public String getXMLCidade(String cidade) throws Exception {
		String charset = java.nio.charset.StandardCharsets.ISO_8859_1.name();
		String linha, resultado = "";
		String urlListaCidade = "http://servicos.cptec.inpe.br/XML/listaCidades?city=%s";
		/* codifica os par�metros */
		String parametro = String.format(urlListaCidade, URLEncoder.encode(cidade, charset) );
		URL url = new URL(parametro);
		URLConnection conexao = url.openConnection();
		BufferedReader reader = new BufferedReader(new InputStreamReader(conexao.getInputStream()));
		while((linha = reader.readLine()) != null){
		resultado += linha;
		}
		return resultado;
		}
	public Cidade[] xmlToObjectCidade(String xml) throws Exception {
		StringReader sr = new StringReader(xml);
		/* a base do XML � uma marca��o de nome cidades */
		JAXBContext context = JAXBContext.newInstance(Cidades.class);
		Unmarshaller un = context.createUnmarshaller();
		Cidades cidades = (Cidades) un.unmarshal(sr);
		return cidades.getCidade();
		}

	
	
}
