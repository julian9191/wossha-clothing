package com.wossha.clothing.infrastructure.services;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class SimpleWosshaGrantedAuthorityMixin {

	@JsonCreator
	public SimpleWosshaGrantedAuthorityMixin(@JsonProperty("authority") String role) {}

}
