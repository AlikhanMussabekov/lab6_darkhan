package ru.ifmo.lab6_darkhan.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "sale", schema = "dbo", catalog = "Darkhan")
public class SaleEntity {
	private String animalType;
	private String nameOfPurchasedProduct;
	private Integer pricePerKilogram;
	private Integer productWeight;
	private Integer quantity;
	private InvoiceEntity invoiceByInvoiceNumber;
	private FowlEntity fowlByFowlId;
	private CattleEntity cattleByCattleId;

	@Basic
	@Column(name = "AnimalType", nullable = false, length = 60)
	public String getAnimalType() {
		return animalType;
	}

	public void setAnimalType(String animalType) {
		this.animalType = animalType;
	}

	@Basic
	@Column(name = "NameOfPurchasedProduct", nullable = false, length = -1)
	public String getNameOfPurchasedProduct() {
		return nameOfPurchasedProduct;
	}

	public void setNameOfPurchasedProduct(String nameOfPurchasedProduct) {
		this.nameOfPurchasedProduct = nameOfPurchasedProduct;
	}

	@Basic
	@Column(name = "PricePerKilogram", nullable = false)
	public Integer getPricePerKilogram() {
		return pricePerKilogram;
	}

	public void setPricePerKilogram(Integer pricePerKilogram) {
		this.pricePerKilogram = pricePerKilogram;
	}

	@Basic
	@Column(name = "ProductWeight", nullable = false)
	public Integer getProductWeight() {
		return productWeight;
	}

	public void setProductWeight(Integer productWeight) {
		this.productWeight = productWeight;
	}

	@Basic
	@Column(name = "Quantity", nullable = false)
	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		SaleEntity that = (SaleEntity) o;
		return
				Objects.equals(animalType, that.animalType) &&
				Objects.equals(nameOfPurchasedProduct, that.nameOfPurchasedProduct) &&
				Objects.equals(pricePerKilogram, that.pricePerKilogram) &&
				Objects.equals(productWeight, that.productWeight) &&
				Objects.equals(quantity, that.quantity);
	}

	@Override
	public int hashCode() {
		return Objects.hash(  animalType, nameOfPurchasedProduct, pricePerKilogram, productWeight, quantity);
	}

	@ManyToOne
	@JoinColumn(name = "InvoiceNumber", referencedColumnName = "InvoiceNumber")
	public InvoiceEntity getInvoiceByInvoiceNumber() {
		return invoiceByInvoiceNumber;
	}

	public void setInvoiceByInvoiceNumber(InvoiceEntity invoiceByInvoiceNumber) {
		this.invoiceByInvoiceNumber = invoiceByInvoiceNumber;
	}

	@ManyToOne
	@JoinColumn(name = "FowlID", referencedColumnName = "ID")
	public FowlEntity getFowlByFowlId() {
		return fowlByFowlId;
	}

	public void setFowlByFowlId(FowlEntity fowlByFowlId) {
		this.fowlByFowlId = fowlByFowlId;
	}

	@ManyToOne
	@JoinColumn(name = "CattleID", referencedColumnName = "TagNumber")
	public CattleEntity getCattleByCattleId() {
		return cattleByCattleId;
	}

	public void setCattleByCattleId(CattleEntity cattleByCattleId) {
		this.cattleByCattleId = cattleByCattleId;
	}

	private String id;

	@Id
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
