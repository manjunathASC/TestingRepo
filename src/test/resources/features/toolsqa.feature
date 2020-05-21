@SampleFeature_Toolsqa
Feature: showcasing BDD framework using Toolsqa site

  @Access_Cucumber_tutorial
  Scenario: To access cucumber tutorial
    Given i aunthorized user able to access toolsqa site
    When im at home page and navigate to tutorials menu
    Then navigate to "Web Automation Tools" menu followed by "Cucumber Tutorial"
