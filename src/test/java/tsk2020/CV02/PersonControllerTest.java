package tsk2020.CV02;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith({MockitoExtension.class})
class PersonControllerTest {

    @InjectMocks
    private PersonController personController = new PersonController();

    @Mock
    private PersonDAO personDao;


    @BeforeAll
    private static void initAll() {
        System.out.println("Before all");
    }

    @AfterAll
    private static void youreMyWonderWall() {
        System.out.println("After all");
    }


    @Nested
    class Inner {
        @BeforeEach
        private void init() {
            System.out.println("Before each");
            Mockito.when(personDao.find(1)).thenReturn(new Person(1, "Neo", "admin"));
        }

        @AfterEach
        private void destroyEach() {
            System.out.println("After each");
        }


        @Test
        void hasRole() {
            assertTrue(personController.hasRole(1, "admin"));
//            Mockito.verify(personDao, Mockito.times(2)).find(1); //will fail
            Mockito.verify(personDao, Mockito.times(1)).find(1);
        }

        @Test
        void hasNotRole() {
            assertFalse(personController.hasRole(1, "user"));
        }
    }


    @Test
    void hasRoleException() {
//        assertThrows(IllegalArgumentException.class,
//                new Executable() {
//                    @Override
//                    public void execute() throws Throwable {
//                        personController.hasRole(-1, null);
//                    }
//                });

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> personController.hasRole(-1, null));

        String exceptionMessage = exception.getMessage();
//
//        assertTrue(exceptionMessage.contains("ID"));
//        assertTrue(exceptionMessage.contains("zero"));
//        assertTrue(exceptionMessage.contains("greater"));

        MatcherAssert.assertThat(exceptionMessage, Matchers.allOf(
                Matchers.containsString("ID"),
//                Matchers.containsString("id"), //will fail
                Matchers.containsString("zero"),
                Matchers.containsString("greater")
        ));
    }
}