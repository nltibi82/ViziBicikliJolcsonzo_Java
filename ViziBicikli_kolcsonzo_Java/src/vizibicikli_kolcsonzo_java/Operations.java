package vizibicikli_kolcsonzo_java;


import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Operations {
    private List<Loan> loans=new ArrayList<Loan>();
    public Operations(List<Loan> _loans){
        loans=_loans;
    }
    public void LinesOfData(){
        System.out.println("5. feladat: Napi kolcsonzesek szama: "+loans.size());
    }
    public void UsaerDailyData(String _name){
        System.out.println("\t"+_name+" kolcsonzesei:");
        boolean t=false;
        for(Loan item:loans){
            if(item.getName().contains(_name)){
                t=true;
                System.out.println("\t"+item.getsHour()+":"+item.getsMin()+"-"+item.geteHour()+":"+item.geteMin());
            }
        }
        if(t==false){
            System.out.println("Nem volt ilyen nevu kolcsonzo!");
        }
    }
    public void vehiclesOnTheWater(String _time){
        System.out.println("\tA vizen levo jarmuvek: ");
        var s=_time.split(":");
        for(Loan item:loans){
            int st=item.getsHour()*60+item.getsMin();
            int et=item.geteHour()*60+item.geteMin();
            int at=Integer.parseInt(s[0])*60+Integer.parseInt(s[1]);
            if((at>=st) &&(at<=et)){
                String sfsm=String.format("%02d", item.getsMin());
                String sfsh=String.format("%02d", item.getsHour());
                String sfem=String.format("%02d", item.geteMin());
                String sfeh=String.format("%02d", item.geteHour());
                System.out.println("\t"+sfsh+":"+sfsm+"-"+sfeh+":"+sfem+" : "+item.getName());          
            }
        }
    }
    public void dailyIncome(){
        int counter=0;
        for(Loan item:loans){
            int Sint=item.getsHour()*60+item.getsMin();
            int Eint=item.geteHour()*60+item.geteMin();
            double all=(double)(Eint-Sint)/30;
            counter+=Math.ceil(all);
        }
        System.out.println("8. feladat: A napi bevetel: "+counter*2400+"Ft");
    }
    public void fVehicles(){
        try {
            FileWriter fw=new FileWriter("f.txt");
            for(Loan item:loans){
                if(item.getIdentify().equals("F")){
                    String sfsm=String.format("%02d", item.getsMin());
                    String sfsh=String.format("%02d", item.getsHour());
                    String sfem=String.format("%02d", item.geteMin());
                    String sfeh=String.format("%02d", item.geteHour());
                    fw.write(sfsh+":"+sfsm+"-"+sfeh+":"+sfem+" : "+item.getName()+"\n");
                    fw.flush();
                }
            }
            fw.close();
        } catch (IOException ex) {
            System.out.println("Hmm valami baj van!"+ ex);
        }
    }
    public void stat(){
        List<String> vehicles=new ArrayList<String>();
        for(Loan item:loans){
            if(!vehicles.contains(item.getIdentify())){
                vehicles.add(item.getIdentify());
            }
        }
        Collections.sort(vehicles);
        for(String item2:vehicles){
                int count=0;
                for(Loan item3:loans){
                    if(item2.equals(item3.getIdentify())){
                        count++;
                    }
                }
                System.out.println("\t"+item2+" - "+count);
        }
    }
}

