package com.tracker;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class FinanceController {

    private final List<Transaction> transactions = new ArrayList<>();

    @GetMapping("/")
    public String home(Model model) {
        double totalIncome = transactions.stream()
                .filter(t -> "INCOME".equals(t.getType()))
                .mapToDouble(Transaction::getAmount)
                .sum();

        double totalExpense = transactions.stream()
                .filter(t -> "EXPENSE".equals(t.getType()))
                .mapToDouble(Transaction::getAmount)
                .sum();

        double balance = totalIncome - totalExpense;

        model.addAttribute("transactions", transactions);
        model.addAttribute("totalIncome", totalIncome);
        model.addAttribute("totalExpense", totalExpense);
        model.addAttribute("balance", balance);
        return "index";
    }

    @PostMapping("/add")
    public String addTransaction(@RequestParam String title,
                                 @RequestParam double amount,
                                 @RequestParam String type) {
        transactions.add(new Transaction(title, amount, type));
        return "redirect:/";
    }
}
