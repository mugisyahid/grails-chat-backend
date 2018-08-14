**Login**
----
  registering user

* **PERMISSION**
    
    no auth required

* **URL**

  /register

* **Method:**
  
  `POST`
  
*  **URL Params**

  
   **Required:**
 
   

   **Optional:**
 
   
* **Data Params**
    json 
    
    ```json
    {
      "username": "test@kopong.com",
      "name": "test",
      "password": "pass",
      "enabled": false,
      "accountExpired": false,
      "accountLocked": false,
      "passwordExpired": false,
      "remark": "keterangan jati diri - huehue",
      "roles": [ "ROLE_CUSTOMER" ]
      }
    ```
  
* **Success Response:**
  
  * **Code:** 200 <br />
    **Content:** 
    
    ```json
        {
          "_links": {
            "self": {
              "href": "http://localhost:8080/admin/user/5",
              "hreflang": "en_US",
              "type": "application/hal+json"
            }
          },
          "username": "test@kopong.com",
          "name": "test",
          "remark": "keterangan jati diri - huehue"
        }
    ```
    
 
* **Error Response:**

 
  * **Code:** 200 <br />
  ```json
  {
    "errors": [
      {
        "object": ismachatand",
        "field": "name",
        "rejected-value": null,
        "messagismachatbe null"
      },
      {
        "oismachatsterCommand",
        "field": "password",
        "rejected-value": null,
       ismachat cannot be null"
      }
    ]
  }
  ```
    
* **Sample Call:**

  
* **Notes:**

  