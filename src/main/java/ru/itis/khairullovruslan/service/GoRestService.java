package ru.itis.khairullovruslan.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.itis.khairullovruslan.dto.request.test.UserTestRequest;
import ru.itis.khairullovruslan.dto.response.test.UserTestResponse;

@Service
@RequiredArgsConstructor
public class GoRestService {

    private static final String BASE_URL = "https://gorest.co.in/public/v2";

    private final RestTemplate restTemplate;


    public UserTestResponse getUserById(int userId) {
        return restTemplate.getForObject("%s/users/%d".formatted(BASE_URL, userId), UserTestResponse.class);
    }

    public UserTestResponse createUser(UserTestRequest userTestRequest) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer 7df01daf7ba0591dccf7f9051e8d1b66342ca6c763bd3a69a6bc8360d9cb8d76");
        HttpEntity<UserTestRequest> request = new HttpEntity<>(userTestRequest, headers);
        return restTemplate.postForObject("%s/users".formatted(BASE_URL), request, UserTestResponse.class);
    }

    public void deleteUser(Integer id) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer 7df01daf7ba0591dccf7f9051e8d1b66342ca6c763bd3a69a6bc8360d9cb8d76");
        HttpEntity<Void> request = new HttpEntity<>(headers);
        restTemplate.delete("%s/users/%d".formatted(BASE_URL, id), request);

    }


    public UserTestResponse patchUser(int userId, UserTestRequest userTestRequest) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer 7df01daf7ba0591dccf7f9051e8d1b66342ca6c763bd3a69a6bc8360d9cb8d76");
        HttpEntity<UserTestRequest> request = new HttpEntity<>(userTestRequest, headers);
        return restTemplate.patchForObject(
                "%s/users/%d".formatted(BASE_URL, userId),
                request,
                UserTestResponse.class
        );
    }
}