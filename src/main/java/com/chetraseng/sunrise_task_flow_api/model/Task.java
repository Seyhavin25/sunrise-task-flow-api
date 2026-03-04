package com.chetraseng.sunrise_task_flow_api.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tasks")

public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;    private String title;
    private String description;
    private boolean completed = false;

    @CreationTimestamp
    private LocalDateTime createdAt = LocalDateTime.now();

}
