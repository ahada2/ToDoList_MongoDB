package com.springboot.todo;

import java.util.List;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoController {
	
	@Autowired
	private TodoRespository rep;
	
	@Autowired
	private TodoService service;

	@GetMapping("/todos")
	public ResponseEntity<?> getAll() {
		List<TodoDTO> todos = rep.findAll();
		return new ResponseEntity<List<TodoDTO>>(todos, HttpStatus.OK);
	}
	
	@PostMapping("/add_todos")
	public ResponseEntity<?> createTodo(@RequestBody TodoDTO todo) {
		try {
			service.createTodo_service(todo);
			return new ResponseEntity<TodoDTO>(todo, HttpStatus.OK);
			
		} catch (ConstraintViolationException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
			
		} catch (TodoCollectionException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
		}
		
	}
}
