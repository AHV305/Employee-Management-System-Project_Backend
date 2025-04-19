package com.ahv.banking.mapper;

import com.ahv.banking.Dto.AccountDto;
import com.ahv.banking.entity.Account;

public class AccountMapper {

	public static Account mapToAccount(AccountDto accountDto) {
		Account account = new Account(
				accountDto.id(), 
				accountDto.accountHolderName(),
				accountDto.balance());
		return account;
	}

	public static AccountDto mapToAccountDto(Account account) {
		AccountDto accountDto = new AccountDto(account.getId(), 
				account.getAccoutnHolderName(), 
				account.getBalance());
		return accountDto;
	}
}