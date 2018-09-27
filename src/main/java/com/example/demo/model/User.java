package com.example.demo.model;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@Builder
public class User {

	@Id
	private String id;
	@NonNull
	private String firstName;
	@NonNull
	private String lastName;

}
