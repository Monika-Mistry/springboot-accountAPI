package com.bae.business;

import org.springframework.stereotype.Service;

@Service
public class PrizeServiceImpl implements PrizeService {

	public String getPrize(String accountNumber) {
		switch (accountNumber.length()) {
		case 7:
			if(accountNumber.charAt(0) == 'A') {
				return "£0";
			} else if(accountNumber.charAt(0) == 'B') {
				return "£50";
			} else {
				return "£100";
			}
		case 9:
			if(accountNumber.charAt(0) == 'A') {
				return "£0";
			} else if(accountNumber.charAt(0) == 'B') {
				return "£500";
			} else {
				return "£750";
			}
		case 11:
			if(accountNumber.charAt(0) == 'A') {
				return "£0";
			} else if(accountNumber.charAt(0) == 'B') {
				return "£5000";
			} else {
				return "£10000";
			}
		}
		return null;
	}

}
