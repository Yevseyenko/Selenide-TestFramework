package com.epam.core2.client;
//TODO fix core2, all names should have information under it

public abstract class ClientResolver {
    //now replace out RestAssured with appache with minimal changes and take note what could be done better from the start
   public static InterfaceClient getClient(String dataProviderClassName){
       if(dataProviderClassName.equals("NameDataProvider")){
           return new RestAssuredClient();
       }else if(dataProviderClassName.equals("UserDataProvider")){
           return new RestApacheClient();
       }else
           return new RestAssuredClient();
   }
}
