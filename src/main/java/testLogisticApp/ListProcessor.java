package testLogisticApp;


import lombok.extern.log4j.Log4j;
import testLogisticApp.Entities.DeliveryGroup;
import testLogisticApp.Entities.PackageObject;

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
                    .sorted(Comparator.comparing(PackageObject::getDeliveryDate)
                            .thenComparing(PackageObject::getTargetLocation))

                    .collect(Collectors.toList());
        } catch (IOException e) {
            log.error(e.getMessage());
        }

        // all packages that are delivered to the same location
        // on the same day will be added to a Delivery Group which will be processed separately
        List<DeliveryGroup> deliveryGroupList = new ArrayList<>();

        int lastIndex = 0;
        int firstIndex = 0;

        for (int i = 0; i < packageObjects.size(); i++) {
            if (sameLocationOnSameDate(packageObjects, lastIndex, i)) {
                if (i == packageObjects.size() - 1) {
                    List<PackageObject> transfer = new ArrayList<>(packageObjects.subList(firstIndex, i));
                    transfer.add(packageObjects.get(i));
                    deliveryGroupList.add(new DeliveryGroup(transfer));
                }
                lastIndex = i;
            } else {
                deliveryGroupList.add(new DeliveryGroup(new ArrayList<>(packageObjects.subList(firstIndex, i))));
                if (i == packageObjects.size() - 1) {
                    deliveryGroupList.add(new DeliveryGroup(List.of(packageObjects.get(i))));
                }
                firstIndex = i;
                lastIndex = i;
            }
        }
        return deliveryGroupList;

    }

    private static boolean sameLocationOnSameDate(List<PackageObject> packageObjects, int lastIndex, int i) {
        return packageObjects.get(lastIndex).getTargetLocation()
                .equals(packageObjects.get(i).getTargetLocation())
                && packageObjects.get(lastIndex).getDeliveryDate()
                .equals(packageObjects.get(i).getDeliveryDate());
    }

}
