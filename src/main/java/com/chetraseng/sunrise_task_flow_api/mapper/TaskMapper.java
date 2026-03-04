package com.chetraseng.sunrise_task_flow_api.mapper;

import com.chetraseng.sunrise_task_flow_api.dto.TaskRequest;
import com.chetraseng.sunrise_task_flow_api.dto.TaskResponse;
import com.chetraseng.sunrise_task_flow_api.model.Task;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)

public interface TaskMapper {
    TaskResponse tasks (Task taskResponse);
    TaskRequest taskRequest (Task taskRequest);

}
