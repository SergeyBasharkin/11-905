 package ru.kpfu.itis.demo.blog.api.dto;

 import lombok.AllArgsConstructor;
 import lombok.Builder;
 import lombok.Data;
 import lombok.NoArgsConstructor;

 @Builder
 @AllArgsConstructor
 @NoArgsConstructor
 @Data
public class UserDTO {

     public String email;
     public String password;
     public String name;
}
