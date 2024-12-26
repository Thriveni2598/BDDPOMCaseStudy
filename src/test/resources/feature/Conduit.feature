Feature: Conduit CRUD functions

Scenario: Login into App

Given User is on login Page
When User enters "abcd@gmail" and "abcdef"
Then User should be on Home Page

Scenario: Create new article

Given User should be on New Article Page
When User enters Article details
| Title     | Description       |  Content       |Tag       |
| Selenium1 | Selenium Tutorial | Course Details |Assignment|
Then Article must be created

Scenario: View Article

Given User should be on Global Feed page
When User select an article Article title
Then Article details page must be displayed

Scenario: Update an Article

Given Article details page must be displayed
When User update article details
Then Article details must be displayed


Scenario: Delete an Article

Given Article details page must be displayed
When  User delete article
Then Article must be deleted

Scenario: Message should be displayed

Given Article Home page must be displayed
Then Message should display

Scenario: Invalid Login into App

Given User is on login Page
When User enters "abcd@gmail.com" and "abcdef"
Then Error message should dsiplay






