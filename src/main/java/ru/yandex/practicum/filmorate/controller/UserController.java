package ru.yandex.practicum.filmorate.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.yandex.practicum.filmorate.model.User;
import ru.yandex.practicum.filmorate.service.UserService;

import jakarta.validation.Valid;
import java.util.Collection;
import java.util.List;

@Slf4j
@AllArgsConstructor
@RequestMapping("/users")
@RestController
public class UserController {
    /**
     * Поле сервис
     */
    @Autowired
    private final UserService userService;


    /**
     * Добавление пользователя.
     *
     * @param user информация о пользователе.
     */
    @ResponseBody
    @PostMapping
    public User create(@Valid @RequestBody User user) {
        return userService.getUserStorage().create(user);
    }

    /**
     * Получение списка пользователей.
     *
     * @return users возвращает коллекцию пользователей.
     */
    @GetMapping
    public Collection<User> getUser() {
        return userService.getUserStorage().getUser();
    }

    /**
     * Обновление пользователя.
     *
     * @param user информация о пользователе.
     */
    @ResponseBody
    @PutMapping
    public User put(@Valid @RequestBody User user) {
        return userService.getUserStorage().put(user);
    }

    /**
     * Добавляет пользователя в друзья.
     *
     * @param id       id пользователя кто добавляет.
     * @param friendId id пользователя кого добавляют.
     */
    @PutMapping("{id}/friends/{friendId}")
    public void addFriend(@PathVariable Long id, @PathVariable Long friendId) {
        userService.addFriends(id, friendId);
    }

    /**
     * Удаляет пользователя из друзей.
     *
     * @param id       id пользователя кто удаляет.
     * @param friendId id пользователя кого удаляют.
     */
    @DeleteMapping("{id}/friends/{friendId}")
    public void deleteFriend(@PathVariable Long id, @PathVariable Long friendId) {
        userService.deleteFriends(id, friendId);
    }

    /**
     * Запрашивает всех друзей пользователя.
     *
     * @param id id пользователя чьих друзей запрашиваем.
     * @return возвращает список друзей пользователя.
     */
    @GetMapping("{id}/friends")
    public List<User> getFriend(@PathVariable Long id) {
        return userService.getFriends(id);
    }

    /**
     * Запрашивает пользователя по id.
     *
     * @param id id пользователя.
     * @return возвращает пользователя c указанным id.
     */
    @GetMapping("{id}")
    public User getUser(@PathVariable Long id) {
        return userService.getUserStorage().getByIdUser(id);
    }

    /**
     * Запрашивает общих друзей у двух пользователей.
     *
     * @param id      id пользователя.
     * @param otherId id второго пользователя.
     * @return возвращает список пользователей, являющихся общими друзьями у пользователей.
     */
    @GetMapping("{id}/friends/common/{otherId}")
    public List<User> getMutualFriends(@PathVariable Long id, @PathVariable Long otherId) {
        return userService.getMutualFriends(id, otherId);
    }
}