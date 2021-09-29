package com.tcc.easynutri.model.dto;

import java.io.Serializable;
import java.util.Objects;

public abstract class DtoBase implements Serializable {

	private static final long serialVersionUID = 1L;
	
	protected Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DtoBase other = (DtoBase) obj;
		return Objects.equals(id, other.id);
	}
	
	

}
