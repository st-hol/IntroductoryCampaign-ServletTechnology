package org.training.controller.command.account;//package org.training.controller.command.account;
//
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.mockito.runners.MockitoJUnitRunner;
//import org.training.controller.command.Command;
//import org.training.model.service.StudentService;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import java.io.IOException;
//
//import static org.mockito.Mockito.*;
//
//
//@RunWith(MockitoJUnitRunner.class)
//public class LoginCommandTest {
//
//    private final static String path = "/WEB-INF/view/index.jsp";
//
//    @Mock
//    HttpServletRequest request;
//
//    @Mock
//    HttpServletResponse response;
//
//    @Mock
//    RequestDispatcher dispatcher;
//
//    @Test
//    public void whenCallDoGetThenServletReturnIndexPage() throws ServletException, IOException {
//
//        LoginCommand loginCommand = new LoginCommand(new StudentService());
//
////        final HttpServletRequest request = mock(HttpServletRequest.class);
////        final HttpServletResponse response = mock(HttpServletResponse.class);
////        final RequestDispatcher dispatcher = mock(RequestDispatcher.class);
//
//        when(request.getRequestDispatcher(path)).thenReturn(dispatcher);
//        //var... args => OngoingStubbing<T> thenReturn(T value, T... values);
//
//        loginCommand.execute(request, response);
//
//        verify(request, times(1)).getRequestDispatcher(path);
//        verify(request, never()).getSession();
//        verify(dispatcher).forward(request, response);
//    }
//
//
////    @Test
////    public void execute() {
////    }
//}
