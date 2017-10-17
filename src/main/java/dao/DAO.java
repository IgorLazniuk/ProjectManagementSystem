package dao;

public interface DAO<T> {
        /*CRUD operations
    C- create
    R - read
    U  - update
    D - delete
    */

    void create(T t);

    T read(int id);

    void update(T t);

    void delete(int id);

}
