package ru.ifmo.lab6_darkhan.entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "invoice", schema = "dbo", catalog = "Darkhan")
public class InvoiceEntity {
	private Integer invoiceNumber;
	private Integer price;
	private Date purchaceDate;
	private ClientEntity clientByClientNumber;
	private Collection<SaleEntity> salesByInvoiceNumber;

	@Id
	@Column(name = "InvoiceNumber", nullable = false)
	public Integer getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(Integer invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	@Basic
	@Column(name = "Price", nullable = false)
	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	@Basic
	@Column(name = "PurchaceDate", nullable = true)
	public Date getPurchaceDate() {
		return purchaceDate;
	}

	public void setPurchaceDate(Date purchaceDate) {
		this.purchaceDate = purchaceDate;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		InvoiceEntity that = (InvoiceEntity) o;
		return Objects.equals(invoiceNumber, that.invoiceNumber) &&
				Objects.equals(price, that.price) &&
				Objects.equals(purchaceDate, that.purchaceDate);
	}

	@Override
	public int hashCode() {
		return Objects.hash(invoiceNumber, price, purchaceDate);
	}

	@ManyToOne
	@JoinColumn(name = "ClientNumber", referencedColumnName = "ClientNumber", nullable = false)
	public ClientEntity getClientByClientNumber() {
		return clientByClientNumber;
	}

	public void setClientByClientNumber(ClientEntity clientByClientNumber) {
		this.clientByClientNumber = clientByClientNumber;
	}

	@OneToMany(mappedBy = "invoiceByInvoiceNumber")
	public Collection<SaleEntity> getSalesByInvoiceNumber() {
		return salesByInvoiceNumber;
	}

	public void setSalesByInvoiceNumber(Collection<SaleEntity> salesByInvoiceNumber) {
		this.salesByInvoiceNumber = salesByInvoiceNumber;
	}
}
