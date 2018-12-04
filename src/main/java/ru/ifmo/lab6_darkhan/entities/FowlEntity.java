package ru.ifmo.lab6_darkhan.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "fowl", schema = "dbo", catalog = "Darkhan")
public class FowlEntity {
	private Integer id;
	private String fowlType;
	private Short age;
	private Boolean reproduction;
	private EmployeeEntity employeeByEmployeeId;
	private Collection<SaleEntity> salesById;

	@Id
	@Column(name = "ID", nullable = false)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	@Basic
	@Column(name = "FowlType", nullable = true, length = 60)
	public String getFowlType() {
		return fowlType;
	}

	public void setFowlType(String fowlType) {
		this.fowlType = fowlType;
	}

	@Basic
	@Column(name = "Age", nullable = false)
	public Short getAge() {
		return age;
	}

	public void setAge(Short age) {
		this.age = age;
	}

	@Basic
	@Column(name = "Reproduction", nullable = true)
	public Boolean getReproduction() {
		return reproduction;
	}

	public void setReproduction(Boolean reproduction) {
		this.reproduction = reproduction;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		FowlEntity that = (FowlEntity) o;
		return Objects.equals(id, that.id) &&
				Objects.equals(fowlType, that.fowlType) &&
				Objects.equals(age, that.age) &&
				Objects.equals(reproduction, that.reproduction);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, fowlType, age, reproduction);
	}

	@ManyToOne
	@JoinColumn(name = "EmployeeID", referencedColumnName = "PassportNumber")
	public EmployeeEntity getEmployeeByEmployeeId() {
		return employeeByEmployeeId;
	}

	public void setEmployeeByEmployeeId(EmployeeEntity employeeByEmployeeId) {
		this.employeeByEmployeeId = employeeByEmployeeId;
	}

	@OneToMany(mappedBy = "fowlByFowlId")
	public Collection<SaleEntity> getSalesById() {
		return salesById;
	}

	public void setSalesById(Collection<SaleEntity> salesById) {
		this.salesById = salesById;
	}
}
