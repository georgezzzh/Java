### 爬取四川大学教务处
<i>
用到的包:<li>Jsoup,解析dom页面</li>
<li>org.apache.commons.HttpClient,下载验证码图片</li>
<li>GSON，解析下载的JSON数据</li>
</i>

> 不完善的地方在于，每次都是我自己手动输入验证码，很无奈...   
 
爬取的主要方法是保存cookie，cookie中的sessionID会在一段时间内有效。剩下的就是打开浏览器分析首部和数据报了。