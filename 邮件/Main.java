/**
 * 需要的jar包:
 * 1.activation-1.0.2.jar
 * 2.mail.jar
 * @FirstTimeEdit : 2019-04-28 10:41
 * @LastTimeEdit: 2019-04-28 14:31
 * @Content: 发送邮件
 * @Attention: 需要注意用网易邮箱的授权码,不是邮箱本身的密码
 * @Remark: 一份邮件发19s,也是够给力的，必要的隐私信息存在mail.json中，读取便是
 */
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Map;
import java.util.Properties;

public class Main extends Authenticator {
    protected PasswordAuthentication getPasswordAuthentication() {
        Map config= ReadConfig.readFile();
        String username = (String)config.get("from");
        String password= (String)config.get("password");
        return new PasswordAuthentication(username, password);
    }
    public static void main(String[]args) {
        long start=System.currentTimeMillis();
        Map config=ReadConfig.readFile();
        String to=(String)config.get("to");
        String from=(String)config.get("from");
        String host="smtp.163.com";
        Properties properties=System.getProperties();
        properties.setProperty("mail.smtp.host",host);
        properties.setProperty("mail.transport.protocol","smtp");
        properties.setProperty("mail.smtp.auth","true");
        Session session=Session.getDefaultInstance(properties,new Main());
        try{
            MimeMessage message=new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
            //设置邮件的主题和文本
            message.setSubject("For Fun");
            message.setText("To Test");
            //transport
            Transport ts=session.getTransport();
            String user=config.get("user").toString();
            String password=config.get("password").toString();
            ts.connect(user,password);
            ts.send(message,message.getAllRecipients());
            ts.close();
            System.out.println("send successfully");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //打印程序运行时间
            long end=System.currentTimeMillis();
            long diff=(end-start)/1000;
            System.out.println("System run time is:"+diff+"s");
        }
    }
}
