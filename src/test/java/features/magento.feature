Feature: To check the signup and login functionality
@AT_test01
Scenario: To check the signUp functionality of magentotestingboard
Given Navigate to mangentotestingboard homepage
Then Click on the createAccount on mangentotestingboard homepage
And Enter the FirstName createAccount on mangentotestingboard homepage
And Enter the LastName createAccount on mangentotestingboard homepage 
And Enter the Email createAccount on mangentotestingboard homepage
And Enter the Password createAccount on mangentotestingboard homepage
And Enter the ConfirmPassword createAccount on mangentotestingboard homepage
And Click on createAnAccount button createAccount on mangentotestingboard homepage
And Click on SignOut on mangentotestingboard homepage

@AT_test02
Scenario: To check the signIn functionality of magentotestingboard
Given Navigate to mangentotestingboard homepage
Then Click on signIn on mangentotestingboard homepage
And Enter the Email signIn on mangentotestingboard homepage
And Enter the Password signIn on mangentotestingboard homepage
And Click on SignIn button signIn on mangentotestingboard homepage
And User verify the account is signIn or not
