package es.sarman.jpatestddl.SeedFactories;

import com.github.javafaker.Faker;
import org.springframework.data.repository.PagingAndSortingRepository;

public abstract class BaseSeedFactory<EntityClass, EntityIdType, RepositoryType extends PagingAndSortingRepository<EntityClass, EntityIdType>> {

    protected final Faker faker;
    RepositoryType repository;

    protected BaseSeedFactory(RepositoryType repository) {
        this.faker = new Faker();
        this.repository = repository;
    }

    protected abstract boolean customSeed ();
    protected abstract EntityClass makeEntityInstance();

    public void generateNInstances (int amount) {
        if (!customSeed()) {
            return;
        }

        for (int i = 0; i < amount; i++) {
            repository.save(makeEntityInstance());
        }
    }

}
