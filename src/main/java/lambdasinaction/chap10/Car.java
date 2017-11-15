package lambdasinaction.chap10;

import java.util.*;

public class Car {

    private Optional<Insurance> insurance;

    public void setInsurance(Optional<Insurance> insurance) {
        this.insurance = insurance;
    }

    public Optional<Insurance> getInsurance() {
        return insurance;
    }
}
