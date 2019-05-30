### 用的是GSON包
<a href="https://mvnrepository.com/artifact/com.google.code.gson/gson/2.3.1">GSON的Maven依赖</a>   
* <a href="#collectionToJson">将集合List转换为Json</a>
* <a href="#jsonToCollection">将json转换为集合</a>
* <a href="#objectToJson">将类对象转换成json数据</a>
* <a href="#jsonToObject">将Json转换为自定义的类</a> 

<h3 id="collectionToJson">将集合List转换为Json</h3>     

```java

List<Map<String,String>> data=new LinkedList<>();
Map<String,String> d1=new HashMap<>();
d1.put("lastTime",Long.toString(new Date().getTime()));
d1.put("cookie","12345");
Map<String,String> d2=new HashMap<>();
d2.put("lastTime",Long.toString(new Date().getTime()));
d2.put("cookie","12341");
data.add(d1);
data.add(d2);
Gson gson=new Gson();
String s = gson.toJson(data);

```

<h3 id="jsonToCollection">将json转换为集合</h3>  


```java

JsonArray jsonObject=new JsonParser().parse(s).getAsJsonArray();
for(JsonElement tmp:jsonObject){
    long last=tmp.getAsJsonObject().get("lastTime").getAsLong();
    String session=tmp.getAsJsonObject().get("cookie").getAsString();
    System.out.println(last+"\t"+session);
}

```
<h3 id="objectToJson">将类对象转换成json数据</h3>  

```java
 User user=new User();
user.setAge(13);
user.setName("george");
Gson gson=new Gson();
String json=gson.toJson(user);
System.out.println(json);
```
<h3 id="jsonToObject">将Json转换为自定义的类</h3>  

```java
//反向操作
User userdup=gson.fromJson(json,User.class);
System.out.println(userdup);
```
