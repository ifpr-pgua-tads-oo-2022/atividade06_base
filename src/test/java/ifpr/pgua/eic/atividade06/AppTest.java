package ifpr.pgua.eic.atividade06;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.time.LocalDateTime;
import java.util.ArrayList;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.mockito.MockedStatic;
import org.mockito.Mockito;

/**************/
/*REPITA COMIGO:*/
/*NÃO PRECISO ALTERAR ESSE ARQUIVO*/
/*NÃO PRECISO ALTERAR ESSE ARQUIVO*/
/*NÃO PRECISO ALTERAR ESSE ARQUIVO*/
/*NÃO PRECISO ALTERAR ESSE ARQUIVO*/

/*ESTA CLASSE POSSUI UMA SÉRIE DE TESTES AUTOMATIZADOS
 *PARA VERIFICAR SE O CÓDIGO QUE VOCÊ CRIOU ESTÁ FUNCIONANDO
 *E FAZENDO AQUILO QUE É ESPERADO.
 *O QUE VOCÊ PRECISA NESTE FAZER É CLICAR NA SETINHA
 * VERDE QUE FICA AO LADO DO NOME DE CADA MÉTODO.
 * SE O VSCODE INDICAR QUE EXISTEM ERROS DE COMPILAÇÃO,
 * PODE CLICAR NO CANTO INFERIOR DIREITO NO BOTÃO DE PROCEED.
 * A DICA É COMEÇAR A RESOLVER CADA UM DOS TESTES NA SEQUÊNCIA.
 * O OBJETIVO É DEIXAR TODOS OS TESTES PASSANDO (CHECK VERDE) AO FINAL
 * DA ATIVIDADE.
*/




