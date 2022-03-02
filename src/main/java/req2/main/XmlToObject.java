package req2.main;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import req2.beans.Planeta;
import req2.beans.Sistema;


public class XmlToObject {
	public static void main(String[] args) {
		try {
			JAXBContext contexto = JAXBContext.newInstance(Sistema.class);
			//Esta vez creamos un objeto que nos permite pasar
			//de XML a Object, es decir deserializar
			Unmarshaller u = contexto.createUnmarshaller();
			File fichero = new File("sistema_solar.xml");
			if (fichero.exists()) {
				Sistema s = (Sistema) u.unmarshal(fichero);

				System.out.println("Nombre de la Galaxia: " + s.getGalaxia());
				System.out.println("Nombre del Sistema: " + s.getNombre());
				System.out.println("--------- PLANETAS QUE LO FORMAN ---------");
				for(Planeta p : s.getPlanetas()) 
					System.out.println(p);

			} else {
				System.out.println("Fichero XML Homer.xml no encontrado");
			}

		} catch (JAXBException e) {
			System.out.println(e.getMessage());
		}
	}
}