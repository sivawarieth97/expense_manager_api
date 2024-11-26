package com.manager.expense.service;

import com.manager.expense.repository.model.Expense;
import com.manager.expense.repository.model.Item;
import com.manager.expense.controller.model.RequestExpense;
import com.manager.expense.controller.model.RequestItem;
import com.manager.expense.repository.ExpenseRepository;
import com.manager.expense.repository.ItemRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ExpenseManagerService {

    private final ExpenseRepository expenseRepository;
    private final ItemRepository itemRepository;
    Logger log
            = LoggerFactory.getLogger(ExpenseManagerService.class);

    public ExpenseManagerService(ExpenseRepository expenseRepository, ItemRepository itemRepository) {
        this.expenseRepository = expenseRepository;
        this.itemRepository = itemRepository;
    }

    public Expense addExpense(RequestExpense requestExpense) {

        Expense expense = new Expense();
        expense.setExpenseName(requestExpense.getExpenseName());
        expense.setTotalAmount(requestExpense.getTotalAmount());
        this.expenseRepository.save(expense);
        return expense;
    }

    public Iterable<Expense> getAllExpense() {
        return this.expenseRepository.findAll();
    }

    public void addItemsForExpense(UUID expenseId, List<RequestItem> itemList) {

        if(this.expenseRepository.findById(expenseId).isEmpty()) return;
        for(RequestItem requestItem : itemList) {
            Item item = new Item();
            item.setItemName(requestItem.getItemName());
            item.setQuantity(requestItem.getQuantity());
            item.setPrice(requestItem.getPrice());
            item.setExpenseID(expenseId);
            this.itemRepository.save(item);
        }

    }

    public Iterable<Item> getAllItems(UUID expenseId) {
        return this.itemRepository.findByExpenseId(expenseId);
    }

}
