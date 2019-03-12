/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testeweka;

import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
import weka.classifiers.bayes.NaiveBayes;
import weka.classifiers.trees.J48;
import weka.classifiers.functions.SMO;

/**
 *
 * @author Aline Dominique
 */
public class Classificadores {
    public static void main(String args []) throws Exception{
        //Load dataset
        DataSource source = new DataSource("/C:/Program Files/Weka-3-8/data/iris.arff");
        Instances dataset = source.getDataSet();
        //Defina o índice de classe para o último atributo
        dataset.setClassIndex(dataset.numAttributes()-1);
        
        //Criar e construir o classificador NaiveBayes
        NaiveBayes nb = new NaiveBayes();
        nb.buildClassifier(dataset);
        //Imprimir suas capacidades
        System.out.println(nb.getCapabilities().toString());
        
        //Criar e construir o classificador SMO
        SMO svm = new SMO();
        svm.buildClassifier(dataset);
        System.out.println(svm.getCapabilities().toString());
        
        //Criar e construir o classificador J48 - Arvore Binária
        String[] opcao = new String[2];
        opcao[0] = "-C"; opcao[1] = "0.11";
        //opcao[2] = "-M"; opcao[3] = "3";
        J48 arvore = new J48();
        arvore.setOptions(opcao);
        arvore.buildClassifier(dataset);
        System.out.println(arvore.getCapabilities().toString());
        System.out.println(arvore.graph());
    }
    
}
