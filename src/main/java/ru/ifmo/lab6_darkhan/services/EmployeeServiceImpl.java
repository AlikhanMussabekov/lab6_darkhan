package ru.ifmo.lab6_darkhan.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ifmo.lab6_darkhan.repositories.EmployeeRepository;
import ru.ifmo.lab6_darkhan.services.interfaces.EmployeeService;

import java.util.*;
import java.util.concurrent.TimeUnit;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private final EmployeeRepository repository;

	@Autowired
	public EmployeeServiceImpl(EmployeeRepository repository) {
		this.repository = repository;
	}

	@Override
	public HashMap<String, Object> getSalaryAndAge() {

		HashMap<String, Object> main = new HashMap<>();
		HashMap<Integer, Integer> ageSalary = new HashMap<>();
		List<Integer> salary = new ArrayList<>();

		Date today = new Date();

		repository.findAll().forEach(s -> {

			long difference = TimeUnit.DAYS.
					convert( today.getTime() - s.getBirthDay().getTime(),TimeUnit.MILLISECONDS);

			Integer age = (int) (difference/365);

			if (ageSalary.get(age) != null ){
				Integer med = ageSalary.get(age);
				 med += s.getWage();
				 med /=2;
				 ageSalary.put(age,med);
			}else {
				ageSalary.put(age, s.getWage());
			}

		});

		List<Integer> labels = new ArrayList<>(ageSalary.keySet());
		labels.forEach(s -> {
			salary.add(ageSalary.get(s));
		});

		main.put("labels", labels);
		main.put("data", salary);
		main.put("name", "График возраста и зарплаты");

		return main;
	}

	@Override
	public List<String> getEmployeesInfo() {

		List<String> list = new ArrayList<>();

		repository.findAll().forEach(s ->{
			list.add(s.getSurname() + " " + s.getFirstName() + " " + s.getPatronymic());
		});

		return list;
	}
}
