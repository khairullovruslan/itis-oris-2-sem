package ru.itis.khairullovruslan.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.itis.khairullovruslan.dto.request.test.UserTestRequest;
import ru.itis.khairullovruslan.dto.response.test.UserTestResponse;

@RequestMapping("/api/v2/test/users")
public interface UserTestApi {
    @GetMapping("/{user-id}")
    @ResponseStatus(HttpStatus.OK)
    UserTestResponse getById(@PathVariable("user-id") Integer id);

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    UserTestResponse create(@RequestBody UserTestRequest userRequest);

    @PatchMapping("/{user-id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    UserTestResponse changeInfo(@RequestBody UserTestRequest userTestRequest, @PathVariable("user-id") Integer id);

    @DeleteMapping("/{user-id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void delete(@PathVariable("user-id") Integer id);

}
