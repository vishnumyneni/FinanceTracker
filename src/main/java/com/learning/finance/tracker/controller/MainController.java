package com.learning.finance.tracker.controller;

import com.learning.finance.tracker.model.Transaction;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/financeTracker")
public class MainController {
    @GetMapping("/health")
    public String healthCheck() {
        return "I am OK :)";
    }

    @PostMapping("/addTransaction")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "202", description = "Transaction added successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid transaction data"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @Operation(summary = "Add a new transaction", description = "This endpoint allows you to add a new financial transaction.")
    public ResponseEntity<Transaction> addTransaction(@RequestBody Transaction transaction) {
        return ResponseEntity.accepted().body(transaction);
    }

    @DeleteMapping("/deleteTransaction/{id}")
    public ResponseEntity<String> deleteTransaction(@PathVariable String id) {
        // This is a placeholder. In a real application, you would delete the transaction from a database.
        return ResponseEntity.ok("Transaction with ID " + id + " deleted successfully.");
    }

    @GetMapping("/getTransactions")
    public List<Transaction> getTransactions() {
        // This is a placeholder. In a real application, you would retrieve transactions from a database.
        return List.of(
                new Transaction("1", "Expense", "Electricity", 50.0, new Date(), "Electricity Bill"),
                new Transaction("2", "Expense", "Rent", 100.0, new Date(), "Monthly rent payment")
        );
    }
}
