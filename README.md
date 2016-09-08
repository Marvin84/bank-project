# bank-project
Simulation of some operations for a bank using three design patterns:
<br />
<br />

• Observer <br /> 
• Factory <br />
• Strategy <br />

Account is the Abstract Subject and is extended to GeneralAccount and YoungAccount. IdentityRagistry contains the general information of the user. There are two observers: LimitObserver and BalanceObserver.<br /> 
AccountFactory instantiates the desired type of account.<br /> 
PaymentStrategy is implemented in BillPay e ModulePay.<br /> 
