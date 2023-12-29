package atm.db;

import atm.card.CardDetails;
import atm.state.ATMState;
import atm.state.IATMState;
import atm.state.TransactionState;

/*
    DBAccessor is a stateless class, since constructor is private and all methods are static
    Since I want only one instance of DB to float around

     DBAccessor
     has a/multiple method - which talks to DB and returns state for a machine id

     ATM class atmState is an object, while DB can return only String/ENUM
     so, on basis of ENUM (ATMState), we introduce a factory on top of it in ATM constructor
*/
public class DBAccessor {
    private DBAccessor() {}
    public static ATMState getATMState(String machineId) {
        /*
            we will have some code which will make DB Query on database server
            dummy code
        */
        return ATMState.READY;
    }

    // createNewTransaction creates new entry in DB and returns new transaction id
    public static int createNewTransaction(String machineId) {
        return 1;
    }

    public static void updateATMState(String machineId, ATMState atmState) {}

    public static void cancelTransaction(int txnId) {}

    public static void persistCardDetails(CardDetails cardDetails, String machineId){} // from machineId we can find txnId, since we allow only one txn on a machine

    public static void disapproveTransaction(String machineId){
        // make transaction as ENUM NOT_APPROVED in db
    }

    public static void persistWithDetails(int transId, float amount, TransactionState status) {}

    public static float markAsExec(int txnId){return 0;}
}
