package com.redsky.project.util;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Util {

	public String getState(Object object) {
		ObjectMapper mapper = new ObjectMapper();
		// mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		String jsonInString = "";
		try {
			jsonInString = mapper.writeValueAsString(object);
			mapper.setVisibility(PropertyAccessor.ALL, Visibility.ANY);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return jsonInString;
	}
}
