package com.ezen.spg13.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.ezen.spg13.dao.ITransactionDao1;
import com.ezen.spg13.dao.ITransactionDao2;

@Service
public class MyService {

	@Autowired
	ITransactionDao1 td1;
	
	@Autowired
	ITransactionDao2 td2;

	@Autowired
	TransactionTemplate tt;
	
	public int buy(String id, int amount, int error) {
		
		try {
			tt.execute(new TransactionCallbackWithoutResult() {
	
				@Override
				protected void doInTransactionWithoutResult(TransactionStatus status) {
					td1.buy(id, amount);
					int n = 0;
					if(error==1) {
						n = 10/0;	// 강제 에러발생
					}
					td2.buy(id, amount);
					System.out.println("Transaction Commit!");
				}
			});
			return 1;
		}catch(Exception e) {
			System.out.println("Transaction RollBack!");
			return 0;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/* 옛날 방식
	@Autowired
	PlatformTransactionManager ptm;
	
	@Autowired
	TransactionDefinition td;
	
	
	public int buy(String id, int amount, int error) {
		int result = 0;
		int n = 0;
		// 전달된 아이디와 구매갯수를 transaction1, transaction2 두개의 테이블에 insert 한다.
		// 하나 이상의 데이터베이스 작업을 한단위로 묶어서 하나의 실행단위로 정의된 것을 트랜잭션이라고 한다.
		// 트랜잭션 하나가 모두 다 실행이 되어 완료되면, commit이라는 명령으로 작업을 완료하고,
		// 중간에 에러가 발생하여 트랜잭션을 취소하고자 한다면 rollback이라는 명령으로 취소한다.
		
		// 트랜젝션의 시작
		TransactionStatus status = ptm.getTransaction(td);
		// 끝은 commit 또는 rollback이다.
		
		try {	// 강제 에러를 발생시키므로 예외처리를 해야한다.
			td1.buy(id, amount);
			if(error==1) {
				n = 10/0;	// 강제 에러발생
			}
			td2.buy(id, amount);
			System.out.println("에러없이 둘다 실행되었습니다.");
			ptm.commit(status);	// 영역 안의 모든 데이터베이스 작업의 실행을 적용한다. - 트랜젝션의 끝
			result = 1;
		}catch(Exception e) {
			System.out.println("중간에 에러나서 둘다 실행이 안 되었습니다.");
			ptm.rollback(status);	// 영역 안의 모든 데이터베이스 작업의 취소
			result = 0;
		}
		return result;
	}
	*/
}