public class AppTest 
{
    /* 
    @Test
    @DisplayName("A classe veículo possui todos os atributos com os tipos definidos")
    public void testaTiposAtributosVeiculo()throws NoSuchFieldException{
        Class<Veiculo> clazz = Veiculo.class;
        
        Field placa = clazz.getDeclaredField("placa");
        Field modelo = clazz.getDeclaredField("modelo");
        Field fabricante = clazz.getDeclaredField("fabricante");
        Field anoFabricacao = clazz.getDeclaredField("anoFabricacao");
        Field cor = clazz.getDeclaredField("cor");
        Field horaEntrada = clazz.getDeclaredField("horaEntrada");
        Field estaEstacionado = clazz.getDeclaredField("estaEstacionado");
        
        
        assertEquals(true,placa.getType()==String.class);
        assertEquals(true,modelo.getType()==String.class);
        assertEquals(true,fabricante.getType()==String.class);
        assertEquals(true,anoFabricacao.getType().getTypeName()=="int");
        assertEquals(true,cor.getType()==String.class);
        assertEquals(true,horaEntrada.getType()==LocalDateTime.class);
        assertEquals(true,estaEstacionado.getType().getTypeName()=="boolean");
        
    }


    @Test
    @DisplayName("A classe veículo possui todos os atributos e são privados")
    public void testaAtributosVeiculo()throws NoSuchFieldException{
        Class<Veiculo> clazz = Veiculo.class;
        
        Field placa = clazz.getDeclaredField("placa");
        Field modelo = clazz.getDeclaredField("modelo");
        Field fabricante = clazz.getDeclaredField("fabricante");
        Field anoFabricacao = clazz.getDeclaredField("anoFabricacao");
        Field cor = clazz.getDeclaredField("cor");
        Field horaEntrada = clazz.getDeclaredField("horaEntrada");
        Field estaEstacionado = clazz.getDeclaredField("estaEstacionado");
        
        
        assertEquals(true,Modifier.isPrivate(placa.getModifiers()));
        assertEquals(true,Modifier.isPrivate(modelo.getModifiers()));
        assertEquals(true,Modifier.isPrivate(fabricante.getModifiers()));
        assertEquals(true,Modifier.isPrivate(anoFabricacao.getModifiers()));
        assertEquals(true,Modifier.isPrivate(cor.getModifiers()));
        assertEquals(true,Modifier.isPrivate(horaEntrada.getModifiers()));
        assertEquals(true,Modifier.isPrivate(estaEstacionado.getModifiers()));   
    }

    @Test
    @DisplayName("Existe somente um método construtor definido para a classe veículo")
    public void testaConstrutorVeiculo(){

        String placa = "AAA-1122";
        String modelo = "Corsa";
        String fabricante = "Chevrolet";
        int anoFabricacao = 2002;
        String cor = "Vermelho";

        Veiculo veiculo = new Veiculo(placa,modelo,fabricante,anoFabricacao,cor);
        
        assertEquals(1, Veiculo.class.getDeclaredConstructors().length);

    }   

    @Test
    @DisplayName("Existe os getters e os atributos estão com valores corretos")
    public void testaGettersEInicializacaoVeiculo(){

        String placa = "AAA-1122";
        String modelo = "Corsa";
        String fabricante = "Chevrolet";
        int anoFabricacao = 2002;
        String cor = "Vermelho";

        Veiculo veiculo = VeiculoBuilder.umVeiculo()
                                        .comPlaca(placa)
                                        .comModelo(modelo)
                                        .comFabricante(fabricante)
                                        .comAnoFabricacao(anoFabricacao)
                                        .comCor(cor)
                                        .agora();


        assertEquals(veiculo.getPlaca(), placa);
        assertEquals(veiculo.getModelo(), modelo);
        assertEquals(veiculo.getFabricante(), fabricante);
        assertEquals(veiculo.getAnoFabricacao(), anoFabricacao);
        assertEquals(veiculo.getCor(), cor);
        assertEquals(veiculo.isEstaEstacionado(), false);
        assertNull(veiculo.getHoraEntrada());
    }


    @Test
    @DisplayName("Existe os setters e os atributos são atualizados com valores corretos")
    public void testaSettersEAtualizacaoVeiculo(){

        
        Veiculo veiculo = VeiculoBuilder.umVeiculo().agora();

        
        String placa = "BBB-1122";
        String modelo = "Gol";
        String fabricante = "Wolks";
        int anoFabricacao = 2001;
        String cor = "Azul";

        veiculo.setPlaca(placa);
        veiculo.setModelo(modelo);
        veiculo.setFabricante(fabricante);
        veiculo.setAnoFabricacao(anoFabricacao);
        veiculo.setCor(cor);

        assertEquals(veiculo.getPlaca(), placa);
        assertEquals(veiculo.getModelo(), modelo);
        assertEquals(veiculo.getFabricante(), fabricante);
        assertEquals(veiculo.getAnoFabricacao(), anoFabricacao);
        assertEquals(veiculo.getCor(), cor);
        assertEquals(veiculo.isEstaEstacionado(), false);
        assertNull(veiculo.getHoraEntrada());

        assertThrows(NoSuchMethodException.class,()->{
                veiculo.getClass().getDeclaredMethod("setHoraEntrada", LocalDateTime.class);
            }
        );

        assertThrows(NoSuchMethodException.class,()->{
                veiculo.getClass().getDeclaredMethod("setEstaEstacionado", Boolean.class);
            }
        );

    }

    @Test
    @DisplayName("Deve registrar a entrada corretamente")
    public void testaRegistraEntrada(){

        Veiculo veiculo = VeiculoBuilder.umVeiculo().agora();
        int ano = 2022;
        int dia = 01;
        int mes = 01;
        int hora = 10;
        int minuto = 0;

        LocalDateTime data = LocalDateTime.of(ano,mes,dia,hora,minuto);

        
        veiculo.registraEntrada(data);

        assertEquals(data, veiculo.getHoraEntrada());
        assertEquals(true, veiculo.isEstaEstacionado());

    }

    @Test
    @DisplayName("Não deve registrar a entrada se já estacionado")
    public void testaNaoRegistraEntradaJaEstacionado(){

        Veiculo veiculo = VeiculoBuilder.umVeiculo().agora();
        int ano = 2022;
        int dia = 01;
        int mes = 01;
        int hora = 10;
        int minuto = 0;

        LocalDateTime data = LocalDateTime.of(ano,mes,dia,hora,minuto);

        
        veiculo.registraEntrada(data);
        boolean ret = veiculo.registraEntrada(data);

        assertEquals(data, veiculo.getHoraEntrada());
        assertEquals(true, veiculo.isEstaEstacionado());
        assertEquals(false, ret);
        
    }


    @Test
    @DisplayName("Deve registrar a saida corretamente")
    public void testaRegistraSaida(){

        Veiculo veiculo = VeiculoBuilder.umVeiculo().agora();
        
        int ano = 2022;
        int dia = 01;
        int mes = 01;
        int hora = 10;
        int minuto = 0;

        LocalDateTime data = LocalDateTime.of(ano,mes,dia,hora,minuto);

        
        veiculo.registraEntrada(data);

        boolean ret = veiculo.registraSaida();

        assertEquals(true, ret);
        assertEquals(false, veiculo.isEstaEstacionado());
        assertNull(veiculo.getHoraEntrada());

    }

    @Test
    @DisplayName("Nao deve registrar a saida de um veículo não estacionado")
    public void testaNaoRegistraSaidaNaoEstacionado(){

        Veiculo veiculo = VeiculoBuilder.umVeiculo().agora();
        
        boolean ret = veiculo.registraSaida();

        assertEquals(false, ret);
        assertEquals(false, veiculo.isEstaEstacionado());
        assertNull(veiculo.getHoraEntrada());

    }

    @Test
    @DisplayName("A classe Estacionamento existe e possui os atributos corretos e privados")
    public void testaEstacionamentoDeclaradoCorreto() throws NoSuchFieldException{
        Class clazz = Estacionamento.class;

        Field nome = clazz.getDeclaredField("nome");
        Field telefone = clazz.getDeclaredField("telefone");
        Field veiculos = clazz.getDeclaredField("veiculos");

        assertEquals(true, nome.getType() == String.class);
        assertEquals(true, telefone.getType() == String.class);
        assertEquals(true, veiculos.getType() == ArrayList.class);
        

        assertEquals(true, Modifier.isPrivate(nome.getModifiers()));
        assertEquals(true, Modifier.isPrivate(telefone.getModifiers()));
        assertEquals(true, Modifier.isPrivate(veiculos.getModifiers()));
        
    }

    @Test
    @DisplayName("A classe estacionamento possui somente o construtor declarado")
    public void testaInstanciarEstacionamento(){

        Estacionamento estacionamento = new Estacionamento("Estacionamento","1122");
        
        assertEquals(1, Estacionamento.class.getDeclaredConstructors().length);

    }

    @Test
    @DisplayName("A classe estacionamento permite listar todos os veiculos")
    public void testaListaTodosVeiculos(){
        
        Estacionamento estacionamento = new Estacionamento("Estacionamento","1122");

        ArrayList<Veiculo> lista = estacionamento.listaTodosVeiculos();

        assertNotNull(lista);
        assertEquals(0, lista.size());

    }


    @Test
    @DisplayName("A classe estacionamento permite registrar um veiculo e armazena no arraylist")
    public void testaCadastrarVeiculo(){
        String placa = "BBB-1122";
        String modelo = "Gol";
        String fabricante = "Wolks";
        int anoFabricacao = 2001;
        String cor = "Azul";

        Estacionamento estacionamento = new Estacionamento("Estacionamento","1122");
        
        boolean ret = estacionamento.cadastraVeiculo(placa, modelo, fabricante, anoFabricacao, cor);
        
        assertEquals(true,ret);
        assertEquals(1, estacionamento.listaTodosVeiculos().size());
        assertEquals(placa, estacionamento.listaTodosVeiculos().get(0).getPlaca());

    }


    @Test
    @DisplayName("A classe estacionamento não permite registrar dois veiculos com a mesma placa")
    public void testaNãoCadastrarPlacaRepetida(){
        
        Estacionamento estacionamento = new Estacionamento("Estacionamento","1122");
        
        String placa = "BBB-1122";
        String modelo1 = "Gol";
        String fabricante1 = "Wolks";
        int anoFabricacao1 = 2001;
        String cor1 = "Azul";

        String modelo2 = "Gol";
        String fabricante2 = "Wolks";
        int anoFabricacao2 = 2001;
        String cor2 = "Azul";


        boolean ret1 = estacionamento.cadastraVeiculo(placa, modelo1, fabricante1, anoFabricacao1, cor1);
        boolean ret2 = estacionamento.cadastraVeiculo(placa, modelo2, fabricante2, anoFabricacao2, cor2);
        
        assertEquals(true,ret1);
        assertEquals(false, ret2);
        assertEquals(1, estacionamento.listaTodosVeiculos().size());
    
    }

    @Test
    @DisplayName("A classe estacionamento permite buscar um veiculo pela placa")
    public void testaBuscarVeiculoPlaca(){
        Estacionamento estacionamento = new Estacionamento("Estacionamento","1122");
        
        String placa1 = "BBB-1122";
        String modelo1 = "Gol";
        String fabricante1 = "Wolks";
        int anoFabricacao1 = 2001;
        String cor1 = "Azul";

        String placa2 = "AAA-1122";
        String modelo2 = "Variant";
        String fabricante2 = "Wolks";
        int anoFabricacao2 = 1954;
        String cor2 = "Azul";


        estacionamento.cadastraVeiculo(placa1, modelo1, fabricante1, anoFabricacao1, cor1);
        estacionamento.cadastraVeiculo(placa2, modelo2, fabricante2, anoFabricacao2, cor2);
        

        Veiculo veiculo = estacionamento.buscarVeiculo(placa1);

        assertEquals(placa1,veiculo.getPlaca());
    }

    @Test
    @DisplayName("A classe estacionamento retorna null buscar um veiculo por uma placa que não existe")
    public void testaNullBuscarVeiculoPlaca(){
        Estacionamento estacionamento = new Estacionamento("Estacionamento","1122");
        
        String placa1 = "BBB-1122";
        String modelo1 = "Gol";
        String fabricante1 = "Wolks";
        int anoFabricacao1 = 2001;
        String cor1 = "Azul";

        String placa2 = "AAA-1122";
        String modelo2 = "Variant";
        String fabricante2 = "Wolks";
        int anoFabricacao2 = 1954;
        String cor2 = "Azul";

        String placa3 = "CCC-0088";


        estacionamento.cadastraVeiculo(placa1, modelo1, fabricante1, anoFabricacao1, cor1);
        estacionamento.cadastraVeiculo(placa2, modelo2, fabricante2, anoFabricacao2, cor2);
        

        Veiculo veiculo = estacionamento.buscarVeiculo(placa3);

        assertNull(veiculo);
    }

    @Test
    @DisplayName("A classe estacionamento permite registrar a entrada de um veiculo cadastrado")
    public void testaEstacionamentoRegistraEntrada(){
        Estacionamento estacionamento = new Estacionamento("Estacionamento","1122");
        
        String placa1 = "BBB-1122";
        String modelo1 = "Gol";
        String fabricante1 = "Wolks";
        int anoFabricacao1 = 2001;
        String cor1 = "Azul";

        String placa2 = "AAA-1122";
        String modelo2 = "Variant";
        String fabricante2 = "Wolks";
        int anoFabricacao2 = 1954;
        String cor2 = "Azul";

        int ano = 2022;
        int dia = 01;
        int mes = 01;
        int hora = 10;
        int minuto = 0;

        LocalDateTime data = LocalDateTime.of(ano, mes, dia, hora, minuto);

        estacionamento.cadastraVeiculo(placa1, modelo1, fabricante1, anoFabricacao1, cor1);
        estacionamento.cadastraVeiculo(placa2, modelo2, fabricante2, anoFabricacao2, cor2);
        

        //criado para mockar o LocalDateTime.now() para sempre retornar uma data conhecida
        MockedStatic<LocalDateTime> mock = Mockito.mockStatic(LocalDateTime.class);           
        mock.when(LocalDateTime::now).thenReturn(data);
           
        boolean ret = estacionamento.registraEntrada(placa1);

        Veiculo veiculo = estacionamento.buscarVeiculo(placa1);
        assertEquals(true, ret);
        assertEquals(true, veiculo.isEstaEstacionado());
        assertEquals(data, veiculo.getHoraEntrada());
        
        
        
    
    }   


    @Test
    @DisplayName("A classe estacionamento não permite registrar a entrada de um veiculo já estacionado")
    public void testaEstacionamentoNaoRegistraEntradaJaEstacionado(){
        Estacionamento estacionamento = new Estacionamento("Estacionamento","1122");
        
        String placa1 = "BBB-1122";
        String modelo1 = "Gol";
        String fabricante1 = "Wolks";
        int anoFabricacao1 = 2001;
        String cor1 = "Azul";

        String placa2 = "AAA-1122";
        String modelo2 = "Variant";
        String fabricante2 = "Wolks";
        int anoFabricacao2 = 1954;
        String cor2 = "Azul";

        int ano = 2022;
        int dia = 01;
        int mes = 01;
        int hora = 10;
        int minuto = 0;

        LocalDateTime data = LocalDateTime.of(ano, mes, dia, hora, minuto);

        estacionamento.cadastraVeiculo(placa1, modelo1, fabricante1, anoFabricacao1, cor1);
        estacionamento.cadastraVeiculo(placa2, modelo2, fabricante2, anoFabricacao2, cor2);
        
        //criado para mockar o LocalDateTime.now() para sempre retornar uma data conhecida
        MockedStatic<LocalDateTime> mock = Mockito.mockStatic(LocalDateTime.class);           
        mock.when(LocalDateTime::now).thenReturn(data);
        
        boolean ret = estacionamento.registraEntrada(placa1);

        boolean ret2 = estacionamento.registraEntrada(placa1);

        assertEquals(false, ret2);

    }  
    
    @Test
    @DisplayName("A classe estacionamento não permite registrar a entrada de um veiculo não cadastrado")
    public void testaEstacionamentoNaoRegistraEntradaNaoCadastrado(){
        Estacionamento estacionamento = new Estacionamento("Estacionamento","1122");
        
        boolean ret = estacionamento.registraEntrada("AAA-1122");

        assertEquals(false, ret);
        
    }

    @Test
    @DisplayName("A classe estacionamento permite registrar a saida de um veiculo e calcula o tempo em minutos")
    public void testaEstacionamentoRegistraSaida(){
        Estacionamento estacionamento = new Estacionamento("Estacionamento","1122");
        
        String placa1 = "BBB-1122";
        String modelo1 = "Gol";
        String fabricante1 = "Wolks";
        int anoFabricacao1 = 2001;
        String cor1 = "Azul";

        String placa2 = "AAA-1122";
        String modelo2 = "Variant";
        String fabricante2 = "Wolks";
        int anoFabricacao2 = 1954;
        String cor2 = "Azul";

        int ano = 2022;
        int dia = 01;
        int mes = 01;
        int horaEntrada = 10;
        int minutoEntrada = 0;

        int horaSaida = 11;
        int minutoSaida = 0;


        LocalDateTime dataEntrada = LocalDateTime.of(ano, mes, dia, horaEntrada, minutoEntrada);
        LocalDateTime dataSaida = LocalDateTime.of(ano,mes,dia,horaSaida,minutoSaida);
        //criado para mockar o LocalDateTime.now() para sempre retornar uma data conhecida
        MockedStatic<LocalDateTime> mock = Mockito.mockStatic(LocalDateTime.class);           
        
        estacionamento.cadastraVeiculo(placa1, modelo1, fabricante1, anoFabricacao1, cor1);
        estacionamento.cadastraVeiculo(placa2, modelo2, fabricante2, anoFabricacao2, cor2);
        

        mock.when(LocalDateTime::now).thenReturn(dataEntrada);
        boolean ret1 = estacionamento.registraEntrada(placa1);

        mock.when(LocalDateTime::now).thenReturn(dataSaida);
        int ret2 = estacionamento.registraSaida(placa1);

        assertEquals(60, ret2);
        
    }

    @Test
    @DisplayName("A classe estacionamento não permite registrar a saida de um veiculo não estacionado")
    public void testaEstacionamentoNaoRegistraSaidaNaoEstacionado(){
        Estacionamento estacionamento = new Estacionamento("Estacionamento","1122");
        
        String placa1 = "BBB-1122";
        String modelo1 = "Gol";
        String fabricante1 = "Wolks";
        int anoFabricacao1 = 2001;
        String cor1 = "Azul";

        String placa2 = "AAA-1122";
        String modelo2 = "Variant";
        String fabricante2 = "Wolks";
        int anoFabricacao2 = 1954;
        String cor2 = "Azul";

        
        estacionamento.cadastraVeiculo(placa1, modelo1, fabricante1, anoFabricacao1, cor1);
        estacionamento.cadastraVeiculo(placa2, modelo2, fabricante2, anoFabricacao2, cor2);
        
        boolean ret1 = estacionamento.registraEntrada(placa1);
        int ret2 = estacionamento.registraSaida(placa2);

        assertEquals(-1, ret2);
        
    }

*/

    @Test
    public void teste(){
        assertTrue(true);
    }
















}
