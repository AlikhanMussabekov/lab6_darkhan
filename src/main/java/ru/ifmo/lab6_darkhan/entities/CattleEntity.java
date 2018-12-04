package ru.ifmo.lab6_darkhan.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "cattle", schema = "dbo", catalog = "Darkhan")
public class CattleEntity {
	private Integer tagNumber;
	private String cattleType;
	private Byte age;
	private Integer veterinaryPassport;
	private Boolean vaccination;
	private Boolean reproduction;
	private String comment;
	private EmployeeEntity employeeByEmployeeId;
	private Collection<SaleEntity> salesByTagNumber;

	@Id
	@Column(name = "TagNumber", nullable = false)
	public Integer getTagNumber() {
		return tagNumber;
	}

	public void setTagNumber(Integer tagNumber) {
		this.tagNumber = tagNumber;
	}

	@Basic
	@Column(name = "CattleType", nullable = true, length = 60)
	public String getCattleType() {
		return cattleType;
	}

	public void setCattleType(String cattleType) {
		this.cattleType = cattleType;
	}

	@Basic
	@Column(name = "Age", nullable = false)
	public Byte getAge() {
		return age;
	}

	public void setAge(Byte age) {
		this.age = age;
	}

	@Basic
	@Column(name = "VeterinaryPassport", nullable = false)
	public Integer getVeterinaryPassport() {
		return veterinaryPassport;
	}

	public void setVeterinaryPassport(Integer veterinaryPassport) {
		this.veterinaryPassport = veterinaryPassport;
	}

	@Basic
	@Column(name = "Vaccination", nullable = false)
	public Boolean getVaccination() {
		return vaccination;
	}

	public void setVaccination(Boolean vaccination) {
		this.vaccination = vaccination;
	}

	@Basic
	@Column(name = "Reproduction", nullable = true)
	public Boolean getReproduction() {
		return reproduction;
	}

	public void setReproduction(Boolean reproduction) {
		this.reproduction = reproduction;
	}

	@Basic
	@Column(name = "Comment", nullable = true, length = -1)
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		CattleEntity that = (CattleEntity) o;
		return Objects.equals(tagNumber, that.tagNumber) &&
				Objects.equals(cattleType, that.cattleType) &&
				Objects.equals(age, that.age) &&
				Objects.equals(veterinaryPassport, that.veterinaryPassport) &&
				Objects.equals(vaccination, that.vaccination) &&
				Objects.equals(reproduction, that.reproduction) &&
				Objects.equals(comment, that.comment);
	}

	@Override
	public int hashCode() {
		return Objects.hash(tagNumber, cattleType, age, veterinaryPassport, vaccination, reproduction, comment);
	}

	@ManyToOne
	@JoinColumn(name = "EmployeeID", referencedColumnName = "PassportNumber")
	public EmployeeEntity getEmployeeByEmployeeId() {
		return employeeByEmployeeId;
	}

	public void setEmployeeByEmployeeId(EmployeeEntity employeeByEmployeeId) {
		this.employeeByEmployeeId = employeeByEmployeeId;
	}

	@OneToMany(mappedBy = "cattleByCattleId")
	public Collection<SaleEntity> getSalesByTagNumber() {
		return salesByTagNumber;
	}

	public void setSalesByTagNumber(Collection<SaleEntity> salesByTagNumber) {
		this.salesByTagNumber = salesByTagNumber;
	}
}
