package units;

import common.Settings;
import enums.Gender;
import exception.EvalutionException;
import org.apache.commons.lang3.StringUtils;
import units.disease.Disease;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public final class UnitFactory {

    private final static Random random = new Random();

    private UnitFactory() {

    }

    public static People createPeople(Gender gender, String name, People father, People mother, List<Disease> disease) {
        if (StringUtils.isBlank(name)) {
            throw new EvalutionException("Имя человека не может быть пустым");
        }

        // Первое условие - для кейса инициализации людей
        if (!(father == null & mother == null)) {
            if (father == null || mother == null) {
                throw new EvalutionException("Должно быть оба родителя");
            }
        }

        Family family = new Family()
                .setMother(mother)
                .setFather(father)
                .addAllBrothersAndSisters(mother != null ? mother.getFamily().getChilds() : null)
                .addAllBrothersAndSisters(father != null ? father.getFamily().getChilds() : null);

        if (gender == null) {
            int proto = new Random().nextInt(2);
            gender = proto == 0 ? Gender.M : Gender.F;
        }

        return (People) new People()
                .setFamily(family)
                .setAge(0)
                .setNameUnit(name)
                .setGender(gender)
                .addDisease(disease);
    }

    /**
     * Инициализация первых людей в мире
     * Первые люди считаются первыми в роду
     *
     * @return первые люди
     */
    public static List<Unit> initFirstPeoples() {
        List<Unit> newUnits = new ArrayList<>();
        List<Disease> diseases = new ArrayList<>();

        do {
            Gender gender = random.nextInt(2) == 0 ? Gender.M : Gender.F;
            String name = "Василий";
            // TODO блок с болячками
            newUnits.add(createPeople(gender, name, null, null, diseases));
        } while (newUnits.size() != Settings.getBeginNumberOfUnits());

        return newUnits;
    }
}
