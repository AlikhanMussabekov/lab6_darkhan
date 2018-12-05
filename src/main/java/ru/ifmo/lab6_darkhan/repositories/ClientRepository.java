package ru.ifmo.lab6_darkhan.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.ifmo.lab6_darkhan.entities.ClientEntity;

import java.util.List;

@Repository
public interface ClientRepository extends CrudRepository<ClientEntity, Long> {
	@Query("select companyName from ClientEntity")
	public List<String> selectCompanyNames();
}
