package com.course.testng.paramter;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DatadProviderTest1 {
    @Test(dataProvider = "data")
    public  void providerTest(String name ,int age ){
        System.out.println("name = "+name+"; age= "+age);
    }
    @DataProvider(name= "data")
    public Object[][] dataprovider1(){
        Object[][] o =  new Object[][]{
                {"ceshi ",20},
                {"test",30}
        };
        return o;
    }

}
