Feature: User can login to ecommerce site
  Scenario Outline: User can login with valid username and password
    Given User visited to the ecommerce site
    When User inputs the valid "<username>" and "<password>"
    Then User can login successfully
    Examples:
      | username  | password |
      |salman@test.com|P@ssword123|
      |testuser412@grr.la|2t8zmqzL|
    When User inputs the invalid "<username>" and "<password>"
    Then User can not login successfully
    Examples:
      | username  | password |
      |salman2@test.com|P@ssword123|
      |testuser2412@grr.la|2t8zmqzL|

