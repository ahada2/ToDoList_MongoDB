package com.springboot.todo;


import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="todos")
public class TodoDTO {
	@Id
	private String id;
	
	@NotNull(message="cannot be null")
	private String todo;
	private String description;
	
	@NotNull(message="cannot be null")
	private Boolean completed;
}
