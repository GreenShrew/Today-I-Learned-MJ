package com.ezen.word.service;

import com.ezen.word.dao.WordDao;
import com.ezen.word.dto.WordSet;

public class WordInsertService {

	private WordDao wdao;
	
	public WordInsertService(WordDao wdao) {
		this.wdao = wdao;
	}
	
	public void insert(WordSet wordSet) {
		wdao.insert(wordSet);
	}
}
