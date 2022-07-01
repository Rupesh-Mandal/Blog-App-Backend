package com.rupesh_mandal.blog_app_backend.payloads;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ApiResponse {
    private String message;
    private boolean success;
}
