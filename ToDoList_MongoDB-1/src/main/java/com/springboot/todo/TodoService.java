package com.springboot.todo;

import java.util.Optional;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {
	
	@Autowired
	private TodoRespository rep;
	
	public void createTodo_service(TodoDTO todo) throws ConstraintViolationException, TodoCollectionException {
		Optional<TodoDTO> exists_todo = rep.findByName(todo.getTodo());
		if (exists_todo.isPresent()) {
			throw new TodoCollectionException(TodoCollectionException.allreadyExists());
		}
		else {
			rep.save(todo);
		}
	}
}
