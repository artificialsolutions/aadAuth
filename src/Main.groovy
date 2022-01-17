class Main {
    public static void main(String[] args) {
        def aadOptions =

                ['redirectUri'            : 'https://yourdomain.com/redirected.html',
                 'clientId'               : 'xxxxxxxx-xxxx-xxxx-xxxx-xxxxxxxxxxxx',
                 'clientSecret'           : 'xxxxx~xxxxxx_xxxxx-xxx-xx-xxxxxxxxxxx',
                 'tenantId'               : 'xxxxxxxx-xxxx-xxxx-xxxx-xxxxxxxxxxxx',
                 'scopes'                 : ['xxxxxxx_xxxxxx', 'yyyyyyyyy.yyyy', 'zzzzzzzzz.zzzz'],
                 'tokenExpireSafetyBuffer': 60000
                ]
        AzureAuthHandler authHandler = new AzureAuthHandler(aadOptions)
        println(authHandler.getLoginUrl())
    }
}
