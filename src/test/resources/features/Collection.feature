@AllTask
Feature:Collection Page Feature

  Background:
    Given user go to the website
    When user click "Ontdek de collectie" link

  @TC1
  Scenario: User should be able to see Collectie Page
    Then user should be see the collectie page
      | Collectie                                 |
      | https://www.vangoghmuseum.nl/nl/collectie |

  @TC2
  Scenario: User should be see more then 700 result after search
    When user click search tab
    And user search the painting with title "Het Gele Huis" from the search box
    Then user see the result more than 700

  @TC3
  Scenario:User should be verify first result
    When user click search tab
    And user search the painting with title "Het Gele Huis" from the search box
    And user click first result
    And user click "Objectgegevens" link for see details
    Then user should be see painting details Title and Result
      | F-nummer         | F0464      |
      | JH-nummer        | JH1589     |
      | Inventarisnummer | s0032V1962 |


