package ru.itis.khairullovruslan.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserEntity {
    private UUID uuid;
    private String login;
    private String email;
    private String hashPassword;
}
