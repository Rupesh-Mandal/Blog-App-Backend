package com.rupesh_mandal.blog_app_backend.payloads;

import lombok.*;

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class JwtAuthRequest {
    private String email;
    private String password;
}
