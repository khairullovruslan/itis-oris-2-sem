package ru.itis.khairullovruslan.repository;

import ru.itis.khairullovruslan.model.UserEntity;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public interface UserRepository {
    Optional<UserEntity> findById(UUID uuid);

    Set<UserEntity> getAll();

    UUID create(UserEntity userEntity);

    void update(UserEntity userEntity);

    void updateGeneralInfo(UserEntity userEntity);

    void delete(UUID uuid);
}
