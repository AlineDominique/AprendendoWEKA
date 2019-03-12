/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testeweka;

import weka.attributeSelection.GreedyStepwise;
import weka.core.Instances;
import weka.filters.Filter;
import weka.filters.supervised.attribute.AttributeSelection;
import weka.core.converters.ArffSaver;
import java.io.File;
import weka.attributeSelection.CfsSubsetEval;
import weka.core.converters.ConverterUtils.DataSource;

/**
 *
 * @author Aline Dominique
 */
public class SelaciandoAtributo {
    public static void main(String args []) throws Exception{
        //load DataSet
        DataSource source = new DataSource("src/testeweka/weather.nominal.arff");
        Instances dataset = source.getDataSet();
        //Criando o objeto AttributeSelection
        AttributeSelection filtro = new AttributeSelection();
        //Criando o objeto do avaliador e pesquisador de algoritmo
        CfsSubsetEval avaliador = new CfsSubsetEval();
        GreedyStepwise pesquisador = new GreedyStepwise();
        //Definindo o algoritmo de pesquisa 
        pesquisador.setSearchBackwards(true);
        //Definindo o filtro a ser usado no avaliador e pesquisador 
        filtro.setEvaluator(avaliador);
        filtro.setSearch(pesquisador);
        //Especificando o dataset a ser utilizado
        filtro.setInputFormat(dataset);
        //Aplicação do metodo no dataset
        Instances newData = Filter.useFilter(dataset, filtro);
        
        //Salvar o novo dataset
        ArffSaver salvo = new ArffSaver();
        salvo.setInstances(newData);
        salvo.setFile(new File("src/Documentos/SelecaoAtributo.arff"));
        salvo.writeBatch();
    }
}
