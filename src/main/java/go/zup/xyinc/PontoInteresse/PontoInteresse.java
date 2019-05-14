package go.zup.xyinc.PontoInteresse;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import go.zup.xyinc.utils.EntityBase;

@Entity
@Table
public class PontoInteresse extends EntityBase<Long>{
	
	@Column(nullable = false, length = 250)
	private String descricao;
	
	@Column(nullable = false)
	private Integer coordenadaX;
	
	@Column(nullable = false)
	private Integer coordenadaY;
	

	public PontoInteresse() {
	}

	public PontoInteresse(String descricao, Integer corodenadaX, Integer corodenadaY) {
		super();
		this.descricao = descricao;
		this.coordenadaX = corodenadaX;
		this.coordenadaY = corodenadaY;
	}
	
	public PontoInteresse(Integer corodenadaX, Integer corodenadaY) {
		super();
		this.coordenadaX = corodenadaX;
		this.coordenadaY = corodenadaY;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getCoordenadaX() {
		return coordenadaX;
	}

	public void setCoordenadaX(Integer corodenadaX) {
		this.coordenadaX = corodenadaX;
	}

	public Integer getCoordenadaY() {
		return coordenadaY;
	}

	public void setCoordenadaY(Integer corodenadaY) {
		this.coordenadaY = corodenadaY;
	}
}
