package testLogisticApp;

import lombok.extern.log4j.Log4j;
import testLogisticApp.Entities.DeliveryGroup;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Log4j
public class LogisticsAppMain {

    public static void main(String[] args) {


        String separator = File.separator;
        String fileLocation = "src" + separator + "main" + separator + "resources" + separator;
        Path file = Paths.get(fileLocation + "inputCSV.txt");

        List<DeliveryGroup> packageObjectList = ListProcessor.CSVFileToPackage(file);

        for ( DeliveryGroup tempList : packageObjectList){
            Thread deliveryRun = new Thread(new DeliveryRunnable(tempList));
            deliveryRun.start();
            try {
                deliveryRun.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}

