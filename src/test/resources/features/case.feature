Feature: Lely Case

  Scenario Outline: Case 1
    Given user is on "<url>" page
    When click search button
    Then check appeared search bar text area
    When send "<data1>" on search area and click search button
    Then search result contain "<data1>"


    Examples:
      | url  | data1 |
      | home | happy |



  Scenario Outline: Case 2
    Given user is on "<url>" page
    And accept cookies
    When select "<product>" in dropdown
    Then check "<product>" can be seen
    And get tab count
    When click "<link>" "<row>"
    And switch tab
    Then check opened on a new tab
    And get tab title
    And switch tab
    And download the "<row-downlaod>" document
    Then verify document downloaded


    Examples:
      | url      | product  | link               | row | row-downlaod |
      | techDocs | Luna EUR | View this document | 1   | 1            |


