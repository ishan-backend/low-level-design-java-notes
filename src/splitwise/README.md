**Splitwise Simplify Algorithm**:
* [A->B, Rs. 5]
* [B->C, Rs. 7]
* [C->A, Rs. 3]
* [A->C, Rs. 6]

- Splitwise simplify task is to reduce the number of transactions
- Compute (incoming-outgoing) to calculate balance for every Node
- -ve originally -> has to give money, on giving +add money  (because it received earlier, net)
- +ve originally -> has to receive money, on receiving money -that amount (because it gave money earlier, net)

- Adding a txn, requires to add +10 and -10 to nodes at each end
- Members with net 0 (incoming-outgoing) are not required in simplify
- Groups of different members, graphs for each group

- For a group, divide into receiver(+ve) and giver(-ve). Sum of both should be 0
- Balance List: [100, -200, 300, -200]
- Amounts if given partially, can lead to many transactions.
- For simplify, give the full amount

