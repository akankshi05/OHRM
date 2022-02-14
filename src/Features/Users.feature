Feature: Verify User feature works successfully



  Scenario Outline: Verify user is able to add new user successfully
    When clicked on User by navigating to Admin-UserManagement-Users
    Then System users screen should Open
    When clicked on Add
    Then Add User screen should Open
    When user enters User Role, "<Employee Name>", Username ,Status ,"<Password>","<Confirm Password>"
    And clicks on Save
    Then user should be successfully added
    And Added user should have the same username and Employee Name


    Examples:
      |Employee Name  |Password  |Confirm Password|
      |Admin A        |Akankshi@1|Akankshi@1      |

    Scenario: Display all the users information
      When clicked on User by navigating to Admin-UserManagement-Users
      Then System users screen should Open
      Then print no. of users and all the usernames  on the screen

    Scenario Outline: verify user count before and after adding a new user
      When clicked on User by navigating to Admin-UserManagement-Users
      Then System users screen should Open
      Then count the total no. of users
      When clicked on Add
      Then Add User screen should Open
      When user enters User Role, "<Employee Name>", Username ,Status ,"<Password>","<Confirm Password>"
      And clicks on Save
      Then user should be successfully added
      And total count of users should increase by 1
      Examples:
        |Employee Name  |Password  |Confirm Password|
        |Admin A        |Akankshi@1|Akankshi@1      |

  Scenario: Verify user is able to delete the added user successfully
      When clicked on User by navigating to Admin-UserManagement-Users
      Then System users screen should Open
      When user selects first row by checking the checkbox
      And clicks on Delete
      Then row should be successfully deleted