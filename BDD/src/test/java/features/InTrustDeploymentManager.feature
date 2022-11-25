Feature: Coverage of InTrust Deployment Manager Test Cases


@InTrustDeploymentManager01 @IDM
Scenario Outline:Create windows collection using Domain with installing agent in InTrust Deployment Manager

    When Initialize "<Application>" and User Open the InTrust Deployment Manager
    And User Click on New button on top left corner to create the window collection with agent installed
    And User Enter Name and Description and click Next
    And User Select Domain by clicking on Add then Domain and Select Domains
    And User Select Data Source, Repository, Server and click Next
    Then User Click on Finish button
    Then User Click on the refresh button and wait to validate the Computer Status 

Examples:
|Application| 
|IDM| 


@InTrustDeploymentManager02 @IDM
Scenario Outline:Create windows collection using Domain without installing agent in InTrust Deployment Manager

    When Initialize "<Application>" and User Open the InTrust Deployment Manager
    And User Click on New button on top left corner to create the window collection without agent installed
    And User Enter Name and Description and click Next to proceed
    And User Select Domain by clicking on Add then Domain and Select Domains
    And User Select Data Source, Repository, Server and click Next
    Then User Click on Finish button
    Then User Click on the refresh button and wait to validate the Computer Status 

Examples:
|Application|
|IDM|


@InTrustDeploymentManager03 @IDM1
Scenario Outline:Create windows collection using Computer without installing agent in InTrust Deployment Manager

    When Initialize "<Application>" and User Open the InTrust Deployment Manager
    And User Click on New button on top left corner to create the window collection without agent installed
    And User Enter Name and Description and click Next to proceed
    And User Select Computer by clicking on Add then Computer and Select Computers
    And User Select Data Source, Repository, Server and click Next
    Then User Click on Finish button
    Then User Click on the refresh button and wait to validate the Computer Status 

Examples:
|Application|
|IDM|


@InTrustDeploymentManager04 @IDM1
Scenario Outline:Create windows collection using Computer with installing agent in InTrust Deployment Manager

    When Initialize "<Application>" and User Open the InTrust Deployment Manager
    And User Click on New button on top left corner to create the window collection without agent installed
    And User Enter Name and Description and click Next
    And User Select Computer by clicking on Add then Computer and Select Computers
    And User Select Data Source, Repository, Server and click Next
    Then User Click on Finish button
    Then User Click on the refresh button and wait to validate the Computer Status 

Examples:
|Application|  
|IDM|  


@InTrustDeploymentManager05 @IDM1
Scenario Outline:Creation of the Repository in InTrust Deployment Manager

    When Initialize "<Application>" and User Open the InTrust Deployment Manager
    And User Click on storage to create the new repository
    And User Enter Name of the repository and provide the repository location
    Then User Click on Ok button and repository got created

Examples:
|Application|
|IDM|


@InTrustDeploymentManager06 @IDM1
Scenario Outline:Deletion of the Repository in InTrust Deployment Manager

    When Initialize "<Application>" and User Open the InTrust Deployment Manager
    And User Click on storage to delete the repository
    Then Selected repository gets deleted

Examples:
|Application|
|IDM|


@InTrustDeploymentManager07
Scenario Outline:Installtion of agents manually and then edit the newly created collection in InTrust Deployment Manager

    When Initialize "<Application>" and User Open the InTrust Deployment Manager
    And User Click on New button on top left corner to create the window collection without agent installed
    And User Enter Name and Description and click Next to proceed
    And User Select Computer by clicking on Add then Computer and Select Computers
    And User Select Data Source, Repository, Server and click Next
    Then User Click on Finish button
    Then User Click on the refresh button and wait to validate the Computer Status 
    And User select the computer and select option to install agent manually
     Then User Click on the refresh button and wait to validate the Computer Status 
     Then User Select the collection to edit 
      Then User Click on the refresh button and wait to validate the Computer Status 
    
