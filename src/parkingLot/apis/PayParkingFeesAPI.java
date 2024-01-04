package parkingLot.apis;

import atm.card.CardDetails;
import parkingLot.data.PaymentMode;
import parkingLot.data.Ticket;
import parkingLot.parkingFee.ParkingFeeProcessor;
import parkingLot.payment.IPaymentProcessor;
import parkingLot.payment.PaymentProcessorFactory;

import javax.smartcardio.Card;
import java.util.Map;

public class PayParkingFeesAPI {
    // paymentDetails are provided from client side
    // for cash - amount: 100
    // for card - {pin: "", card num: "", ...}
    public boolean parkingFeesPaid(Ticket ticket, PaymentMode paymentMode, Map<String, String> paymentDetails) {
        // IPaymentProcessor and factory in place
        IPaymentProcessor paymentProcessor = null;
        double amount = Double.parseDouble(paymentDetails.get("AMOUNT"));
        if(paymentMode.equals(PaymentMode.CARD)) {
            String nameOnCard = paymentDetails.get("NAME");
            double pin = Double.parseDouble(paymentDetails.get("PIN"));
            CardDetails cardDetails = null;
            // extract cart details logic, and create above object
            paymentProcessor = PaymentProcessorFactory.getCardBasedPaymentProcessor(amount, cardDetails);
        } else if(paymentMode.equals(PaymentMode.CASH)) {
            paymentProcessor = PaymentProcessorFactory.getCashBasedPaymentProcessor(amount);
        } else {
            throw new IllegalArgumentException("invalid payment type");
        }

        return new ParkingFeeProcessor().processParkingFees(ticket, paymentProcessor);
    }
}
