package ru.itis.khairullovruslan.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itis.khairullovruslan.dto.request.UserGeneralInfoRequest;
import ru.itis.khairullovruslan.dto.request.UserRequest;
import ru.itis.khairullovruslan.dto.response.UserResponse;
import ru.itis.khairullovruslan.exception.UserNotFoundException;
import ru.itis.khairullovruslan.mapper.UserMapper;
import ru.itis.khairullovruslan.model.UserEntity;
import ru.itis.khairullovruslan.repository.UserRepository;

import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper mapper;

    @Override
    public UserResponse getById(final UUID uuid) {
        return mapper.toResponse(
                userRepository.findById(uuid).orElseThrow(() -> new UserNotFoundException(uuid))
        );
    }

    @Override
    public Set<UserResponse> getAll() {
        return userRepository.getAll().stream().map(mapper::toResponse).collect(Collectors.toSet());
    }

    @Override
    public UUID create(final UserRequest userRequest) {
        return userRepository.create(mapper.toEntity(userRequest));
    }

    @Override
    public void update(final UserRequest userRequest, final UUID uuid) {

        UserEntity entity = mapper.toEntity(userRequest);
        entity.setUuid(uuid);
        userRepository.update(entity);
    }

    @Override
    public void updateGeneralInfo(final UserGeneralInfoRequest userGeneralInfoRequest, final UUID uuid) {
        UserEntity entity = mapper.toEntity(userGeneralInfoRequest);
        entity.setUuid(uuid);
        userRepository.updateGeneralInfo(entity);


    }

    @Override
    public void delete(final UUID uuid) {
        userRepository.delete(uuid);
    }
}
