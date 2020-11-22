/**
* @author Furkan Kemal Karabay g181210105@sakarya.edu.tr , Okan Yeşiloğlu g171210057@sakarya.edu.tr
* @since 01.03.2020
* <p>
* Verilen dosyayı okuyup içinde bulunan sesli harf, kelime, cümle, mail, web site sayısını
* hesaplayıp ekrana yazdıran program.
* </p>
*/

package javaapplication2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 *
 * @author Furkan
 */
public class JavaApplication2 {

    public static void main(String[] args) throws IOException {
        
        String metin = "";  
        String satır;
        
        File file = new File("icerik.txt"); //Dosyayı belirttim.

        FileReader fileReader = new FileReader(file); //Dosyanın okunması için gerekli olan işlemleri yaptım.
        BufferedReader br = new BufferedReader(fileReader);
       
        while((satır = br.readLine()) != null) //Dosyadaki metni kendi oluşturduğum string'e atadım.
        {
            metin += satır+" ";   
        }     
        
        br.close();
        
        //Regex
        Matcher matcher; 
        
        Pattern sesliHarfPattern = Pattern.compile("[aAeEıIiİuUüÜoOöÖ]"); //Sesli harfleri belirlemek için.
        Pattern mailPattern = Pattern.compile("\\b[\\w.%-]+@[-.\\w]+\\.[A-Za-z]{2,4}\\b"); //Mail adreslerini belirlemek için.
        Pattern websitePattern = Pattern.compile("[^@]\\b+\\.?[\\w.%-]+\\.(com|edu.tr|net|org|com.tr|edu|net.tr|org.tr)\\b"); //Web sitelerini belirlemek için.
        Pattern cumlePattern = Pattern.compile("(?<=[a-z])(\\.|!|\\?)\\s+"); //Cümleleri belirlemek için.
        
        
        int sesliHarfSayisi = 0;
        int mailSayisi = 0;
        int websiteSayisi = 0;
        int cumleSayisi = 0;
        int kelimeSayisi = metin.trim().split("\\s+").length; //Kelime sayısı.
        
        matcher = sesliHarfPattern.matcher(metin); //Matcher'a sesli harfleri atadım.
        while (matcher.find())//Eşleştiği taktirde sayacımı arttırdım.
            sesliHarfSayisi++;
        
        matcher = mailPattern.matcher(metin); //Matcher'a mail adresini atadım.
        while (matcher.find())//Eşleştiği taktirde sayacımı arttırdım.
            mailSayisi++;
        
        matcher = websitePattern.matcher(metin); //Matcher'a websitesini atadım.
        while (matcher.find())//Eşleştiği taktirde sayacımı arttırdım.
            websiteSayisi++;
        
        matcher = cumlePattern.matcher(metin); //Matcher'a cumleyi atadım.
        while (matcher.find())//Eşleştiği taktirde sayacımı arttırdım.
            cumleSayisi++;

        System.out.println("Bulunan Sesli Harf Sayısı : "+sesliHarfSayisi);//Toplam sesli harf sayısı.
        System.out.println("Bulunan Kelime Sayısı     : "+ kelimeSayisi);//Toplam kelime sayısı.
        System.out.println("Toplam Cümle Sayısı       : " + cumleSayisi);//Toplam cümle sayısı.
        System.out.println("Toplam Mail Sayısı        : "+mailSayisi);//Toplam mail sayısı.
        System.out.println("Toplam Web Sitesi Sayısı  : "+websiteSayisi);//Toplam web site sayısı.               
        }
    }
    

