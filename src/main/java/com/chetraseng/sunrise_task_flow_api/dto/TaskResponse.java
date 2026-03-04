package com.chetraseng.sunrise_task_flow_api.dto;

<<<<<<< HEAD
import lombok.*;

import java.time.LocalDateTime;
=======
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
>>>>>>> f2844df7839fb4f5be1fd26972c17c104c86203b

@Data
@AllArgsConstructor
@NoArgsConstructor
<<<<<<< HEAD
@Getter
@Setter
public class TaskResponse {
    private Long id;
    private String title;
    private String description;
    private String completed;
    private LocalDateTime  createdAt;
=======
public class TaskResponse {
  private Long id;
  private String title;
  private String description;
  private Boolean completed;
  private LocalDateTime createdAt;
>>>>>>> f2844df7839fb4f5be1fd26972c17c104c86203b
}
