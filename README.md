# 🛒 Katalon Studio E-Commerce Test Suite

This **Katalon Studio** script suite automates essential user flows in an e-commerce application, ensuring reliable UI behavior and robust error detection through end-to-end testing.

## 🔍 Key Features

- ### 🧾 User Registration
  - Covers new user sign-up
  - Validates registration attempts with already-registered email addresses

- ### 🔐 User Login
  - Tests login functionality using valid and invalid credentials

- ### 🛍️ Checkout Process
  - Dynamic product selection by **category** and **subcategory**
  - Add products to the cart
  - Fill in **shipping details**
  - Place an order successfully
  - Negative scenario: attempt checkout without agreeing to **Terms of Service**

## 🧪 Testing Highlights
- ✅ Reusable test cases with parameterization
- 🔀 Dynamic XPath handling for adaptable UI elements
- 🔄 Conditional logic to handle multiple user paths
- 📸 Full-page screenshots for detailed error tracking and visual regression

## Detail Test Case
1. TC001Register

   This Katalon Studio script automates the user registration process on a web application. It opens the website, navigates to the registration page, selects the user’s gender, fills in the required fields (first name, last name, email, and encrypted password), submits the form, and verifies whether the registration was successful. The script includes full-page screenshot capture, exception handling, and ensures the browser is properly closed after execution.
2. TC001Register - Invalid Credential

   This Katalon Studio script automates the user registration process using an already-registered email address. It navigates to the registration form, selects the user’s gender, fills in personal details, inputs encrypted passwords, and submits the form. After submission, it verifies whether a warning message appears indicating that the email has already been used. The script captures a full-page screenshot, handles exceptions gracefully, and ensures the browser is closed after the test execution.
3. TC002Login
  
   This Katalon Studio script automates the login process using valid credentials. It opens the website, navigates to the login page, inputs the user’s email and encrypted password, and submits the form. After logging in, it verifies the presence of a success element to confirm login was successful. The script also captures a full-page screenshot, includes exception handling, and ensures the browser closes after execution.
4. TC002Login - Invalid Credential
  
   This Katalon Studio script automates the login process with invalid credentials. It navigates to the login page, enters the user's email and encrypted password, and attempts to log in. The script verifies whether a failure message appears, indicating an unsuccessful login attempt. It captures a full-page screenshot, handles exceptions, and ensures the browser is closed after execution.
5. TC003Checkout

   This script automates an e-commerce checkout process using Katalon Studio. It logs in, selects a category, subcategory, and a product, then adds the product to the cart. The script verifies the success message after adding the product, and proceeds to the checkout page. Shipping details like country, state, zip code, and terms of service are selected and filled in. It then chooses a billing address, selects a payment method, and confirms the order. The script also checks for success notifications throughout the process, verifies order details, takes a screenshot, and closes the browser, ensuring that the entire flow is functioning correctly for automated testing.
6. TC003Checkout - Without Check ToS

   This script automates the checkout process on an e-commerce website using Katalon Studio. It starts by logging in, then selects a product category, subcategory, and specific product. After adding the product to the cart with a specified quantity, it verifies a success notification. The script then fills in shipping details, unchecks the terms of service, and proceeds to checkout. It checks for the visibility of the terms of service pop-up and captures a screenshot before closing the browser. This is used for end-to-end functional testing of the checkout flow.



# Test Report: All TC Execution Summary

## Execution Environment
- **Host Name**: Zain
- **Local OS**: Windows 11 64bit
- **Katalon Version**: 9.5.0.217
- **Browser**: Chrome 135.0.0.0
- **Device Name**: Test Device
  
## Execution Time
- **Start Time**: 11-04-2025 20:16:57
- **End Time**: 11-04-2025 20:19:22
- **Total Time**: 2 minutes 24.476 seconds

## 📁 File and video Reports

