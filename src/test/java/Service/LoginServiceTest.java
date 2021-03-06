package Service;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

 @ExtendWith(MockitoExtension.class)
    class LoginServiceTest {

        @Spy
        static LoginService loginService = new LoginService() ;

        @BeforeAll
        static void  initialiseMock() {

        }

        @Test
        void testEmailWithFalscheAdresse() {

            //Mockito.when(loginService.testEmail(ArgumentMatchers.any())).thenReturn(false);
            //Mockito.when(loginService.testEmail("wilfried.nono@gmail.com")).thenReturn(true);

            Mockito.doReturn(true).when(loginService).testEmail(ArgumentMatchers.any());
            String email = "1213456";

            boolean result = loginService.testEmail(email);

            assertEquals(false, result);
        }

        @Test
        void testEmailAvecMajuscule() {
            String email = "Blond@gmail.com";

            boolean result = loginService.testEmail(email);

            assertEquals(true, result);
        }

        @Test
        void testEmailAvecUniquementMiniscule() {
            String email = "Blond@gmail.com";

            boolean result = loginService.testEmail(email);

            assertEquals(true, result);
        }
}
