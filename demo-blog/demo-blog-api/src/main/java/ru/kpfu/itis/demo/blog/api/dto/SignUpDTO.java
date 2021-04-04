package ru.kpfu.itis.demo.blog.api.dto;

import lombok.Builder;
import lombok.Data;

/**
 * @author Roman Leontev
 * 12:58 03.04.2021
 * group 11-905
 */

@Data
@Builder
public class SignUpDTO {
    private String email;
    private String password;
}
