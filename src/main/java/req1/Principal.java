package req1;
import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class Principal {

	public static void main(String[] args) {
		DocumentBuilderFactory fabrica = DocumentBuilderFactory.newInstance();
		DocumentBuilder analizador;
		Document doc;
		
		try {
			analizador = fabrica.newDocumentBuilder();
			doc = analizador.newDocument();

			Element concierto = doc.createElement("concierto");
			doc.appendChild(concierto);
			//Creamos fecha
			Element fecha = doc.createElement("fecha");
			Text textoFecha = doc.createTextNode("20-oct-2028");
			fecha.appendChild(textoFecha);
			concierto.appendChild(fecha);
			//Creamos hora
			Element hora = doc.createElement("hora");
			Text textoHora = doc.createTextNode("21:30");
			hora.appendChild(textoHora);
			concierto.appendChild(hora);
			//añadimos participantes
			
			añadirParticipantes(concierto, doc);

			guardar(doc);
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	private static void guardar(Document doc) throws TransformerException {
		//fabrica de Transformes
		TransformerFactory fabricaConversor = TransformerFactory.newInstance();
		//creamos el objeto Transfomer, que nos permitira serializar el arbol
		//dom a un fichero
		Transformer conversor = fabricaConversor.newTransformer();
		//creamos la fuente de la cual sacaremos el arbol dom
		DOMSource fuente = new DOMSource(doc); 
		//Creamos el flujo de salida, al fichero que queremos (tubito)
		StreamResult resultado = new StreamResult(new File("concierto.xml"));
		//por ultimo, serializamos los datos
		conversor.transform(fuente, resultado);
	}

	private static void añadirParticipantes(Element concierto, Document doc) {
		// TODO Auto-generated method stub
		
		Element participantes = doc.createElement("participantes");
		
		//Primer participante
		Element participante = doc.createElement("participante");
		participantes.appendChild(participante);
		Element entrada = doc.createElement("entrada");
		Text textoEntrada = doc.createTextNode("21:30");
		entrada.appendChild(textoEntrada);
		participante.appendChild(entrada);
		
		Element grupo = doc.createElement("grupo");
		Text grupoTexto = doc.createTextNode("Las Ardillas de Dakota");
		
		grupo.appendChild(grupoTexto);
		participante.appendChild(grupo);
		
		
		//Segundo participante
		participante = doc.createElement("participante");
		participantes.appendChild(participante);
		entrada = doc.createElement("entrada");
		textoEntrada = doc.createTextNode("22:15");
		entrada.appendChild(textoEntrada);
		participante.appendChild(entrada);
		
		grupo = doc.createElement("grupo");
		grupoTexto = doc.createTextNode("Fito y Fitipaldis");
		grupo.appendChild(grupoTexto);
		participante.appendChild(grupo);
		
		participante = doc.createElement("participante");
		participantes.appendChild(participante);
		entrada = doc.createElement("entrada");
		textoEntrada = doc.createTextNode("23:00");
		entrada.appendChild(textoEntrada);
		participante.appendChild(entrada);
		
		grupo = doc.createElement("grupo");
		grupoTexto = doc.createTextNode("ColdPlay");
		grupo.appendChild(grupoTexto);
		participante.appendChild(grupo);
		
		concierto.appendChild(participantes);
		
		
	}
}