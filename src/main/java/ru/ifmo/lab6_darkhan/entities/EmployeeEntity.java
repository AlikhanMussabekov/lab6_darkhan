package ru.ifmo.lab6_darkhan.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "employee", schema = "dbo", catalog = "Darkhan")
public class EmployeeEntity {
	private Integer passportNumber;
	private String surname;
	private String firstName;
	private String patronymic;
	private Date birthDay;
	private Integer workingDays;
	private Integer wage;
	private Collection<CattleEntity> cattlesByPassportNumber;
	private Collection<FowlEntity> fowlsByPassportNumber;

	@Id
	@Column(name = "PassportNumber", nullable = false)
	public Integer getPassportNumber() {
		return passportNumber;
	}

	public void setPassportNumber(Integer passportNumber) {
		this.passportNumber = passportNumber;
	}

	@Basic
	@Column(name = "Surname", nullable = false, length = 50)
	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	@Basic
	@Column(name = "FirstName", nullable = false, length = 50)
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Basic
	@Column(name = "Patronymic", nullable = true, length = 50)
	public String getPatronymic() {
		return patronymic;
	}

	public void setPatronymic(String patronymic) {
		this.patronymic = patronymic;
	}

	@Basic
	@Column(name = "BirthDay", nullable = false)
	public Date getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}

	@Basic
	@Column(name = "WorkingDays", nullable = true)
	public Integer getWorkingDays() {
		return workingDays;
	}

	public void setWorkingDays(Integer workingDays) {
		this.workingDays = workingDays;
	}

	@Basic
	@Column(name = "Wage", nullable = false)
	public Integer getWage() {
		return wage;
	}

	public void setWage(Integer wage) {
		this.wage = wage;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		EmployeeEntity that = (EmployeeEntity) o;
		return Objects.equals(passportNumber, that.passportNumber) &&
				Objects.equals(surname, that.surname) &&
				Objects.equals(firstName, that.firstName) &&
				Objects.equals(patronymic, that.patronymic) &&
				Objects.equals(birthDay, that.birthDay) &&
				Objects.equals(workingDays, that.workingDays) &&
				Objects.equals(wage, that.wage);
	}

	@Override
	public int hashCode() {
		return Objects.hash(passportNumber, surname, firstName, patronymic, birthDay, workingDays, wage);
	}

	@OneToMany(mappedBy = "employeeByEmployeeId")
	public Collection<CattleEntity> getCattlesByPassportNumber() {
		return cattlesByPassportNumber;
	}

	public void setCattlesByPassportNumber(Collection<CattleEntity> cattlesByPassportNumber) {
		this.cattlesByPassportNumber = cattlesByPassportNumber;
	}

	@OneToMany(mappedBy = "employeeByEmployeeId")
	public Collection<FowlEntity> getFowlsByPassportNumber() {
		return fowlsByPassportNumber;
	}

	public void setFowlsByPassportNumber(Collection<FowlEntity> fowlsByPassportNumber) {
		this.fowlsByPassportNumber = fowlsByPassportNumber;
	}
}
