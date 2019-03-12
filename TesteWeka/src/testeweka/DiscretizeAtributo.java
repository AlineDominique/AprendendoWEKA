/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testeweka;

import weka.core.Instances;
import weka.core.converters.ArffSaver;
import java.io.File;
import weka.core.converters.ConverterUtils.DataSource;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.Discretize;

/**
 *
 * @author Aline Dominique
 */
public class DiscretizeAtributo {
    public static void main(String args []) throws Exception{
        //load dataset
       DataSource source = new DataSource("/C:/Users/Alison Arnon/Desktop/sparse.arff");
       Instances dataset = source.getDataSet();
       // settar opção
       String[] opcao = new String[4];
       //Escolher o número do intervalo, ex: 2
       opcao[0] = "-B";
       opcao[1] = "4";
       //Escolher os atributos em que o filtro será aplicado
       opcao[2] = "-R";
       opcao[3] = "1-4";
       
       //Aplicar o Discretization
       Discretize discretize = new Discretize();
       discretize.setOptions(opcao);
       discretize.setInputFormat(dataset);
       Instances newData = Filter.useFilter(dataset, discretize);
       
       ArffSaver salvo = new ArffSaver();
       salvo.setInstances(newData);
       salvo.setFile(new File("src/Documentos/DiscretizeFiltro.arff"));
       salvo.writeBatch();
    }
}
