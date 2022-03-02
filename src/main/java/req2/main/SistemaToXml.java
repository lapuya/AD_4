package req2.main;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import req2.beans.DatosPlanetarios;
import req2.beans.Planeta;
import req2.beans.Sistema;



public class SistemaToXml {
	public static void main(String[] args) {

		JAXBContext contexto;
		try {
			contexto = JAXBContext.newInstance(Sistema.class);
		} catch (JAXBException e) {
			System.out.println("Error creando el contexto");
			e.printStackTrace();			
			return;
		}

		Marshaller m;
		try {
			m = contexto.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			Sistema sistema = new Sistema();
			sistema.setGalaxia("Via Láctea");
			sistema.setNombre("Sistema Solar");
			
			sistema.getPlanetas().add(new Planeta("La Tierra", "Rocoso", 1, 0.00001581));
			sistema.getPlanetas().add(new Planeta("Júpiter", "Gaseoso", 79, 0.000078792));
			sistema.getPlanetas().add(new Planeta("Marte", "Rocoso", 2, 0.000023201));
			sistema.getPlanetas().add(new Planeta("Neptuno", "Gaseoso", 14, 0.00047296));
			sistema.getPlanetas().add(new Planeta("Mercurio", "Rocoso", 0, 0.0000073728));
			sistema.getPlanetas().add(new Planeta("Venus", "Rocoso", 0, 0.000011401));
			
			DatosPlanetarios dp = new DatosPlanetarios();
			dp.setDuracionDia("24h");
			dp.setGravedad(9.8);
			dp.setRadio(6371);
			sistema.getPlanetas().get(0).setDatosPlanetarios(dp);
			
			//jupiter
			dp.setDuracionDia("0d 9h 56m");
			dp.setGravedad(24.79);
			dp.setRadio(69911);
			sistema.getPlanetas().get(1).setDatosPlanetarios(dp);
			//marte
			dp.setDuracionDia("1d 0h 37m");
			dp.setGravedad(3.721);
			dp.setRadio(3389.5);
			sistema.getPlanetas().get(2).setDatosPlanetarios(dp);
			
			dp.setDuracionDia("0d 16h 6m");
			dp.setGravedad(11.15);
			dp.setRadio(24622);
			sistema.getPlanetas().get(3).setDatosPlanetarios(dp);
			
			dp.setDuracionDia("58d 15h 30m");
			dp.setGravedad(3.7);
			dp.setRadio(2439.7);
			sistema.getPlanetas().get(4).setDatosPlanetarios(dp);
			
			dp.setDuracionDia("116d 18h 0m");
			dp.setGravedad(8.87);
			dp.setRadio(6051.8);
			sistema.getPlanetas().get(5).setDatosPlanetarios(dp);


			

			m.marshal(sistema, new File("sistema_solar.xml"));
			System.out.println("El archivo sistema_solar.xml ha sido creado con exito");
		} catch (JAXBException e) {
			System.out.println("Error convertiendo el objeto a formato XML");
			e.printStackTrace();
		}
	}
}