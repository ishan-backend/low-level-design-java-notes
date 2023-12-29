package atm.state;

public enum ATMState {
    READY,
    CARD_READING,
    WITHDRAWL_DETAILS_READING,
    CASH_DISPENSING,
    CARD_EJECTING
}
