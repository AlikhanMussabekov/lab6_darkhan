package ru.ifmo.lab6_darkhan.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.ifmo.lab6_darkhan.entities.EmployeeEntity;

@Repository
public interface EmployeeRepository extends CrudRepository<EmployeeEntity,Long> {
}
