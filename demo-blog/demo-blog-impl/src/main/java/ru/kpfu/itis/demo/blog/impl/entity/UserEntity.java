package ru.kpfu.itis.demo.blog.impl.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.kpfu.itis.demo.blog.api.dto.UserDTO;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "account")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String email;
    private String password;
    @Enumerated(value = EnumType.STRING)
    private State state;
    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    public List<CommentEntity> comments;

    public enum Role {
        ADMIN,
        USER
    }

    public enum State {
        ACTIVE("ACTIVE"),
        BANNED("BANNED");

        private final String state;

        State(String state) {
            this.state = state;
        }

        public String getState() {
            return state;
        }
    }

    public boolean isActive(){
        return  this.state == State.ACTIVE;
    }

    public boolean isBanned(){
        return  this.state == State.BANNED;
    }

    public boolean isAdmin(){
        return this.role == Role.ADMIN;
    }
}
