Feature: Guru99 Bank application Test

  Scenario: Adding new customers should be success 
    Given user navigate to the main page
    Given user enters following customer details
    | Customer Name | Gender | Date of Birth | Address | City | State | Pin | Mobile Number | E-mail | Password |
    | Tamilselvan | Male | 15061990 | 18 Gandhi statue | Villupuram | Tamilnadu | 605602 | 9876543210 | tamil98@gmail.com | Asdf4322 |
    When user click the submit button
    Then add customer should be successful
