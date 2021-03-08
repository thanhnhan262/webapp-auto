Feature: Manage user
  Background:
    Given User login with name 'abc' and password 'Pass123'

  Scenario: Add user 1
      When Click on User & Settings icon in top right corner
      And Click on Add People
      And Add some users into list
      Then Congratulations page displays

  Scenario: Add user 2
    When Click on User & Settings icon in top right corner
    And Click on Add People
    And Add some users into list
    Then Congratulations page displays

