package go.zup.xyinc.utils;

import go.zup.xyinc.PontoInteresse.PontoInteresse;

public class CartesianoUtils {
	
	public static Double getDistancia(PontoInteresse poi1, PontoInteresse poi2) {
		return Math.abs(Math.sqrt( (Math.pow(poi2.getCoordenadaX() - poi1.getCoordenadaX(), 2) +  
									(Math.pow(poi2.getCoordenadaY() - poi1.getCoordenadaY(), 2)))));
	}
	
}
