package ru.yandex.practicum.filmorate.model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@Builder
public class User {
    @PositiveOrZero
    private int id; // Идентификатор
    @Email
    private String email; // Электронная почта
    @NotNull
    private String login; // Логин пользователя
    private String name; // Имя для отображения
    @PastOrPresent
    private LocalDate birthday; // Дата рождения
}