class Main {
    public static void main(String[] args) {
    /*Dummy flow*/
        //These values should be set in a variable in the solution
        def aadOptions =

                ['redirectUri'            : 'https://yourdomain.com/redirected.html',
                 'clientId'               : 'xxxxxxxx-xxxx-xxxx-xxxx-xxxxxxxxxxxx',
                 'clientSecret'           : 'xxxxx~xxxxxx_xxxxx-xxx-xx-xxxxxxxxxxx',
                 'tenantId'               : 'xxxxxxxx-xxxx-xxxx-xxxx-xxxxxxxxxxxx',
                 'scopes'                 : ['xxxxxxx.xxxxxx', 'yyyyyyyyy.yyyy', 'zzzzzzzzz.zzzz'],
                 'tokenExpireSafetyBuffer': 60000
                ]

        //Instantiate Handler with options
        AzureAuthHandler authHandler = new AzureAuthHandler(aadOptions)
        //Get URL for login and send to user.
    String urlForUserLogin =  authHandler.getLoginUrl()

        String authCode = 'xxxxxx'
        //Use auth code from login to get a token
        authHandler.exchangeCodeForToken(authCode)
    }
}
