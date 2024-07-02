Feature: Add to Cart

  Scenario: Add a product to the cart successfully
    Given I have successfully logged into the application
    When I select a product and add it to the cart
    Then I should see total product on icon cart
    And button Add to cart changed to Remove
    And I am on the cart page
    And the product should be in the cart