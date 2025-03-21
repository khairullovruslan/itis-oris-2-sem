package ru.itis.khairullovruslan.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.khairullovruslan.api.UserTestApi;
import ru.itis.khairullovruslan.dto.request.test.UserTestRequest;
import ru.itis.khairullovruslan.dto.response.test.UserTestResponse;
import ru.itis.khairullovruslan.service.GoRestService;

@RestController
@RequiredArgsConstructor
public class UserTestController implements UserTestApi {

    private final GoRestService goRestService;
    @Override
    public UserTestResponse getById(Integer id) {
        return goRestService.getUserById(id);
    }

    @Override
    public UserTestResponse create(UserTestRequest userRequest) {
        return goRestService.createUser(userRequest);
    }

    @Override
    public UserTestResponse changeInfo(UserTestRequest userTestRequest, Integer uuid) {
        return goRestService.patchUser(uuid, userTestRequest);
    }

    @Override
    public void delete(Integer uuid) {
        goRestService.deleteUser(uuid);
    }
}