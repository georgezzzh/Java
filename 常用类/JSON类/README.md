### 用的是GSON包
<a href="https://mvnrepository.com/artifact/com.google.code.gson/gson/2.3.1">GSON的Maven依赖</a>   
#### 将List转换为Json
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
### 将json转换为集合
```
JsonArray jsonObject=new JsonParser().parse(s).getAsJsonArray();
                for(JsonElement tmp:jsonObject){
                        long last=tmp.getAsJsonObject().get("lastTime").getAsLong();
                        String session=tmp.getAsJsonObject().get("cookie").getAsString();
                        System.out.println(last+"\t"+session);
                }
```
