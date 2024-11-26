package com.manager.expense.repository;

import com.manager.expense.repository.model.Expense;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface ExpenseRepository extends CrudRepository<Expense, UUID> {
}
