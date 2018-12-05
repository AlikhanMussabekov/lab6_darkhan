package ru.ifmo.lab6_darkhan.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.ifmo.lab6_darkhan.entities.ClientEntity;
import ru.ifmo.lab6_darkhan.entities.InvoiceEntity;

import java.util.List;

@Repository
public interface InvoiceRepository extends CrudRepository<InvoiceEntity, Long> {

	@Query("select distinct clientByClientNumber from InvoiceEntity ")
	public List<ClientEntity> selectDisctinctClient();

	public List<InvoiceEntity> findAllByClientByClientNumber(ClientEntity clientEntity);

}
