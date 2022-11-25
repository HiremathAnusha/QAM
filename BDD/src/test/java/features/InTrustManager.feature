Feature: Coverage of InTrust Manager Test Cases


@InTrustManager01
Scenario Outline:Create the sites and validate Gathering Operation

    When Initialize "<Application>" and User Open the InTrust Manager
    And User Click on Configuartion and Sites
    And User Right Click on the Microsoft Windows Network 
    And User Select New Site and InTrust Server and add Objects
    And User Click on next and Finish button
   

Examples:
|Application|
|IM|