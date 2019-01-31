package hospital;

import hospital.model.Hospital;
import hospital.model.Pacient;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static String csvFile = "src/hospital/data/Hospital.csv";

    public static void main(String[] args) {
        Hospital hospital = new Hospital();
        List<Pacient> p = new ArrayList<>();

       p.addAll(hospital.loadPacients(csvFile));


    }

}
