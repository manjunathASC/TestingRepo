@SampleFeature_wpmobile
Feature: showcasing BDD framework using wpmobile ecommerce site

  @PlaceOrder
  Scenario: To place an order from wpmobilePack
    Given i have privileges to access wpmobilePack site
    When i select product "Patient Ninja" from home
    And add the selected product to cart "Patient Ninja was added to your shopping cart"
    Then go to checkout page , fill the required fields and place the order
      | itemName      | firstName | lastName | companyName | country            | address1 | address2 | city | state    | zip   | phoneNumber | email          |
      | Patient Ninja | Handy     | David    | HP          | United States (US) | street 1 | street 2 | ohio | Missouri | 43210 |   987654321 | mail@gmail.com |
    Then order has been successfully placed "Order received"

  @PlaceOrder_MultipleTimes
  Scenario Outline: To place an order from wpmobilePack for MultipleTimes
    Given i have privileges to access wpmobilePack site
    When i select product "<itemName>" from home
    And add the selected product to cart "<message>"
    Then go to checkout page , fill the required fields and place the order
      | itemName      | firstName | lastName | companyName | country            | address1 | address2 | city | state    | zip   | phoneNumber | email          |
      | Patient Ninja | Handy     | David    | HP          | United States (US) | street 1 | street 2 | ohio | Missouri | 43210 |   987654321 | mail@gmail.com |
    Then order has been successfully placed "Order received"

    Examples: 
      | itemName        | message                                         |
      | Happy Ninja     | Happy Ninja was added to your shopping cart     |
      | Premium Quality | Premium Quality was added to your shopping cart |
