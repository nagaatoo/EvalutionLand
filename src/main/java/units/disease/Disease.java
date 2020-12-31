package units.disease;

import java.util.Objects;
import java.util.UUID;

// TODO create factory and pull
public class Disease {

    // Уникальный идентификатор болезни.
    private final UUID id = UUID.randomUUID();

    // наименование болезни
    private String name;

    // Хроническая
    private boolean isChronic = false;

    // Генетическая
    private boolean isGenetic = false;

    // Вероятность смерти
    private float deathPercent = 0.0f;

    // Количество стадий развития болезни. Не может быть 0
    private int numberOfStages = 1;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Disease disease = (Disease) o;
        return isChronic == disease.isChronic && isGenetic == disease.isGenetic && Float.compare(disease.deathPercent, deathPercent) == 0 && numberOfStages == disease.numberOfStages && Objects.equals(name, disease.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, isChronic, isGenetic, deathPercent, numberOfStages);
    }
}
