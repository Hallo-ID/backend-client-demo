# HalloID - Java SDK demo 

This project shows how to implement HalloID Java SDK, used to generate
service tokens and validate returned tokens by HalloID platform.

## Configuration

Before start, make sure you followed all steps required in the [HalloID 
 development guidelines](), so you have your `CLIENT_ID` and key pair 
ready.

Now, to initialize the Java SDK:

```groovy
    // Include the lib in the project classpath.
    implementation files('lib/halloid-java-sdk-1.0-SNAPSHOT-all.jar')
```

Then, we add the required parameters in our 
[application.yml](src/main/resources/application.yml) file:

```yaml
halloId:
  client:
    id: <YOUR CLIENT ID>
    privateKey: |
      -----BEGIN PRIVATE KEY-----
      <YOUR PRIVATE KEY>
      -----END PRIVATE KEY-----

  publicKey: |
    -----BEGIN PUBLIC KEY-----
    <YOUR PUBLIC KEY>
    -----END PUBLIC KEY-----
```

_Note: If the key pais is provided by you, remember it must be in PKCS #8
Base 64 format, with a length 2048 bits._ 

In non-local environments, you may want to retrieve those values from 
Vault and inject them via env vars ;)

Finally, let's initialize our server SDK:

```java
    private final HalloIDJavaSDK halloIDJavaSDK;
    
    // Initialize the SDK with the retrieved values from the properties file
    public TokenService(@Value("${halloId.client.id}") String clientID,
                        @Value("${halloId.client.privateKey}") String privateKey,
                        @Value("${halloId.publicKey}") String halloIdPublicKey) {
        this.halloIDJavaSDK = new HalloIDJavaSDK(clientID, privateKey, halloIdPublicKey);
    }
```
 Now you are ready to start using HalloID Java SDK methods. Happy coding!
 

### References

- To generate your key pair: https://www.csfieldguide.org.nz/en/interactives/rsa-key-generator/

