/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testeweka;

import weka.experiment.Stats;
import weka.core.AttributeStats;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

/**
 *
 * @author Aline Dominique
 */
public class AtributosEInstancias {
    public static void main(String args []) throws Exception{
        //Load do dataset
        DataSource source = new DataSource("/C:/Program Files/Weka-3-8/data/weather.nominal.arff");
        //Pegas as instancias do objeto
        Instances data = source.getDataSet();
        //Definir o index da classe com o último atributo
        if (data.classIndex() == -1){
            data.setClassIndex(data.numAttributes() - 1);
        }
        //pegar o número do atributos(notar que a classe não conta)
        int numAtr = data.numAttributes() - 1;
        for(int i = 0; i < numAtr; i++){
            //verifique se o atrito atual é do tipo nominal
            if(data.attribute(i).isNominal()){
                System.out.println("O "+i+" th atributo é Nominal.");
                //pegar o número do valor
                int n = data.attribute(i).numValues();
                System.out.println("O "+i+" th o atributo tem o valor: "+n);
            }
            //pegar o AttributeStats object
            AttributeStats atrSt = data.attributeStats(i);
            int dC = atrSt.distinctCount;
            System.out.println("O "+i+" th atributo tem o valor distinto "+dC);
            
            //pegar o objeto Stats do AttributeStats
            if (data.attribute(i).isNumeric()){
                System.out.println("O "+i+" th atributo é numerico");
                Stats s = atrSt.numericStats;
                System.out.println("O "+i+"th o atributo tem o mínimo valor: "+s.min+" ,o maximo valor "+s.max+ " média "+s.mean);
            }
        }
        //Pegar o número da Instancia
        int numInst = data.numInstances();
        //percorrer todas as instâncias
        for (int j = 0; j < numInst; j++){
            //pegar o j'th instance
            Instance instancia = data.instance(j);
            //checar se primeiro atributo está perdido da instancia 
            if(instancia.isMissing(0)){
                System.out.println("O "+0+" atributo está perdido.");
            }
            //checar se a classe está perdida da instancia j
            if(instancia.classIsMissing()){
                System.out.println("O classe está perdida da intancia "+j);
            }
            //Se você quiser o acesso ao valor da classe em seu dataset
            //Observe que as classes do tipo nominal e String dão ID's
            double cV = instancia.classValue();
            System.out.println(instancia.classAttribute().value((int)cV));
        }
    }
}