- [Testsuites.mp4](https://youtu.be/GLne8f_WMdQ)
- [Reports.html](./Github%20Files/20250411_201629.html)
- [Reports.pdf](./Github%20Files/20250411_201629.pdf)



## Summary of Test Results

| Test Case ID           | Description                        | Status   |
|------------------------|------------------------------------|----------|
| TC001Register          | User Registration (Valid)         | PASSED   |
| TC001Register - Invalid Credential | User Registration (Invalid) | PASSED   |
| TC002Login             | User Login (Valid)                | PASSED   |
| TC002Login - Invalid Credential | User Login (Invalid) | PASSED   |
| TC003Checkout          | Product Checkout (With Terms)     | PASSED   |
| TC003Checkout - Without Check ToS | Product Checkout (Without Terms) | PASSED   |

**Note**: All tests have passed successfully, and the execution was completed without any errors or skips.

## Test Cases Breakdown

### TC001Register
| Description             | Start Time               | Elapsed Time | Status   |
|-------------------------|--------------------------|--------------|----------|
| Test Cases/TC001Register | 11-04-2025 20:16:57      | 17.427s      | PASSED   |
| Test Cases/TC001Register - Invalid Credential | 11-04-2025 20:17:15 | 18.180s | PASSED |

#### Steps:
1. **Open Web**: `callTestCase(findTestCase("ReusableTC/OpenWeb"), [:], STOP_ON_FAILURE)` (Success)
2. **Click Register Button**: `click(findTestObject("Register/navbar_register_in_home"))` (17.022s)
3. **Fill Registration Form**:
    - Set `firstName`: "Iyain"
    - Set `lastName`: "Nisrina"
    - Set `email`: "123455456@gamail.comcaas"
4. **Password Set**: `setEncryptedText(findTestObject("Register/password"), password)`
5. **Click Register**: `click(findTestObject("Register/btn_register"))`
6. **Take Screenshot**: `takeFullPageScreenshot()`
7. **Registration Success**: `verifyElementPresent(findTestObject("Register/registrationSuccess"), 0, OPTIONAL)` (Success)
8. **Close Browser**: `Browser is closed`

### TC002Login
| Description            | Start Time               | Elapsed Time | Status   |
|------------------------|--------------------------|--------------|----------|
| Test Cases/TC002Login   | 11-04-2025 20:17:33      | 11.255s      | PASSED   |
| Test Cases/TC002Login - Invalid Credential | 11-04-2025 20:17:44 | 13.929s | PASSED |

#### Steps:
1. **Open Web**: `callTestCase(findTestCase("ReusableTC/OpenWeb"), [:], STOP_ON_FAILURE)` (Success)
2. **Click Login Button**: `click(findTestObject("Login/navbar_login_in_home"))`
3. **Login Credentials**:
    - Set `email`: "testyain@gmail.com"
    - Set `password`: "******"
4. **Click Login**: `click(findTestObject("Login/btn_Login"))`
5. **Login Success**: `verifyElementPresent(findTestObject("Login/loginSuccess"), 0, OPTIONAL)` (Success)
6. **Close Browser**: `Browser is closed`

### TC003Checkout
| Description            | Start Time               | Elapsed Time | Status   |
|------------------------|--------------------------|--------------|----------|
| Test Cases/TC003Checkout| 11-04-2025 20:17:58      | 56.865s      | PASSED   |
| Test Cases/TC003Checkout - Without Check ToS | 11-04-2025 20:18:55 | 24.419s | PASSED |

#### Steps:
1. **Login to Account**: `callTestCase(findTestCase("ReusableTC/Login"), [:], STOP_ON_FAILURE)` (Success)
2. **Select Category**: `click(dynamicCategory)` (9.304s)
3. **Select Product**: `click(dynamicProductUrl)`
4. **Add to Cart**: `click(findTestObject("Checkout/btn_AddToChart"))`
5. **Estimate Shipping**: `click(findTestObject("Checkout/btn_EstimateShipping"))`
6. **Check Terms of Service**: `check(findTestObject("Checkout/termOfServices"))`
7. **Proceed to Checkout**: `click(findTestObject("Checkout/btn_CheckOut"))`
8. **Checkout Success**: `verifyElementPresent(findTestObject("Checkout/successCheckout"), 10)` (Success)
9. **Finalize Payment**: `click(findTestObject("Checkout/btn_ConfirmOrder"))`
10. **Order Confirmation**: `verifyElementPresent(findTestObject("Checkout/successCheckoutNotification"), 0, OPTIONAL)` (Success)
11. **Close Browser**: `Browser is closed`

---







