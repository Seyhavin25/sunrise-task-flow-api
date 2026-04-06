package com.chetraseng.sunrise_task_flow_api.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data @NoArgsConstructor @AllArgsConstructor
public class CommentRequest {

  @NotBlank(message = "Content is required")
  private String content;

  private String author;
}