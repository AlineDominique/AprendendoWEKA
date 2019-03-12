/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testeweka;

import weka.core.Instances;
import weka.core.converters.ArffSaver;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import weka.core.converters.ConverterUtils.DataSource;

/**
 *
 * @author Aline Dominique
 */
public class SalvandoDatabase {
    public static void main(String args[])throws Exception{
        //DataSource source = new DataSource("src/testeweka/weather.nominal.arff");
        //Instances dataset = source.getDataSet();
        /*Esta parte do código é realizado o upload do arquivo arff no obejto dataset e abaixo imprimi os valores*/
        Instances dataset = new Instances(new BufferedReader(new FileReader("src/testeweka/weather.nominal.arff")));
        System.out.println(dataset.toSummaryString());
        
        /*Este trecho do código criei um objeto para salvar o dataset criando anteriormente
        Preciso verificar o problema com o caminho que passo fora doambiente*/
        ArffSaver salva = new ArffSaver();
        salva.setInstances(dataset);
        salva.setFile(new File("src/testeweka/novo.arff"));
        salva.writeBatch();
    }
}
