# Passbook Vault API Documentation

## Base URL

http://localhost:8080

---

# Account APIs

## Create Account

POST /api/accounts

### Request Body

```json
{
  "accountHolderName": "Tset Naeme",
  "bankName": "State Bank of India",
  "accountNumber": "1234567890",
  "ifscCode": "SBIN0001234"
}
```

---

## Get All Accounts

GET /api/accounts

---

## Get Account By ID

GET /api/accounts/{id}

---

## Update Account

PUT /api/accounts/{id}

---

## Delete Account

DELETE /api/accounts/{id}

---

# Search APIs

## Search By Bank Name

GET /api/accounts/search/bank?name=SBI

## Search By Account Holder

GET /api/accounts/search/holder?name=Test

## Search By IFSC

GET /api/accounts/search/ifsc?code=SBIN0001234

## Universal Search

GET /api/accounts/search?keyword=Te

---

# Document APIs

## Upload Document

POST /api/documents/upload

Form Data:

* accountId
* file
* remarks

---

## Download Document

GET /api/documents/{id}/download

---

# Dashboard APIs

## Dashboard Summary

GET /api/dashboard/summary
