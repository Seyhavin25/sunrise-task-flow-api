package com.chetraseng.sunrise_task_flow_api.mapper;

<<<<<<< HEAD
import com.chetraseng.sunrise_task_flow_api.dto.TaskRequest;
import com.chetraseng.sunrise_task_flow_api.dto.TaskResponse;
import com.chetraseng.sunrise_task_flow_api.model.Task;
=======
import com.chetraseng.sunrise_task_flow_api.dto.TaskResponse;
import com.chetraseng.sunrise_task_flow_api.model.TaskModel;
>>>>>>> f2844df7839fb4f5be1fd26972c17c104c86203b
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
<<<<<<< HEAD

public interface TaskMapper {
    TaskResponse tasks (Task taskResponse);
    TaskRequest taskRequest (Task taskRequest);

=======
public interface TaskMapper {
  TaskResponse toTaskResponse(TaskModel task);
>>>>>>> f2844df7839fb4f5be1fd26972c17c104c86203b
}
