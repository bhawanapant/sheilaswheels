Feature:
  As a user
  I want to browse to car insurance page
  Fill in the necessary details required for car insurance
  so that I can get car insurance policy

Scenario Outline: Browse to Car Insurance page
  Given user chooses to get car insurance quote
  When user enter all the necessary details with different title "<Title>"
  Then she should get the motor policy
  Examples:
    | Title          |
    | Mrs            |
#    | Miss           |
#    | Ms             |
#    | Dr             |
#    | Professor      |
#    | Lady           |
#    | Dame           |
#    | Rt. Honourable |
#    | Mr             |
#    | Reverend       |
#    | Sir            |
#    | Lord           |
