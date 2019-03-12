/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testeweka;

import weka.classifiers.bayes.NaiveBayes;
import weka.core.DenseInstance;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils;

/**
 *
 * @author Alison Arnon
 */
public class TestaWekaDB {
    
    public static void main(String[] args) throws Exception {
       // Criando DataSource: onde será carregada a vbase de dados       
       ConverterUtils.DataSource ds = new ConverterUtils.DataSource("/C:/Users/Alison Arnon/Desktop/Dados_logistica_filtrado_2017_1_com_competencias_csv.arff");
       //Cria se um objeto que armazena todas as instâncias existente da base de
       //da dodos
       Instances ins = ds.getDataSet();
       //System.out.println(ins.toString());
        
        //Primeiro necessário saber quando objeto a ser utilizado na previsão
        //então busca a classe responsável utlizando o metodo abaixo.
        ins.setClassIndex(45);
        
        // Cria-se o objeto responsável pelo Classificador  
        NaiveBayes nb = new NaiveBayes();
        // Constroe o classificador
        nb.buildClassifier(ins);
        
        // Nova instacia que será utilizada para previsão
        Instance novo = new DenseInstance(46);
        novo.setDataset(ins);
        novo.setValue(0,25);
        novo.setValue(1,"Masculino");
        novo.setValue(2,"Solteiro(a)");
        novo.setValue(3,"Moto");
        novo.setValue(4,"Casa");
        novo.setValue(5,"Entre_30_minutos_e_1_hora");
        novo.setValue(6,"Sozinho(a)");
        novo.setValue(7,"Um");
        novo.setValue(8,"Trabalha_e_estuda");
        novo.setValue(9,"Trabalha_numa_area_diferente_da_do_curso");
        novo.setValue(10,"De_um_a_dois_salarios_minimos_(entre_R$937_e_R$1.874)");
        novo.setValue(11,"Trabalho_sou_responsavel_por_meu_proprio_sustento_e_ainda_contribuo_parcialmente_para_o_sustento_da_familia");
        novo.setValue(12,"Uma");
        novo.setValue(13,"Ensino_medio_completo");
        novo.setValue(14,"Sim_ambos_por_inteiro");
        novo.setValue(15,"Ensino_medio_completo");
        novo.setValue(16,"Ensino_medio_completo");
        novo.setValue(17,"e_aposentado");
        novo.setValue(18,"e_aposentado");
        novo.setValue(19,"Negro");
        novo.setValue(20,"Nao");
        novo.setValue(21,"Nao_sei_informar");
        novo.setValue(22,"Mais_de_5_anos");
        novo.setValue(23,"Nao_sei_informar");
        novo.setValue(24,9);
        novo.setValue(25,"Boa");
        novo.setValue(26,1);
        novo.setValue(27,3);
        novo.setValue(28,2);
        novo.setValue(29,2);
        novo.setValue(30,1);
        novo.setValue(31,4);
        novo.setValue(32,"Nao_nunca_leio");
        novo.setValue(33,"Infelizmente_nao_tenho_o_habito_da_leitura");
        novo.setValue(34,"Nao");
        novo.setValue(35,"Sim");
        novo.setValue(36,"Redes_Sociais_Outros");
        novo.setValue(37,"Nao");
        novo.setValue(38,"Internet");
        novo.setValue(39,18);
        novo.setValue(40,10);
        novo.setValue(41,5);
        novo.setValue(42,12);
        novo.setValue(43,14);
        novo.setValue(44,8);
        
        double probabilidade [] = nb.distributionForInstance(novo);
        System.out.println("Sim: " + probabilidade[1]);
        System.out.println("Não: " + probabilidade[0]);
        
        SalvandoDatabase db = new SalvandoDatabase();
        System.out.println(db);
    }
}
