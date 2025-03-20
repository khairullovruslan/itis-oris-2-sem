package ru.itis.khairullovruslan.service;

import ru.itis.khairullovruslan.dto.request.UserGeneralInfoRequest;
import ru.itis.khairullovruslan.dto.request.UserRequest;
import ru.itis.khairullovruslan.dto.response.UserResponse;

import java.util.Set;
import java.util.UUID;

public interface UserService {
    UserResponse getById(UUID uuid);

    Set<UserResponse> getAll();

    UUID create(UserRequest userRequest);

    void update(UserRequest userRequest, UUID uuid);

    void updateGeneralInfo(UserGeneralInfoRequest userGeneralInfoRequest, UUID uuid);

    void delete(UUID uuid);
}
