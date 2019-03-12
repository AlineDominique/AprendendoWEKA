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
import weka.filters.unsupervised.instance.NonSparseToSparse;

/**
 *
 * @author Aline Dominique
 */
public class SparseFiltro {
    public static void main(String args []) throws Exception{
        //load dataset
        DataSource source = new DataSource("/C:/Users/Alison Arnon/Desktop/sparse.arff");
        Instances dataset = source.getDataSet();
        //criar um objeto NonSparseToSparse e salvar em formato arff
        NonSparseToSparse sp = new NonSparseToSparse();
        // especifica o dataset a ser usado
        sp.setInputFormat(dataset);

        //aplica o filtro no dataset
        Instances newData = Filter.useFilter(dataset, sp);
        //salva o arquivo
        ArffSaver salvo = new ArffSaver();
        salvo.setInstances(newData);
        salvo.setFile(new File("src/Documentos/SparseFiltro.arff"));
        salvo.writeBatch();
    }
}
