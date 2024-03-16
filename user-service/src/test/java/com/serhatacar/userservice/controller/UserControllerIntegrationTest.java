package com.serhatacar.userservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.serhatacar.userservice.UserServiceApplication;
import com.serhatacar.userservice.common.base.BaseControllerIntegrationTest;
import com.serhatacar.userservice.dto.request.UserSaveRequest;
import com.serhatacar.userservice.dto.request.UserUpdateRequest;
import com.serhatacar.userservice.entity.enums.Gender;
import com.serhatacar.userservice.entity.enums.Status;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Serhat Acar
 */
@ExtendWith(MockitoExtension.class)
@SpringBootTest(classes = {UserServiceApplication.class})
 class UserControllerIntegrationTest extends BaseControllerIntegrationTest {

    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;

    private Long  userId = 10L;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(this.context).build();
        objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());
    }

    @Test
    void shouldGetUsers() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/users"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        boolean success = isSuccess(mvcResult);
        assertTrue(success);
    }

    @Test
    void shouldSaveUser() throws Exception {
        UserSaveRequest userSaveRequest = new UserSaveRequest(
                "name",
                "surname",
                LocalDate.now(),
                "email@example.com",
                Gender.MALE,
                Status.ACTIVE,
                40.7128,
                74.0060
        );

        String requestAsString = objectMapper.writeValueAsString(userSaveRequest);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/users")
                        .content(requestAsString)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        boolean success = isSuccess(mvcResult);
        assertTrue(success);
    }

    @Test
    void shouldGetUserById() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/users/" + userId))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        boolean success = isSuccess(mvcResult);
        assertTrue(success);
    }

    @Test
    void shouldUpdateUser() throws Exception {
        UserUpdateRequest userUpdateRequest = new UserUpdateRequest(
                userId,
                "name",
                "surname",
                LocalDate.now(),
                "email@example.com",
                Gender.MALE,
                Status.ACTIVE,
                40.7128,
                74.0060);

        String requestAsString = objectMapper.writeValueAsString(userUpdateRequest);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/users/"+userId)
                        .content(requestAsString)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
    }

    @Test
    void shouldDeleteUser() throws Exception {

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/users/" + userId))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        boolean success = isSuccess(mvcResult);
        assertTrue(success);
    }
}
