package com;

import com.data.models.BookingItem;
import com.data.models.Status;
import com.data.repository.BookingRepository;
import com.dto.BookingServiceDto.Request.CancelBookingRequest;
import com.dto.BookingServiceDto.Request.CreateBookingRequest;
import com.dto.BookingServiceDto.Request.GetUserBookingRequest;
import com.dto.BookingServiceDto.Request.UpdateBookingRequest;
import com.dto.BookingServiceDto.Response.CancelBookingResponse;
import com.dto.BookingServiceDto.Response.CreateBookingResponse;
import com.dto.BookingServiceDto.Response.GetUserBookingResponse;
import com.dto.BookingServiceDto.Response.UpdateBookingResponse;
import com.dto.authservicedto.reponse.LogOutUserResponse;
import com.dto.authservicedto.reponse.LoginUserResponse;
import com.dto.authservicedto.reponse.RegisterUserResponse;
import com.dto.authservicedto.request.LogOutUserRequest;
import com.dto.authservicedto.request.LoginUserRequest;
import com.dto.authservicedto.request.RegisterUserRequest;
import com.exceptions.BookingServiceExceptions.AccountNotLoggedInExceptions;
import com.service.AuthServiceImplementation;
import com.service.BookingServiceImplementation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class BookingServiceTest {
    @Autowired
    private BookingServiceImplementation bookingServiceImplementation;

    @Autowired
    private AuthServiceImplementation service;

    @BeforeEach
    public void clearAll(){
        this.service.deleteAll();
    }

    @Test
    public void testThatUserLogsInAndBooksAnEvent(){
        RegisterUserRequest request = new RegisterUserRequest();
        request.setEmail("iamgroot");
        request.setName("duke");
        request.setPassword("1234567890");

        RegisterUserResponse response = this.service.registerUser(request);
        assertEquals("duke", response.getName());

        LoginUserRequest loginUserRequest = new LoginUserRequest();
        loginUserRequest.setEmail("iamgroot");
        loginUserRequest.setPassword("1234567890");

        LoginUserResponse loginUserResponse = this.service.loginUser(loginUserRequest);
        assertTrue(loginUserResponse.getIsLoggedIn());

        BookingItem item = new BookingItem();
        item.setQuantity(12);
        item.setTicketTypeId("vvip");
        item.setTotalAmount(1200);

        ArrayList<BookingItem> bookings = new ArrayList<>();
        bookings.add(item);

        CreateBookingRequest createBookingRequest = new CreateBookingRequest();
        createBookingRequest.setUserId(response.getId());
        createBookingRequest.setBookingDate(LocalDateTime.now());
        createBookingRequest.setEventId("375sduer");
        createBookingRequest.setQuantity(11);
        createBookingRequest.setTotalAmount(8000);
        createBookingRequest.setBookings(bookings);

        CreateBookingResponse createBookingResponse = bookingServiceImplementation.createBooking(createBookingRequest);
        assertEquals("375sduer",createBookingResponse.getEventId());
    }

    @Test
    public void testThatUserIsNotLoggedInAndBooksAnEvent(){
        RegisterUserRequest request = new RegisterUserRequest();
        request.setEmail("iamgroot");
        request.setName("duke");
        request.setPassword("1234567890");

        RegisterUserResponse response = this.service.registerUser(request);
        assertEquals("duke", response.getName());

        BookingItem item = new BookingItem();
        item.setQuantity(12);
        item.setTicketTypeId("vvip");
        item.setTotalAmount(1200);

        ArrayList<BookingItem> bookings = new ArrayList<>();
        bookings.add(item);

        CreateBookingRequest createBookingRequest = new CreateBookingRequest();
        createBookingRequest.setUserId(response.getId());
        createBookingRequest.setBookingDate(LocalDateTime.now());
        createBookingRequest.setEventId("375sduer");
        createBookingRequest.setQuantity(11);
        createBookingRequest.setTotalAmount(8000);
        createBookingRequest.setBookings(bookings);

        assertThrows(AccountNotLoggedInExceptions.class, () -> bookingServiceImplementation.createBooking(createBookingRequest));
    }

    @Test
    public void testThatUserLogsInAndBooksAnEventAndGetsIt(){
        RegisterUserRequest request = new RegisterUserRequest();
        request.setEmail("iamthegroot");
        request.setName("duke004");
        request.setPassword("1234567890");

        RegisterUserResponse response = this.service.registerUser(request);
        assertEquals("duke004", response.getName());

        LoginUserRequest loginUserRequest = new LoginUserRequest();
        loginUserRequest.setEmail("iamthegroot");
        loginUserRequest.setPassword("1234567890");

        LoginUserResponse loginUserResponse = this.service.loginUser(loginUserRequest);
        assertTrue(loginUserResponse.getIsLoggedIn());

        BookingItem item = new BookingItem();
        item.setQuantity(12);
        item.setTicketTypeId("vvip");
        item.setTotalAmount(1200);

        ArrayList<BookingItem> bookings = new ArrayList<>();
        bookings.add(item);

        CreateBookingRequest createBookingRequest = new CreateBookingRequest();
        createBookingRequest.setUserId(response.getId());
        createBookingRequest.setBookingDate(LocalDateTime.now());
        createBookingRequest.setEventId("375sduer");
        createBookingRequest.setQuantity(11);
        createBookingRequest.setTotalAmount(8000);
        createBookingRequest.setBookings(bookings);

        CreateBookingResponse createBookingResponse = bookingServiceImplementation.createBooking(createBookingRequest);
        assertEquals("375sduer",createBookingResponse.getEventId());

        GetUserBookingRequest getUserBookingRequest = new GetUserBookingRequest();
        getUserBookingRequest.setId(response.getId());

        GetUserBookingResponse getUserBookingResponse = bookingServiceImplementation.getUserBooking(getUserBookingRequest);
        assertEquals("375sduer", getUserBookingResponse.getEventId());

    }

    @Test
    public void testThatUserIsNotLoggedInAndBooksAnEventAndGetsIt(){
        RegisterUserRequest request = new RegisterUserRequest();
        request.setEmail("iamgroot");
        request.setName("duke");
        request.setPassword("1234567890");

        RegisterUserResponse response = this.service.registerUser(request);
        assertEquals("duke", response.getName());

        LoginUserRequest loginUserRequest = new LoginUserRequest();
        loginUserRequest.setEmail("iamgroot");
        loginUserRequest.setPassword("1234567890");

        LoginUserResponse loginUserResponse = this.service.loginUser(loginUserRequest);
        assertTrue(loginUserResponse.getIsLoggedIn());

        BookingItem item = new BookingItem();
        item.setQuantity(12);
        item.setTicketTypeId("vvip");
        item.setTotalAmount(1200);

        ArrayList<BookingItem> bookings = new ArrayList<>();
        bookings.add(item);

        CreateBookingRequest createBookingRequest = new CreateBookingRequest();
        createBookingRequest.setUserId(response.getId());
        createBookingRequest.setBookingDate(LocalDateTime.now());
        createBookingRequest.setEventId("375sduer");
        createBookingRequest.setQuantity(11);
        createBookingRequest.setTotalAmount(8000);
        createBookingRequest.setBookings(bookings);

        CreateBookingResponse createBookingResponse = bookingServiceImplementation.createBooking(createBookingRequest);
        assertEquals("375sduer",createBookingResponse.getEventId());

        LogOutUserRequest logOutUserRequest = new LogOutUserRequest();
        logOutUserRequest.setEmail(response.getEmail());

        LogOutUserResponse logOutUserResponse = this.service.logoutUser(logOutUserRequest);
        assertEquals("Log out successful", logOutUserResponse.getMessage());

        GetUserBookingRequest getUserBookingRequest = new GetUserBookingRequest();
        getUserBookingRequest.setId(response.getId());

        assertThrows(AccountNotLoggedInExceptions.class, () -> bookingServiceImplementation.getUserBooking(getUserBookingRequest));

    }

    @Test
    public void testThatUserLogsInBooksAnEventAndUpdatesIt(){
        RegisterUserRequest request = new RegisterUserRequest();
        request.setEmail("iamgroot");
        request.setName("duke");
        request.setPassword("1234567890");

        RegisterUserResponse response = this.service.registerUser(request);
        assertEquals("duke", response.getName());

        LoginUserRequest loginUserRequest = new LoginUserRequest();
        loginUserRequest.setEmail("iamgroot");
        loginUserRequest.setPassword("1234567890");

        LoginUserResponse loginUserResponse = this.service.loginUser(loginUserRequest);
        assertTrue(loginUserResponse.getIsLoggedIn());

        BookingItem item = new BookingItem();
        item.setQuantity(12);
        item.setTicketTypeId("vvip");
        item.setTotalAmount(1200);

        ArrayList<BookingItem> bookings = new ArrayList<>();
        bookings.add(item);

        CreateBookingRequest createBookingRequest = new CreateBookingRequest();
        createBookingRequest.setUserId(response.getId());
        createBookingRequest.setBookingDate(LocalDateTime.now());
        createBookingRequest.setEventId("375sduer");
        createBookingRequest.setQuantity(11);
        createBookingRequest.setTotalAmount(8000);
        createBookingRequest.setBookings(bookings);

        CreateBookingResponse createBookingResponse = bookingServiceImplementation.createBooking(createBookingRequest);
        assertEquals("375sduer",createBookingResponse.getEventId());

        UpdateBookingRequest updateBookingRequest = new UpdateBookingRequest();
        updateBookingRequest.setUserId(response.getId());
        updateBookingRequest.setBookingDate(LocalDateTime.now());
        updateBookingRequest.setEventId("375sduer");
        updateBookingRequest.setQuantity(10);
        updateBookingRequest.setTotalAmount(8000);
        updateBookingRequest.setBookings(bookings);

        UpdateBookingResponse updateBookingResponse = bookingServiceImplementation.updateBooking(updateBookingRequest);
        assertEquals(10, updateBookingResponse.getQuantity());
    }

    @Test
    public void testThatUserLogsInBooksAnEventAndCancellsIt(){
        RegisterUserRequest request = new RegisterUserRequest();
        request.setEmail("iamg");
        request.setName("duke");
        request.setPassword("1234567890");

        RegisterUserResponse response = this.service.registerUser(request);
        assertEquals("duke", response.getName());

        LoginUserRequest loginUserRequest = new LoginUserRequest();
        loginUserRequest.setEmail("iamg");
        loginUserRequest.setPassword("1234567890");

        LoginUserResponse loginUserResponse = this.service.loginUser(loginUserRequest);
        assertTrue(loginUserResponse.getIsLoggedIn());

        BookingItem item = new BookingItem();
        item.setQuantity(12);
        item.setTicketTypeId("vvip");
        item.setTotalAmount(1200);

        ArrayList<BookingItem> bookings = new ArrayList<>();
        bookings.add(item);

        CreateBookingRequest createBookingRequest = new CreateBookingRequest();
        createBookingRequest.setUserId(response.getId());
        createBookingRequest.setBookingDate(LocalDateTime.now());
        createBookingRequest.setEventId("375sduer");
        createBookingRequest.setQuantity(11);
        createBookingRequest.setTotalAmount(8000);
        createBookingRequest.setBookings(bookings);

        CreateBookingResponse createBookingResponse = bookingServiceImplementation.createBooking(createBookingRequest);
        assertEquals("375sduer",createBookingResponse.getEventId());

        CancelBookingRequest cancelBookingRequest = new CancelBookingRequest();
        cancelBookingRequest.setId(createBookingResponse.getId());

        CancelBookingResponse cancelBookingResponse = bookingServiceImplementation.cancelBooking(cancelBookingRequest);
        assertEquals("Booking deleted successfully", cancelBookingResponse.getMessage());
    }
}
