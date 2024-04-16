package com.example.postcreating.dto;

import com.example.postcreating.entity.User;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@EqualsAndHashCode(of = {"id"})
public class PostDTO {

    private Long id;

    private String title;

    private String content;



    private User author;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private Integer likesCount;
}
