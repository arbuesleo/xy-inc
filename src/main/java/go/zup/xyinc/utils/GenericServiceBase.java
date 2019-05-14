package go.zup.xyinc.utils;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping(consumes = "application/json", produces = "application/json")
public class GenericServiceBase <T extends EntityBase<ID>, ID extends Serializable>{

	@Autowired
	protected JpaRepository<T, ID> genericRepository;	
	
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Object> findAll() {
		return new ResponseEntity<Object>(this.genericRepository.findAll(), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> insert(@RequestBody @Validated T entity) {
		
		entity.setId(null);

		try {
			this.genericRepository.save(entity);
			
			Message<T> returnMsg = new Message<>();
			returnMsg.setData(entity);
			returnMsg.addField("message", "Registro inserido com suceso!");
			
			return ResponseEntity.status(HttpStatus.OK).body(returnMsg);
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(ServiceHelper.buildErrorResponse("Erro ao inserir registro.", e.getMessage()));
		}
		
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<?> update(@RequestBody @Validated T entity) {
		
		Message<T> returnMsg;
		
		if (entity.getId() == null) {
			returnMsg = ServiceHelper.buildErrorResponse("Id não pode ser nulo.", "Informe um registro já cadastrado para a edição.");
			returnMsg.setData(entity);
			return ResponseEntity.status(HttpStatus.CONFLICT).body(returnMsg);
		}

		try {
			
			this.genericRepository.save(entity);
			returnMsg = new Message<T>();
			returnMsg.addField("mensage", "Editado com sucesso");
			returnMsg.setData(entity);			
			return ResponseEntity.status(HttpStatus.OK).body(returnMsg);
			
		}  catch (Exception e) {
			
			returnMsg = ServiceHelper.buildErrorResponse("Eerro ao atualizar registro.", e.getMessage());

		}

		return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(returnMsg);
	}

	@RequestMapping(method = RequestMethod.DELETE)
	public ResponseEntity<?> delete(@RequestBody T entity) {
		Message<T> returnMsg = new Message<>();
		
		try {
			this.genericRepository.delete(entity);
			
			returnMsg.addField("statusError", "success");
			returnMsg.addField("message", " Deletado com sucesso");

			return ResponseEntity.status(HttpStatus.OK).body(returnMsg);

		} catch (Exception e) {
			returnMsg = ServiceHelper.buildErrorResponse("Erro ao remover regostro.", e.getMessage());
		}

		return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(returnMsg);
	}
	
	

}
