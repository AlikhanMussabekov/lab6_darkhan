package ru.ifmo.lab6_darkhan.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "client", schema = "dbo", catalog = "Darkhan")
public class ClientEntity {
	private Integer clientNumber;
	private String companyName;
	private Collection<InvoiceEntity> invoicesByClientNumber;

	@Id
	@Column(name = "ClientNumber", nullable = false)
	public Integer getClientNumber() {
		return clientNumber;
	}

	public void setClientNumber(Integer clientNumber) {
		this.clientNumber = clientNumber;
	}

	@Basic
	@Column(name = "CompanyName", nullable = true, length = 100)
	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	@OneToMany(mappedBy = "clientByClientNumber")
	public Collection<InvoiceEntity> getInvoicesByClientNumber() {
		return invoicesByClientNumber;
	}

	public void setInvoicesByClientNumber(Collection<InvoiceEntity> invoicesByClientNumber) {
		this.invoicesByClientNumber = invoicesByClientNumber;
	}
}
