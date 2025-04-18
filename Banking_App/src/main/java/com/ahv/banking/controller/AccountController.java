package com.ahv.banking.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ahv.banking.Dto.AccountDto;
import com.ahv.banking.service.AccountService;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

	@Autowired
	private AccountService accountService;
	
	public AccountController(AccountService accountService) {
		super();
		this.accountService = accountService;
	}

	@PostMapping
	public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto){
		return new ResponseEntity<>(accountService.createAccount(accountDto), HttpStatus.CREATED);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<AccountDto> getAccountById(@PathVariable("id") Long id){
		AccountDto accountDto= accountService.getAccountById(id);
		return  ResponseEntity.ok(accountDto);
	}
	
	@PutMapping("/{id}/deposit")
	public ResponseEntity<?> deposit(@PathVariable Long id, @RequestBody Map<String, Double>request){
		Double amount=	request.get("amount");
		if (amount == null) {
			Map<String, String> errorResponse = new HashMap<>();
			errorResponse.put("message", "Amount is null");
		    return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
		  }
		AccountDto accountDto =accountService.deposit(id, amount);
		return ResponseEntity.ok(accountDto);
	}
	
	@PutMapping("/{id}/withdraw")
	public ResponseEntity<AccountDto> withdraw(@PathVariable Long id, 
												@RequestBody Map<String, Double> request){
		double amount=request.get("amount");
		AccountDto accountDto = accountService.withdraw(id, amount);
		return ResponseEntity.ok(accountDto);
	}
	
	@GetMapping
	public ResponseEntity<List<AccountDto>> getAllAccounts(){
		List<AccountDto> accounts = accountService.getAllAccounts();
		return ResponseEntity.ok(accounts);
		}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String>deleteAccount(@PathVariable Long id){
		accountService.deleteAccount(id);
		return ResponseEntity.ok("Account deleted succesfully");
	}
}
