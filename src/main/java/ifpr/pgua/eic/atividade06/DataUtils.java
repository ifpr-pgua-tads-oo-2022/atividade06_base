package ifpr.pgua.eic.atividade06;

import java.time.LocalDateTime;

public class DataUtils {
    

    public static int calculaMinutos(LocalDateTime entrada, LocalDateTime saida){
        if(entrada.isAfter(saida)){
            throw new RuntimeException("Data de entrada inválida!");
        }
        if(saida.getYear() != entrada.getYear()){
            throw new RuntimeException("As datas devem possuir o mesmo ano!");
        }
        if(saida.getYear() == entrada.getYear()){
            int minutos = (saida.getDayOfYear()-entrada.getDayOfYear())*24*60;
            minutos += (saida.getHour()-entrada.getHour())*60;
            minutos += saida.getMinute()-entrada.getMinute();
            
            return minutos;

        }
        return -1;
    }
}
