package testLogisticApp;


import lombok.extern.log4j.Log4j;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Log4j
public class ListProcessor {

    public static List<DeliveryGroup> CSVFileToPackage(Path fileLocation) {

        List<PackageObject> packageObjects = new ArrayList<>();
        try {
            packageObjects = Files.lines(fileLocation)
                    .map(line -> Arrays.asList(line.split(",")))
                    .filter(s -> s.size() > 1)
                    .map(strings -> PackageObject.builder()
                            .targetLocation(strings.get(0))
                            .distance(Integer.parseInt(strings.get(1)))
                            .value(Double.parseDouble(strings.get(2)))
                            .deliveryDate(LocalDate.parse(strings.get(3)))
                            .build())
                    .sorted(Comparator.comparing((PackageObject p1) -> p1.getDeliveryDate())
                            .thenComparing(p -> p.getTargetLocation()))

                    .collect(Collectors.toList());
        } catch (IOException e) {
            log.error(e.getMessage());
        }

        List<DeliveryGroup> deliveryGroupList = new ArrayList<>();

        for (int i = 0; i < packageObjects.size() - 1; i++) {
//          Creating new temp list to store all elements that have the same destination and date as the current index
            List<PackageObject> tempList = new ArrayList<>();
            tempList.add(packageObjects.get(i));
            for (int j = i + 1; j < packageObjects.size(); j++) {

                if (packageObjects.get(j).getTargetLocation()
                        .equals(packageObjects.get(i).getTargetLocation())
                        && packageObjects.get(j).getDeliveryDate()
                        .equals(packageObjects.get(i).getDeliveryDate())) {
                    tempList.add(packageObjects.get(j));
                    if ( j== packageObjects.size()-1){
                        deliveryGroupList.add(new DeliveryGroup(tempList));
                        i=j-1;
                        break;
                    }
                } else {
//              Once the equality condition is false, we store the List constructed until now in the Delivery Group List.
                    i = j-1;
                    deliveryGroupList.add(new DeliveryGroup(tempList));
                    break;
                }

            }
        }
        return deliveryGroupList;

    }

}
