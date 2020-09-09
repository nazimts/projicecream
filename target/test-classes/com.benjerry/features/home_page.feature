@homePage
Feature: Email functionality




Scenario: As A User I should be able to send an email

  Given I am on home page
When Click on Title drop down 
And Select Mr. Title
And Enter Full Name as "Spider Man" into Full Name field
And Enter Address as "2000 New Yourk" into Address field
And Enter Zip code as "34003" into Zip field
And Enter Phone number "1234567" into Phone field
And Enter email as "spiderman@gmail.com" into email field
And click on Send email button 
Then Thw message should appear "Sorry, this campaign isn't available in your area yet."

