Feature:
  As a user
  I want to browse to car insurance page
  Fill in the necessary details required for car insurance
  so that I can get car insurance policy

Scenario Outline: Browse to Car Insurance page
  Given user chooses to get car insurance quote
  When user enter all the necessary details with different title "<Title>" And "<EmploymentStatus>" ,"<MaritalStatus>","<ResidentialStatus>"
  Then she should get the motor policy
  Examples:
    | Title          |EmploymentStatus          |MaritalStatus            |ResidentialStatus  |
    | Mrs            |Employed                  |Married/Civil Partnership|Home owner         |
#    | Miss           |In Education              |Single                   |Renting            |
#    | Ms             |Self Employed             |Living with Partner      |Living with parents|
#    | Dr             |Voluntary                 |Widowed                  |Housing association|
#    | Professor      |Independent Means         |Divorced                 |Other              |
#    | Lady           |Not Employed              |Single                   |Renting            |
#    | Dame           |Retired                   |Widowed                  |Home owner         |
#    | Rt. Honourable |Housewife / House Husband |Divorced                 |Housing association|
