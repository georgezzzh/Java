/**
 * 使用TesseractOCR引擎识别字符
 *
 */

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.util.ImageHelper;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;

public class Main {
    private static BufferedImage enlargement(BufferedImage image) {
        // 对图片进行处理
        image = ImageHelper
                .convertImageToGrayscale(ImageHelper.getSubImage(image, 0, 0, image.getWidth(), image.getHeight()));
        // 将图片扩大5倍
        image = ImageHelper.getScaledInstance(image, image.getWidth() * 5, image.getHeight() * 5);
        return image;
    }
    public static void main(String[]args){

        String path="C:\\Users\\geoge\\Desktop\\photos\\";
        ITesseract instance =new Tesseract();
        instance.setDatapath("C:\\Program Files (x86)\\Tesseract-OCR\\tessdata");
        instance.setLanguage("fontyp");

        try {
            for(int i=1;i<20;i++){
                String temp=path+i+".jpg";
                BufferedImage bufferedImage= ImageIO.read(new FileInputStream(temp));
                bufferedImage=enlargement(bufferedImage);
                String result=instance.doOCR(bufferedImage);
                System.out.print(i+"-th\t");
                System.out.println(result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
