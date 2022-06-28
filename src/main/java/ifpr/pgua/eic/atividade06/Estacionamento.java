package ifpr.pgua.eic.atividade06;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Estacionamento {
    private String nome;
    private String telefone;
    private ArrayList<Veiculo> veiculos;
    
    public Estacionamento(String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
        veiculos = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public ArrayList<Veiculo> listaTodosVeiculos(){
        return veiculos;
    }

    public Veiculo buscarVeiculo(String placa){
        for(Veiculo veiculo:veiculos){
            if(veiculo.getPlaca().equals(placa)){
                return veiculo;
            }
        }
        return null;
    }

    public boolean cadastraVeiculo(String placa, String modelo, String fabricante, int anoFabricacao, String cor){
        if(buscarVeiculo(placa)==null){
            Veiculo veiculo = new Veiculo(placa, modelo, fabricante, anoFabricacao, cor);

            veiculos.add(veiculo);

            return true;

        }

        return false;
    }


    public boolean registraEntrada(String placa){
        Veiculo veiculo = buscarVeiculo(placa);
        if(veiculo != null && !veiculo.isEstaEstacionado()){
            veiculo.registraEntrada(LocalDateTime.now());
            return true;
        }
        return false;
    }

    public int registraSaida(String placa){
        Veiculo veiculo = buscarVeiculo(placa);
        if(veiculo != null && veiculo.isEstaEstacionado()){
            
            LocalDateTime dataSaida = LocalDateTime.now();
            System.out.println(dataSaida);
            int minutos = DataUtils.calculaMinutos(veiculo.getHoraEntrada(), dataSaida);
            
            
            veiculo.registraSaida();

            return minutos;
        }
        return -1;
    }




}
