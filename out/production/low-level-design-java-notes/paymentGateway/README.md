**Payment Gateway use-case App**:
1. Select a pay mode.
2. Enter details:
   1. For netbanking - enter username and password
   2. For credit / debit card - enter card details ( number, expiry, cvv etc )
   3. UPI - enter vpa

**Example**
```text
Flipkart has integrated multiple PGs like Razorpay, Citrus, PaySafe, CCAvenue etc. 
They use these PGs based on different use cases. 
For example, divert all credit card transaction to RazorPay while Netbanking goes to CCAvenue.

These PGs internally have direct integration with different banks which facilitate the payments.

Expectation from this code is to build PG like a Razorpay / CCAvenue which allows onboarding clients like Flipkart and process a transaction.
Client in this case is Flipkart (PG can have more than one clients )PG is what candidate has to implement PG can have more than one bank, candidates are free to implement a mock or full fledged class.
```

**Feature Requirement**:
1. PG should support onboarding multiple clients.
2. PG should have multiple bank integrations (like HDFC, ICICI, SBI etc.)
3. PG should have facility to support different payment methods - UPI, Credit / Debit Card, Netbanking etc
4. PG should have facility to divert to specific bank based on certain criteria - a router basically - (for e.g. all credit card transaction goes to HDFC and net banking is redirected to ICICI)
5. PG should have facility to allocate specific percentage between different banks - say bank1 takes 30% of total traffic while remaining 70% go to bank2
6. Clients should have an option to opt for specific payment methods. - only UPI, everything except netbanking etc

**Assumptions**:
1. Banks can randomly return success / failure - candidates can create a random function to mock this behavior.
2. Payments should be processed using an instrument only if specific parameter for that payment is passed - net banking might need user id / password but credit card will only work with card details
3. Banks require OTP verification after instrument details are verified (applicable for net banking / card transaction ) for sake of simplicity, transactions will go through without OTP

**Machine Coding evaluation criteria**:
1. Working code
2. Code readability
3. Implementation of OOPs / OOD principles with proper Separation of concerns
4. Testability - a TDD approach ( not to be mixed with test cases )
5. Language proficiency
6. Test Cases ( bonus points )

**APIs**:
* addClient() - add a client in PG
* removeClient() - remove client from PG
* hasClient() - does a client exist in the PG

* listSupportedPaymodes() - show paymodes support by PG. if a client is passed as parameter, all supported paymodes for the clients should be shown.
* addSupportForPaymode() - add paymodes support in the PG. If a client is passed as parameter, add paymode for the clients.
* removePaymode() - remove paymode ( both from PG or client basis parameter)

* showDistribution() - show active distribution percentage of router

* makePayment( //necessary payment details )
* checkActivePaymentsFromAClient() etc.

**Implementation steps**:







