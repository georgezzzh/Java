## 阿里云配置HTTPS

1. 有些开发平台不准用HTTP传输数据，例如微信小程序和苹果平台。
2. HTTP协议会被运营商劫持，插播广告。
3. 浏览器也不会一直提示不安全了。
4. 阿里云有一年的免费期。

### 1.到阿里云下找SSL证书

选择证书时候，选择自动配置，填写完就没事了。审核通过之后下载，用tomcat开发平台下载for tomcat即可。

2. 云服务器ECS

   需要开通443端口。配置网络和安全组>安全组配置>配置规则>添加安全组规则>

   | Key      | Value     |
   | -------- | --------- |
   | 端口范围 | 443/443   |
   | 授权对象 | 0.0.0.0/0 |

   

其余参数默认

3. 如果有防火墙时，需要让443端口被许可通过。

## 2. 在tomcat中配置

其他参照阿里云视频介绍   

更改的内容就是`<connector port="443"></connector>`,还有80端口设置重定向

   ```xml
<?xml version="1.0" encoding="UTF-8"?>
<Server port="8005" shutdown="SHUTDOWN">
  <Listener className="org.apache.catalina.startup.VersionLoggerListener" />
  <!-- Security listener. Documentation at /docs/config/listeners.html
  <Listener className="org.apache.catalina.security.SecurityListener" />
  -->
  <!--APR library loader. Documentation at /docs/apr.html -->
  <Listener className="org.apache.catalina.core.AprLifecycleListener" SSLEngine="on" />
  <!-- Prevent memory leaks due to use of particular java/javax APIs-->
  <Listener className="org.apache.catalina.core.JreMemoryLeakPreventionListener" />
  <Listener className="org.apache.catalina.mbeans.GlobalResourcesLifecycleListener" />
  <Listener className="org.apache.catalina.core.ThreadLocalLeakPreventionListener" />
  <GlobalNamingResources>

    <Resource name="UserDatabase" auth="Container"
              type="org.apache.catalina.UserDatabase"
              description="User database that can be updated and saved"
              factory="org.apache.catalina.users.MemoryUserDatabaseFactory"
              pathname="conf/tomcat-users.xml" />
  </GlobalNamingResources>
  <Service name="Catalina">
    <Connector port="80" protocol="HTTP/1.1"
               connectionTimeout="80000"
               redirectPort="443" />
               <!--其中keyStoreFile是文件路径，keyStorePass是密码-->
<Connector port="443"
    protocol="HTTP/1.1"
    SSLEnabled="true"
    maxThreads="150"
    scheme="https"
    secure="true"
    keystoreFile="/home/pan/tomcat/conf/cert/1991597_xxxxxxx.pfx"
    keystoreType="PKCS12"
    keystorePass="xxxxxx"
    clientAuth="false"
    SSLProtocol="TLSv1+TLSv1.1+TLSv1.2"
 ciphers="TLS_RSA_WITH_AES_128_CBC_SHA,TLS_RSA_WITH_AES_256_CBC_SHA,TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA,TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256,TLS_RSA_WITH_AES_128_CBC_SHA256,TLS_RSA_WITH_AES_256_CBC_SHA256"/>
    <Connector port="8009" protocol="AJP/1.3" redirectPort="443" />
    <Engine name="Catalina" defaultHost="localhost">
      <Realm className="org.apache.catalina.realm.LockOutRealm">
        <!-- This Realm uses the UserDatabase configured in the global JNDI
             resources under the key "UserDatabase".  Any edits
             that are performed against this UserDatabase are immediately
             available for use by the Realm.  -->
        <Realm className="org.apache.catalina.realm.UserDatabaseRealm"
               resourceName="UserDatabase"/>
      </Realm>

      <Host name="localhost"  appBase="webapps"
            unpackWARs="true" autoDeploy="true">
        <Valve className="org.apache.catalina.valves.AccessLogValve" directory="logs"
               prefix="localhost_access_log" suffix=".txt"
               pattern="%h %l %u %t &quot;%r&quot; %s %b" />

      </Host>
    </Engine>
  </Service>
</Server>

   ```

## 3.在web应用中输入HTTP默认HTTPS协议

需要配置/WEB-INF/web.xml,默认http转接https

```xml
<security-constraint>
    <web-resource-collection >
              <web-resource-name >SSL</web-resource-name>
              <url-pattern>/*</url-pattern>
       </web-resource-collection>
       <user-data-constraint>
       <transport-guarantee>CONFIDENTIAL</transport-guarantee>
       </user-data-constraint>
</security-constraint>

```

