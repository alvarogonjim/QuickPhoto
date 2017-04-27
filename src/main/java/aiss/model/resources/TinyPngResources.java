package aiss.model.resources;

import java.io.IOException;

import com.tinify.Source;
import com.tinify.Tinify;

public class TinyPngResources {

	
	
	
	public TinyPngResources() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int comprimirFoto(String url){
	Tinify.setKey("ZbGbVDVmQHjZSFcDRLPcmUBMI29bQTCC");
	Source source;
	try {
		//Tomamos la imagen de una url que le pasamos por parametro y la comprimimos
		source = Tinify.fromUrl(url);
		System.out.print("Se ha enviado la imagen");
		//El resultado lo pasamos otra vez 
		source.toFile("optimized.jpg");
		System.out.println("Se ha guardado la imagen");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	
	}
	
	return Tinify.compressionCount();
	
	}
	
	
}
