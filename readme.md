
# Rohan Pereira's Coding Challenge for MeBank
This application aims to create summaries for financial transactions, namely the total balance of debit and credit transactions for a given account number. The transactions are filtered by a date range and whether the transaction is payment transaction or a reversal.

Two areas that I focussed on for this application were 

 - Readablity: The code should be readable by non-technical users
 - Reusability: I used a lot of static methods and kept the methods as concise as possible for future changes to scope and to make it easy to scale the app.

<h1>Stack</h1>
<ul>
<li>Java 8</li>
</ul>

<h1>In a nutshell</h1>
<ul>
<li>Application Java contains test runner</li>
<li>Transactions.csv contains the csv data for transactions</li>
<li>TransactionImporterService.java maps the csv data to a POJO list of Transaction objects</li>
<li>TransactionAnalyserService.java summaries balances of the transactions with filtering logic</li>
</ul>

<h1>Instructions</h1>
<ul>
<li>Download and install JDK 1.8</li>
<li>Run a 'mvn clean install' on the pom to ensure you see a successful build</li>
<li>Open the project in Eclipse as an existing maven application</li>
<li>Ensure your Eclipse is on JRE8</li>
<li>Run the Application class as a Java Application on Eclipse. It will output some Transaction data to the console.</li>
</ul>

<h1>Improvements</h1>
<ul>
<li>Interfaces could be used for the services</li>
<li>Better exception handing. The exceptions could be more detailed catching CSV mapping errors and invalid transactions.</li>
<li>Better Efficiency. I've excessively looped over the list of transactions multiple times but this could be avoided at the expense of simplicity</li>
</ul>

<h1>Sample Console Output</h1>
<p>Relative balance for the period is: -$25.00</p>
<p>Number of transactions included is: 1</p>


