package utils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ComprobarProductos {

	public static Timestamp transformarFecha(String fecha) {

		Timestamp timestamp = null;
		Date d = null;
		try {
			

			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		
			d = formatter.parse(fecha);
			
			timestamp = new java.sql.Timestamp(d.getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	
		return timestamp;
	}

}
