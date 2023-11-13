package ru.yandex.practicum.filmorate.model;

import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

/**
 * Класс-модель для создания пользователя со свойствами <b>id<b/>, <b>email<b/>, <b>login<b/>, <b>name<b/>, <b>birthday<b/>, <b>friends<b/>.
 */
@Data
@NoArgsConstructor
public class User {
    private Long id; // Идентификатор
    @Email
    @NotBlank
    @NotNull
    private String email; // Электронная почта
    @NotEmpty
    @NotBlank
    private String login; // Логин пользователя
    private String name; // Имя для отображения
    @NotNull
    @PastOrPresent
    private LocalDate birthday; // Дата рождения


    /**
     * Конструктор создание нового объекта пользователя.
     *
     * @see User#User(String, String, String, LocalDate)
     */
    @Autowired
    public User(String email, String login, String name, LocalDate birthday) {
        this.email = email;
        this.login = login;
        this.name = name;
        this.birthday = birthday;
    }
}