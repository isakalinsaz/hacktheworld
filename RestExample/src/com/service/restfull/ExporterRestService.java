package com.service.restfull;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.service.controller.ExportService;
import com.service.model.RestObject;

@Component
@Path(value = "/exporter")
public class ExporterRestService {

	@Autowired
	ExportService exportServiceImpl;

	@GET
	public Response getResponse() {

		String result = exportServiceImpl.makeRequest();
		return Response.status(200).entity(result).build();
	}

	
	@GET
	@Path(value="{value}")
	@Produces("application/json")
	public String generateJsonValue(@PathParam("value") Integer param) throws JsonProcessingException {

		RestObject jsonObject = new RestObject();
		jsonObject.setId(param);
		jsonObject.setValue(String.valueOf(Math.random()));

		ObjectMapper mapper = new ObjectMapper();
		String prettyObject = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonObject);
		System.out.println(prettyObject);
		return prettyObject;
	}
}
