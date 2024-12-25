package ru.noleg.crmmm.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import ru.noleg.crmmm.service.GroupService;

@RestController
@RequiredArgsConstructor
public class GroupController {

    private final GroupService groupService;


}
