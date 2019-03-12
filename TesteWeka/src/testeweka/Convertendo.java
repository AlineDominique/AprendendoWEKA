/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testeweka;

import java.io.File;
import weka.core.Instances;
import weka.core.converters.ArffLoader;
import weka.core.converters.ArffSaver;
import weka.core.converters.CSVLoader;
import weka.core.converters.CSVSaver;



/**
 *
 * @author Aline Dominique
 */
//Convertendo CSV para Arff
public class Convertendo {
    public static void main(String args[])throws Exception{
        /*Cria-se um objeto para receber o arquivo em csv e transforma-lo em
        dataset*/
        CSVLoader loader = new CSVLoader();
        loader.setSource(new File("/C:/Users/Alison Arnon/Desktop/FaculdadeECoisas/Bruxaria com Pandas/2012.csv"));
        //System.out.println(loader);
        Instances data = loader.getDataSet();
        
        /*Cria-se um objeto para saalvar o DataSet no formato Arff*/
        ArffSaver saver = new ArffSaver();
        saver.setInstances(data);
        saver.setFile(new File("src/Documentos/ConvArff.arff"));
        saver.writeBatch();
        
        
        /*Converteção de Arff para CSV*/
        ArffLoader load = new ArffLoader();
        load.setSource(new File("src/Documentos/ConvArff.arff"));
        Instances data1 = load.getDataSet();
        CSVSaver salvo = new CSVSaver();
        salvo.setInstances(data1);
        salvo.setFile(new File("src/Documentos/ConvCSV.csv"));
        salvo.writeBatch();
     }
}
