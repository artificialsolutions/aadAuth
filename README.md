# Azure Active Directory Authentication Handler

> [!IMPORTANT]
> This project has been retired and archived  
> If there is a need of continued use / development of this project for your own needs please feel free to fork the project - which will remain here in archived form.

## Purpose
This connector is meant to handle the authentication tokens for the Azure Active Directory. 
With it, users can log in and authorize access to back-end processes so that data can be retrieved and used.

## Installation
Both these classes need to be copied into the "Solution Loaded" script in the Solution.

## Dependencies
The RestClient class requires the Apache Commons IO and CODEC libraries, which are included in the "lib" directory in the repository. 
These .jar files need to be uploaded to the solution as a file and set on the /scrip_libs path.

## Usage
This connector has two main parts, the specific AzureAuthHandler class and the common RestClient class.
If you are already using the RestClient class through a different connector, there is no need to provide an additional copy.

### AzureAuthHandler
When the class is instantiated the constructor expects an object with the connection properties, which includes the following fields:

#### redirectUri: 
The URI setup in the application in Azure -> Home -> App Registrations -> [Your App] -> Redirect URIs. This should be the URL of the page the user is redirected to after login.
#### clientId: 
The ID of the application as it appears  in Azure -> Home -> App Registrations -> [Your App]  -> Overview
#### clientSecret:
The client secret gotten from Azure -> Home -> App Registrations -> [Your App] -> Certificates & secrets
#### tenantId:
Your organization's Tenant ID, also from the overview. To authenticate against the universal Microsoft AD (to allow @hotmail, @live and @outlook accounts to authenticate), use 'common' as the tenantID.
#### scopes: 
This is a List of scopes the token is being authorized for. The contents of this list can be copied from Azure -> Home -> App Registrations -> [Your App] -> API Permissions. Make sure to convert all the characters to lower-case.
#### tokenExpireSafetyBuffer: 
Defaults to 60000. The amount of milliseconds that will be shaved off the Token Expiry time so that refresh requests are always within the valid time range.

After the instance is created, there are four methods available:

1) **ExchangeCodeForToken**: This method takes an Authorization code and exchanges it for an authorization token. It has a second parameter that defaults to "true" which will call the startTokenRefreshCycle method to get the refresh process going. False if no refresh is needed.
2) **startTokenRefreshCycle**: This method takes an auth token, a refresh token and an expiration time and will request a new token when the current one gets expired.
3) **getLoginUrl**: This method returns the URL where login can be done.
4) **getAuthToken**: This method will return the value of the current token.

### RestClient
This class is a toolkit for connections and all public methods are static, so there's no need to instantiate. Each method in the class corresponds to an HTTP method, i.e., GET, POST, PUT, PATCH and DELETE.
These methods all require a "url" field, as well as a "headers" map and a "query" map. Those methods that can contain a body will also take a "body" map. If no query string or headers are needed, an empty map is passed.
All methods return a map with a "responseCode" field and a "responseBody" field.


