package testLogisticApp;

import java.util.Comparator;

public class PackageComparator implements Comparator<PackageObject> {

    @Override
    public int compare(PackageObject o1, PackageObject o2) {

        if ( o1.getTargetLocation().compareTo(o2.getTargetLocation()) > 0)
            return 1;

        return o1.getDeliveryDate().compareTo(o2.getDeliveryDate());
    }
}