Examples:
|Application|
|IDM|


@InTrustDeploymentManager08
Scenario Outline:Add computers from search folder to collection in InTrust Deployment Manager

    When Initialize "<Application>" and User Open the InTrust Deployment Manager
    And User Click on New button on top left corner to create the window collection with agent installed
    And User Enter Name and Description and click Next
    And User Select Domain by clicking on Add then Domain and Select Domains
    And User Select Data Source, Repository, Server and click Next
    Then User Click on Finish button
    Then User Click on the refresh button and wait to validate the Computer Status 
    Then User go to search folder and select Computers not in collection
    And User Select the server and add that to collection
     Then User Click on the refresh button and wait to validate the Computer Status 
    
Examples:
|Application|
|IDM|


@InTrustDeploymentManager09
Scenario Outline:Remove computers from Collection in InTrust Deployment Manager

    When Initialize "<Application>" and User Open the InTrust Deployment Manager
    And User Click on New button on top left corner to create the window collection with agent installed
    And User Enter Name and Description and click Next
    And User Select Domain by clicking on Add then Domain and Select Domains
    And User Select Data Source, Repository, Server and click Next
    Then User Click on Finish button
    Then User Click on the refresh button and wait to validate the Computer Status 
    And User Select the collection and select the computer to remove from collection
     Then User Click on the refresh button and wait to validate the Computer Status 
    
Examples:
|Application|
|IDM|


@InTrustDeploymentManager10
Scenario Outline:Creation of syslog collection using all devices you specify in InTrust Deployment Manager

    When Initialize "<Application>" and User Open the InTrust Deployment Manager
    And User Click on storage to enable the forwarding option
    Then User provided all the details and enable forwarding
    And User Click on Collection tab to create the Syslog collection 
    Then User Provide the syslog collection name and repository 
    Then User Click on Finish button
    Then User Click on the refresh button and wait to validate the Computer Status 
    Then User Open the InTrust Repository Viewer
    Then User Open the repository to and click on go to analyse the results 

Examples:
|Application|
|IDM|


@InTrustDeploymentManager11
Scenario Outline:Installation of the InTrust product

		When User open the project folder location for the latest build
		#And User Select Install Navigation and install InTrust extented suite
		Then User click next to proceed the installation 
    #When Initialize "<Application>" and User Open the InTrust Deployment Manager
    #And User Click on storage to enable the forwarding option
    #Then User provided all the details and enable forwarding
    #And User Click on Collection tab to create the Syslog collection 
    #Then User Provide the syslog collection name and repository 
    #Then User Click on Finish button
    #Then User Click on the refresh button and wait to validate the Computer Status 
    #Then User Open the InTrust Repository Viewer
   # Then User Open the repository to and click on go to analyse the results 

Examples:
|Application|
|IDM|


@InTrustDeploymentManager12
Scenario Outline:Verification of Home Page Links and Text in InTrust Deployment Manager

    When Initialize "<Application>" and User Open the InTrust Deployment Manager
    Then User verify all the links available on HomePage

Examples:
|Application|
|IDM|


@InTrustDeploymentManager13
Scenario Outline:Verification of Search folder functionality in InTrust Deployment Manager

    When Initialize "<Application>" and User Open the InTrust Deployment Manager
     And User Click collection tab
     Then User Go to the search folder and verfiy all the available folders

Examples:
|Application|
|IDM|     


@InTrustDeploymentManager14
Scenario Outline:Verification of General, Security and Data Cleanup property in InTrust Deployment Manager

    When Initialize "<Application>" and User Open the InTrust Deployment Manager
     And User Click on storage tab
     And User Verify Name, Description & UNC Path under General section
     And User Verify Managed by this InTrust Server & To access the repository use fields under Security section
     And User Click on Edit to Enable Cleanup under Daily Cleanup section
     Then User Select value in fields Keep repository data for and Start daily cleanup at and click Apply
     
Examples:
|Application|
|IDM|     