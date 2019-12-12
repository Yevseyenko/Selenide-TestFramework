package com.epam.core2.client;


public abstract class ClientResolver {

   public static InterfaceClient getClient(String dataProviderClassName){
       if(dataProviderClassName.equals("NameDataProvider")){
           return new RestApacheClient();
       }else if(dataProviderClassName.equals("UserDataProvider")){
           return new RestAssuredClient();
       }else
           return new RestAssuredClient();
   }
}
