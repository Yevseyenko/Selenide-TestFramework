package com.epam.core2;

public abstract class ClientGenerator {
   public static InterfaceClient getClient(String dataProviderClassName){
       if(dataProviderClassName.equals("NameDataProvider")){
           return new RestAssuredClient();
       }else if(dataProviderClassName.equals("UserDataProvider")){
           return new RestAppacheClient();
       }else
           return new RestAssuredClient();
   }
}
