package com.course.testng.paramter;

public class DataProviderTest {
    /*@Test(dataProvider = "data")
    public void testDataProvider(String name ,int age){
        System.out.println();
        System.out.println("name ="+name+" ;age = "+age);
    }
    @DataProvider(name="data")
    public Object[][] providerData(){
        Object[][] o = new Object[][]{
                {"zhangsan",10},
                {"lisi",20},
                {"wangwu",30}
        };
        return o;
    }*/
  /* @Test(dataProvider = "methodData")
    public void test1(String name,int age){
        System.out.println("test1111方法 name ="+name +" ; age = "+age);
    }
    @Test(dataProvider = "methodData" )
    public void test2(String name,int age){
        System.out.println("test2222方法name ="+name+" ; age = "+age);
    }

    @DataProvider(name="methodData")
    public Object[][] methodDataTest(Method method){
        Object[][] result = null;
        if(method.getName().equals("test1")){
            result = new Object[][]{
                    {"zhangsan",20},
                    {"lisi",37},
                    {"wangwu",30}
            };

        }else if(method.getName().equals("test2")){
            result = new Object[][]{
                    {"得瑟",20},
                    {"好像",37},
                    {"没有",30}
            };

        }
        return result;

    }*/

}
