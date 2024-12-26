package ru.noleg.crmmm;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import ru.noleg.crmmm.controller.TeacherController;
import ru.noleg.crmmm.controller.mapper.TeacherMapper;
import ru.noleg.crmmm.controller.model.TeacherDTO;
import ru.noleg.crmmm.entity.Teacher;
import ru.noleg.crmmm.service.TeacherService;
import ru.noleg.crmmm.service.impl.TeacherServiceDefaultImpl;

import java.util.ArrayList;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest(TeacherController.class)
public class TeacherAPITest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private TeacherServiceDefaultImpl teacherService;

    @Mock
    private TeacherMapper teacherMapper;

    @InjectMocks
    private TeacherController teacherController;

    @Autowired
    private ObjectMapper objectMapper;

    private TeacherDTO teacherDTO;
    private Teacher teacher;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        teacherDTO = new TeacherDTO();
        teacherDTO.setSurname("Ivanov");
        teacherDTO.setName("Ivan");
        teacherDTO.setPatronymic("Ivanovich");
        teacherDTO.setGroups(new ArrayList<>());

        teacher = new Teacher();
        teacher.setSurname("Ivanov");
        teacher.setName("Ivan");
        teacher.setPatronymic("Ivanovich");
        teacher.setGroups(new ArrayList<>());
    }

    @Test
    public void testCreateTeacher() throws Exception {
        Teacher createdTeacher = new Teacher();
        createdTeacher.setName("John Doe");

        TeacherDTO createdTeacherDTO = new TeacherDTO();
        createdTeacherDTO.setName("John Doe");

        when(teacherMapper.toEntity(teacherDTO)).thenReturn(teacher);
        when(teacherService.createTeacher(teacher)).thenReturn(createdTeacher);
        when(teacherMapper.toDto(createdTeacher)).thenReturn(createdTeacherDTO);

        mockMvc.perform(post("/v1/teachers")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(teacherDTO)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name").value("Ivan"));
    }
}
