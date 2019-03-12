/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testeweka;

import java.io.File;
import weka.core.Instances;
import weka.core.converters.ArffSaver;
import weka.core.converters.ConverterUtils.DataSource;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.Remove;

/**
 *
 * @author Aline Dominique
 */
public class Filtrando {
    public static void main(String args []) throws Exception{
    //load dataset
    DataSource source = new DataSource("src/testeweka/weather.nominal.arff");
    Instances dataset = source.getDataSet();
    
    //uso de um filtro simples que remove certo atributo
    //o set up opções remove segundo atributo
    String [] opts = new String[]{"-R","4"};// Para remover é necessário ser em pares,
    //primeiro parametro é o nome da opção e segundo é o atributo a ser removido
    //criação do remover objeto (este é o filtro da Classe)
    Remove remove = new Remove();
    //set as opções do filtro
    remove.setOptions(opts);
    //passar o dataset para no filtro
    remove.setInputFormat(dataset);
    //aplicar o filtro
    Instances newData = Filter.useFilter(dataset, remove);
    
    //Agora salva o dataset em um novo arquivo
    ArffSaver salva = new ArffSaver();
    salva.setInstances(newData);
    salva.setFile(new File("src/Documentos/Filtro.arff"));
    salva.writeBatch();
    }
}
