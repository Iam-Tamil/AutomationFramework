
Feature: Guru99 Bank application Test

  Scenario: Login should be success
    Given user enter the valid userID
    Given user enter the valid password
    When user click the signin button
    Then signin should be success
