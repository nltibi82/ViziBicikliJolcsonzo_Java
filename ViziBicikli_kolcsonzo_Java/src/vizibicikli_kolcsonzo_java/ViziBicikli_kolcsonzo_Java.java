package vizibicikli_kolcsonzo_java;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ViziBicikli_kolcsonzo_Java {

    public static void main(String[] args) {
        ArrayList<Loan> loans=new ArrayList<Loan>();
        List<String> data=new ArrayList<String>();
        try {
           data=Files.readAllLines(Paths.get("kolcsonzesek.txt"), StandardCharsets.UTF_8);
           for(int i = 1; i < data.size(); i++){
               var data2=data.get(i).split(";");
               Loan l=new Loan();
               l.setName(data2[0]);
               l.setIdentify(data2[1]);
               l.setsHour(Integer.parseInt( data2[2]));
               l.setsMin(Integer.parseInt( data2[3]));
               l.seteHour(Integer.parseInt( data2[4]));
               l.seteMin(Integer.parseInt( data2[5]));
               loans.add(l);
           }
           Operations opr=new Operations(loans);
           opr.LinesOfData();
           System.out.print("6. feladat: Kerek egy nevet: ");
           Scanner sc=new Scanner(System.in);
           String s=sc.nextLine();
           opr.UsaerDailyData(s);
           System.out.print("7. feladat: Adjon meg egy idopontot ora:perc alakban:");
           Scanner sc2=new Scanner(System.in);
           String s2=sc2.nextLine();
           opr.vehiclesOnTheWater(s2);
           opr.dailyIncome();
           opr.fVehicles();
           opr.stat();
        } catch (IOException ex) {
            System.out.println("Nem letezo allomany!");
        }   
    } 
}
