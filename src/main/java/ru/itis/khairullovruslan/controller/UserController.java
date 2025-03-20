package ru.itis.khairullovruslan.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.khairullovruslan.api.UserApi;
import ru.itis.khairullovruslan.dto.request.UserGeneralInfoRequest;
import ru.itis.khairullovruslan.dto.request.UserRequest;
import ru.itis.khairullovruslan.dto.response.UserResponse;
import ru.itis.khairullovruslan.service.UserService;

import java.util.Set;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class UserController implements UserApi {

    private final UserService userService;

    @Override
    public UserResponse getById(final UUID uuid) {
        return userService.getById(uuid);
    }

    @Override
    public Set<UserResponse> getAll() {
        System.out.println("але");
        return userService.getAll();
    }

    @Override
    public UUID create(final UserRequest userRequest) {
        return userService.create(userRequest);
    }

    @Override
    public void update(final UserRequest userRequest, final UUID uuid) {
        userService.update(userRequest, uuid);
    }

    @Override
    public void changeGeneralInfo(final UserGeneralInfoRequest userGeneralInfoRequest, final UUID uuid) {
        userService.updateGeneralInfo(userGeneralInfoRequest, uuid);
    }

    @Override
    public void delete(UUID uuid) {
        userService.delete(uuid);
    }
}
