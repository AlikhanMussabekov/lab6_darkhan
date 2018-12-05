package ru.ifmo.lab6_darkhan.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.ifmo.lab6_darkhan.entities.SaleEntity;

import java.util.List;

@Repository
public interface SaleRepository extends CrudRepository<SaleEntity, Long> {

	/*@Query("select animalType from SaleEntity join invoiceByInvoiceNumber where animalType='123'")
	public List<String> selectAll();
*/}
