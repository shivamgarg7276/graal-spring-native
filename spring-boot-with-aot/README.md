# Build the module

You can build the module simple by using this command -  
`mvn -Pnative-image clean package`

This will create a native executable comprising the Spring Boot application under the `target` folder of the module.  


Simply invoke -    
`target/com.example.graal.restserver.main.restapplicationwithaot`

This will start the Spring Boot server at port `8081`.  

The startup will now be less than `200 ms`, compared to the `1500 ms` when using the application without AOT.

Also, the memory consumption this time should be around `40 MB` compared to `200 MB` in the JIT variant.