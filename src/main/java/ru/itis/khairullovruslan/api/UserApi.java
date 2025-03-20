package ru.itis.khairullovruslan.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.itis.khairullovruslan.dto.request.UserGeneralInfoRequest;
import ru.itis.khairullovruslan.dto.request.UserRequest;
import ru.itis.khairullovruslan.dto.response.UserResponse;

import java.util.Set;
import java.util.UUID;

@RequestMapping("/api/v1/users")
public interface UserApi {
    @GetMapping("/{user-id}")
    @ResponseStatus(HttpStatus.OK)
    UserResponse getById(@PathVariable("user-id") UUID uuid);

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    Set<UserResponse> getAll();

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    UUID create(@RequestBody UserRequest userRequest);

    @PutMapping("/{user-id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void update(@RequestBody UserRequest userRequest, @PathVariable("user-id") UUID uuid);

    @PatchMapping("/{user-id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void changeGeneralInfo(@RequestBody UserGeneralInfoRequest userGeneralInfoRequest, @PathVariable("user-id") UUID uuid);

    @DeleteMapping("/{user-id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void delete(@PathVariable("user-id") UUID uuid);

}
