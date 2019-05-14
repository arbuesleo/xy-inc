package go.zup.xyinc.PontoInteresse;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import go.zup.xyinc.utils.CartesianoUtils;
import go.zup.xyinc.utils.GenericServiceBase;
import go.zup.xyinc.utils.PathMap;

@RestController
@RequestMapping(path = PathMap.PONTO_INTERESSE)
public class PontoInteresseService extends GenericServiceBase<PontoInteresse, Long> {
	
	@Autowired
	PontoInteresseRepositorio poiRepo;
	
	@RequestMapping(method = RequestMethod.GET, path = "/pesquisaPorProximidade")
	public ResponseEntity<Object> pesquisaPorProximidade(@RequestParam Integer cooX, @RequestParam Integer cooY, @RequestParam Integer DMax) {
		
		PontoInteresse posAtual = new PontoInteresse(cooX, cooY);
		List<PontoInteresse> pois = poiRepo.findAll();		
		Iterator<PontoInteresse> ite = pois.iterator();
		
		List<PontoInteresse> poisResult = new ArrayList<>();
		
		while (ite.hasNext()) {
			PontoInteresse poiDestino = ite.next();
			if(CartesianoUtils.getDistancia(posAtual, poiDestino).compareTo(new Double(DMax)) <= 0) {
				poisResult.add(poiDestino);
			}
		}
		
		return new ResponseEntity<Object>(poisResult, HttpStatus.OK);
	}

}
