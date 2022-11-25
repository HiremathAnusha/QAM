Feature: Coverage of InTrust Repository Manager Test Cases


@InTrustRepositoryViewer01
Scenario Outline:Open Repository in InTrust Repository Viewer

    When Initialize "<Application1>" and User Open the InTrust Repository Viewer
    And User Click on Configuration and data Stores  
    And User Right Click on the Repositories and select New Repository
    And User Provide the Name, select repository type and Repository location 
    And User Select the enable indexing and click next and finish button
 

Examples:
|Application1| |Application1| 
|IM|           |IRV|
   

   

   