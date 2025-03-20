package ru.itis.khairullovruslan.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.itis.khairullovruslan.model.UserEntity;
import ru.itis.khairullovruslan.util.PasswordUtil;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private final JdbcTemplate jdbcTemplate;

    private RowMapper<UserEntity> rowMapper = (rs, rowNum) -> UserEntity.builder()
            .login(rs.getString("login"))
            .hashPassword(rs.getString("password"))
            .uuid(rs.getObject("id", UUID.class))
            .email(rs.getString("email"))
            .build();

    //language=sql
    private final static String SQL_GET_BY_ID = """
            select * from users where id = ?
            """;

    //language=sql
    private final static String SQL_GET_ALL_ID = """
            select * from users
            """;

    //language=sql
    private final static String SQL_CREATE = """
            insert into users(id, login, password, email) VALUES (?, ?, ?, ?)
            """;


    //language=sql
    private final static String SQL_UPDATE_ALL_FIELDS = """
            update users set password = ?, login = ?, email = ? where id = ?
            """;

    //language=sql
    private final static String SQL_UPDATE_GENERAL_INFO = """
            update users set login = ?, email = ? where id = ?
            """;

    //language=sql
    private final static String SQL_DELETE = """
            delete from users where id  = ?;
            """;
    @Override
    public Optional<UserEntity> findById(final UUID uuid) {
        try (final Stream<UserEntity> stream = jdbcTemplate.queryForStream(SQL_GET_BY_ID, rowMapper, uuid)) {
            return stream.findAny();
        }
    }

    @Override
    public Set<UserEntity> getAll() {
        try (final Stream<UserEntity> stream = jdbcTemplate.queryForStream(SQL_GET_ALL_ID, rowMapper)) {
            return stream.collect(Collectors.toSet());
        }
    }

    @Override
    public UUID create(final UserEntity userEntity) {
        UUID uuid = UUID.randomUUID();
        jdbcTemplate.update(SQL_CREATE,
                uuid,
                userEntity.getLogin(),
                PasswordUtil.hashPassword(userEntity.getHashPassword()),
                userEntity.getEmail());
        return uuid;
    }

    @Override
    public void update(final UserEntity userEntity) {
        jdbcTemplate.update(SQL_UPDATE_ALL_FIELDS,
                PasswordUtil.hashPassword(userEntity.getHashPassword()),
                userEntity.getLogin(),
                userEntity.getEmail(),
                userEntity.getUuid());
    }

    @Override
    public void updateGeneralInfo(final UserEntity userEntity) {
        jdbcTemplate.update(SQL_UPDATE_GENERAL_INFO,
                userEntity.getLogin(),
                userEntity.getEmail(),
                userEntity.getUuid());

    }

    @Override
    public void delete(final UUID uuid) {
        jdbcTemplate.update(SQL_DELETE, uuid);
    }
}
