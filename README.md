# bankProject

Descrizione Generale dell’elaborato
Questo elaborato è un Java Application che simula una parte delle funzionalità di una banca. Si tratta della creazione di due tipi di conto: General e Young e del controllo sulla loro corretta funzionamento. Il conto Young è per i giovani sotto 25 anni e non ha costi di manutenzione. In cambio non è possibile effettuare prelievi o pagamenti che superano 700 euro e il saldo non può mai andare sotto zero.
Il conto Generale invece ha un costo di 3 euro mensili e permette di fare prelievi fino a 750 euro ed avere un saldo negativo fino a 50 euro.
Esistono due metodi di pagamento associati ad ogni conto: Uno riguarda il pagamento di bollettini e l’altro i moduli.
La realizzazione attraverso i Design Pattern
sono stati utilizzati tre design pattern differenti per realizzare l’intento di questo elaborato:

• Observer 
• Factory
• Strategy

Account è il Abstract Subject (riferito allo schema di base di Observer) e ha una lista di observers che hanno un riferimento alla classe astratta AbstractObserver. Essa è una classe astratta e avrà due sottoclassi che vengono costruiti grazie al Factory: GeneralAccount e YoungAccount. Ogni sottoclasse eredita i campi dell’Account in particolare identity del tipo IdentityRagistry che tiene le informazioni anagrafici di ogni persona e method di tipo PaymentStrategy. L’attributo method è il ponte di comunicazione con il design pattern Strategy.
Per quanto riguarda i metodi di Account, oltre a increment() e decrement() che effettuano le operazioni di base, è da notare il metodo checkObservers() che controlla che l’attributo booleano degli observers non siano false. Il setPayment(PaymentStrategy aMethod ) serve per scegliere la strategia del pagamento e pay(int amount) effettua il pagamento chiamando il metodo evaluate() del PaymentStrategy sul method.
Account inoltre ha un metodo astratto checkDecrement(int amount) che viene implementato nelle sottoclassi e in base alle condizioni specifiche impostate per ogni conto fa le verifiche e setta gli attributi booleani isOver e isNegative. Questa classe non prevede la dichiarazione di metodi Setter per gli attributi booleani perché rimanessero irraggiungibili dalle classi che non hanno un riferimento ad Account.
AbstractObserver ha un riferimento protected ad un Account chiamato subject e un metodo astratto update(). Le sue sottoclassi, LimitObserver e BalanceObserver, ereditano questo riferimento e implementano il metodo update() in base al proprio funzionamento. Ogni observer eredita inoltre un campo booleano isOK che viene utilizzato soprattutto per le operazioni di pagamento dove è necessario avere i prerequisiti (saldo positivo e l’importo del pagamento inferiore alla soglia) per poter procedere nell’operazione.
AccountFactory ha concettualmente un metodo statico chiamato create. Concretamente questa classe è munita di due metodi statici che hanno lo stesso nome ma firme differenti: differiscono solamente per la lista di parametri che prendono in ingresso. Questa scelta è di natura esclusivamente “estetica” perché permette a Client di costruire un account cui passerà solamente i dati anagrafici dell’utente e il tipo di account da creare. Nel caso in cui ci siano problemi e l’oggetto Account da restituire sia null viene lanciato un’exception del tipo AccountCreationException.
PaymentStrategy è un’interfaccia che viene implementato in due classi di due tipi di pagamenti. Le classi ereditate sono BillPay e ModulePay. Si tratta di due possibili pagamenti da effettuare.
Le procedure di Testing
Per osservare il comportamento generale di questo sistema si usano un Client che stanzia due tipi di account e due tipi di observer. Per non dover ripetere i frammenti di codice riferiti ai passi di test sono stati pensati due classi di test chiamati PaymentTest e ObserversTest. Ad esse viene passato un riferimento ad un account. Client simula i passi di un qualsiasi soggetto che interagisce con la banca e i vari test simulano i controlli e risposte del sistema di controllo all’interno della banca.
