package go.zup.xyinc.utils;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.springframework.data.domain.Persistable;
import org.springframework.lang.Nullable;

import com.fasterxml.jackson.annotation.JsonIgnore;

@MappedSuperclass
public class EntityBase <PK> implements Persistable<PK>{

	private static final long serialVersionUID = -5554308939380869754L;

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Nullable 
	private PK id;
	
	@Override
	public PK getId() {
		return id;
	}
	
	public void setId(PK id) {
		this.id = id;
	}

	@Override
	@JsonIgnore
	public boolean isNew() {
		return null == getId();
	}
}
