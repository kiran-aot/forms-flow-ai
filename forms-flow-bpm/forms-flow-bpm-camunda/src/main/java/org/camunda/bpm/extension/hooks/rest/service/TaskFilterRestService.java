package org.camunda.bpm.extension.hooks.rest.service;

import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

import org.camunda.bpm.engine.rest.dto.CountResultDto;
import org.camunda.bpm.extension.hooks.rest.dto.TaskQueryDto;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public interface TaskFilterRestService {

    Object queryList(Request request, TaskQueryDto extendingQuery, Integer firstResult, Integer maxResults) throws JsonProcessingException;

    CountResultDto queryCount(List<TaskQueryDto> filterQuery);

    CountResultDto getFiltersCount(UriInfo uriInfo);
}