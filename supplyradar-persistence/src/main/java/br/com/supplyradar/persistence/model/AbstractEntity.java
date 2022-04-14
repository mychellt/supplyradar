package br.com.supplyradar.persistence.model;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.LocalDateTime;

@MappedSuperclass
public abstract class AbstractEntity<T> implements Serializable {

	private static final long serialVersionUID = 1L;

	public abstract T getId();

	public abstract void setId(T id);

	@Column(name = "ativo", nullable = false, columnDefinition = "boolean default true")
	private boolean ativo;

	@Column(updatable = false, name = "date_of_create")
	@CreatedDate
	private LocalDateTime dateOfCreate;

	@Column(updatable = false, name = "date_of_change")
	@LastModifiedDate
	private LocalDateTime dateOfChange;

	public LocalDateTime getDateOfCreate() {
		return this.dateOfCreate;
	}

	public void setDateOfCreate(LocalDateTime dateOfCreate) {
		this.dateOfCreate = dateOfCreate;
	}

	public LocalDateTime getDateOfChange() {
		return dateOfChange;
	}

	public void setDateOfChange(LocalDateTime dateOfChange) {
		this.dateOfChange = dateOfChange;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

}
