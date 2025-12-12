# SauceDemo QA Automation Project  
Automated testing project for the SauceDemo webshop using: 
**Java**,
**Selenium WebDriver**,
**Cucumber (BDD)**, 
**JUnit 5**, 
**Allure Reports**,
**Page Object Model (POM)** design pattern.



## 🚀 Technologies Used

| Component | Version |
|----------|---------|
| Java | 17 |
| Maven | Latest |
| Selenium WebDriver | 4.25 |
| Cucumber JVM | 7.x |
| JUnit | 5 |
| WebDriverManager | 5.9 |
| Allure Reports | 2.29 |
| Chrome | Latest |

---

## 📁 Project Structure

```

SauceDemo_tests/
│
├── pom.xml
├── README.md
│
├── src
│   ├── test
│   │   ├── java
│   │   │   └── miriam.tests
│   │   │       ├── pages       # Page Objects
│   │   │       ├── steps       # Step Definitions
│   │   │       └── runners     # Cucumber Test Runner
│   │   └── resources
│   │       └── features        # Feature Files (Gherkin)
│
└── .gitignore

```

---

## Test Design – Automated Scenarios

From the set of **15 manual test cases**, the following **5 were automated**:

| ID | Description |
|----|-------------|
| **SD_TC_01** | Successful purchase of a product |
| **SD_TC_02** | Purchase using price filter (Low → High) |
| **SD_TC_06** | Login with locked_out_user (negative) |
| **SD_TC_08** | Login with empty credentials (negative) |
| **SD_TC_12** | Checkout with empty postal code (negative) |

All tests are implemented using **Cucumber BDD** and are located in:

```

src/test/resources/features/purchase_flow.feature

````

---

## ▶️ Running the Project

### **1️⃣ Clone the repository**
```bash
git clone https://github.com/mirianosorio1/SauceDemo_tests.git
cd SauceDemo_test
````

### **2️⃣ Run all tests**

```bash
mvn test
```

Selenium will automatically download the correct browser driver via **WebDriverManager**.

---

## 📊 Allure Report

### **Generate the Allure report**

```bash
allure serve target/allure-results
```

This launches a live report showing:

* Test summary
* Step-by-step execution
* Screenshots of failed tests
* Execution timeline
* Behaviors grouping by scenario/tags

---

## 🛠 Setup Requirements

Before running the project, ensure you have:

1. **Java 17+ installed**
2. **Maven installed**
3. **Chrome browser**
4. **Allure CLI installed**

### macOS:

```bash
brew install allure
```

### Windows:

Download from
🔗 [https://docs.qameta.io/allure/](https://docs.qameta.io/allure/)

---

## 📘 Framework Architecture

This project uses **Page Object Model (POM)**:

* `LoginPage` → Handling login components
* `ProductsPage` → Filters and product actions
* `CartPage` → Cart interactions
* `CheckoutInformationPage` → Form validations
* `CheckoutOverviewPage` → Order overview
* `CheckoutCompletePage` → Confirmation page

Each page encapsulates its *locators* and *behaviors*.

---

## 🧪 Cucumber Runner

Located in:

```
src/test/java/miriam/tests/runners/TestRunner.java
```

It uses:

* Pretty console output
* JSON output for Allure
* AllureCucumber7Jvm plugin

---

## 📄 Feature File Example

```gherkin
@SD_TC_01
Scenario: Successful purchase of one product
  Given I open the SauceDemo login page
  When I login with username "standard_user" and password "secret_sauce"
  And I add the product "Sauce Labs Backpack" to the cart
  And I proceed to checkout with first name "Miriam", last name "Osorio" and postal code "110111"
  And I continue from the checkout information page
  And I finish the purchase
  Then I should see the order confirmation message
```

---

## 👩‍💻 Author

**Miriam Osorio**

Quality Assurance Engineer

GitHub: [https://github.com/](https://github.com/mirianosorio1)
Email: [mirianosorio1@gmail.com](mailto:mirianosorio1@gmail.com)

---

## ✔️ Final Notes

* Negative and positive scenarios are included.
* Allure reporting is integrated.
