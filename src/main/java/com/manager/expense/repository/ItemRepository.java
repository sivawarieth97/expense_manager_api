package com.manager.expense.repository;

import com.manager.expense.repository.model.Item;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface ItemRepository extends CrudRepository<Item, UUID> {

    @Query(value = "select * from Item where expense_id=:expenseID", nativeQuery = true)
    public Iterable<Item> findByExpenseId(@Param("expenseID") UUID expenseID);
}
