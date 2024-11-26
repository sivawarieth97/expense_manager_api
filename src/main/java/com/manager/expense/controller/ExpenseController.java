package com.manager.expense.controller;

import com.manager.expense.controller.model.RequestExpense;
import com.manager.expense.controller.model.RequestItem;
import com.manager.expense.repository.model.Expense;
import com.manager.expense.repository.model.Item;
import com.manager.expense.service.ExpenseManagerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class ExpenseController {

    private final ExpenseManagerService expenseManagerService;
    Logger log
            = LoggerFactory.getLogger(ExpenseManagerService.class);

    public ExpenseController(ExpenseManagerService expenseManagerService) {
        this.expenseManagerService = expenseManagerService;
    }

    @PostMapping("/expense")
    public Expense addExpense(@RequestBody RequestExpense expense) {
        return expenseManagerService.addExpense(expense);
    }

    @PutMapping("/expense/{expenseId}")
    public void updateItemExpense(@PathVariable("expenseId") UUID expenseId, @RequestBody List<RequestItem> requestItemList) {

        expenseManagerService.addItemsForExpense(expenseId, requestItemList);
    }

    @GetMapping("/expense/{expenseId}/items")
    public Iterable<Item> getItemsForExpenseId(@PathVariable UUID expenseId) {
        return expenseManagerService.getAllItems(expenseId);
    }
    

    @GetMapping("/")
    public Iterable<Expense> getExpense() {
        return expenseManagerService.getAllExpense();
    }

    @GetMapping("/{Id}")
    public Iterable<Expense> getExpense(@PathVariable String Id) {
        return expenseManagerService.getAllExpense();
    }

}

