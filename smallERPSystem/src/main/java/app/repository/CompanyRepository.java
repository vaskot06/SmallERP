package app.repository;

import app.domain.entities.Company;

public interface CompanyRepository {

    void save (Company company);

    Company findByName(String name);

    void update(Company company);
}
