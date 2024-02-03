package movieTicketBookingSystem.apis;

import movieTicketBookingSystem.services.BookingService;
import movieTicketBookingSystem.services.PaymentsService;

public class PaymentsController {
    private final PaymentsService paymentsService;
    private final BookingService bookingService;

    public PaymentsController(PaymentsService paymentsService, BookingService bookingService) {
        this.paymentsService = paymentsService;
        this.bookingService = bookingService;
    }

    // todo: on webhook response trigger these flows
    public void paymentFailed(final String bookingId, final String user) {
        paymentsService.processPaymentFailed(bookingService.getBooking(bookingId), user);
    }

    public void paymentSuccess(final String bookingId, final String user) {
        bookingService.confirmBooking(bookingService.getBooking(bookingId), user);
    }
}
