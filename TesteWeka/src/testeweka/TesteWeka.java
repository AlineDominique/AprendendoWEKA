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
import weka.core.converters.ConverterUtils.DataSource;

/**
 *
 * @author Aline Dominique
 */
public class TesteWeka {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
       // Criando DataSource: onde será carregada a vbase de dados       
       DataSource ds = new DataSource("src/testeweka/vendas.arff");
       //Cria se um objeto que armazena todas as instâncias existente da base de
       //da dodos
       Instances ins = ds.getDataSet();
        //System.out.println(ins.toString());
        
        //Primeiro necessário saber quando objeto a ser utilizado na previsão
        //então busca a classe responsável utlizando o metodo abaixo.
        ins.setClassIndex(3);
        
        // Cria-se o objeto responsável pelo Classificador  
        NaiveBayes nb = new NaiveBayes();
        // Constroe o classificador
        nb.buildClassifier(ins);
        
        // Nova instacia que será utilizada para previsão
        Instance novo = new DenseInstance(4);
        novo.setDataset(ins);
        novo.setValue(0,"M");
        novo.setValue(1,">=40");
        novo.setValue(2,"Sim");
        
        double probabilidade [] = nb.distributionForInstance(novo);
        System.out.println("Sim: " + probabilidade[1]);
        System.out.println("Não: " + probabilidade[0]);
        
        SalvandoDatabase db = new SalvandoDatabase();
        System.out.println(db);
    }
    
}
