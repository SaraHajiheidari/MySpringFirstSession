package com.mokito;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;

import static org.mockito.Mockito.when;

@SpringBootTest
class MokitoApplicationTests {

    @Autowired
    private UserService userService;

    @MockBean
    private IUserRepository iUserRepository;

    @Mock
    private ArrayList mockList;

    @Test
    public void userAktiveTest(){

        when(iUserRepository.count()).thenReturn(2l);
        Assertions.assertTrue(userService.isUserAktiert(new User("sara", true)));

        ArrayList mocklist2 = Mockito.mock(ArrayList.class);


    }

    @Test
    void contextLoads() {
    }

}
