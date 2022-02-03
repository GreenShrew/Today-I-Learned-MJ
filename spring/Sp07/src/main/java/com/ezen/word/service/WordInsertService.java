package com.ezen.word.service;

import com.ezen.word.dto.WordSet;

public class WordInsertService {

	private WordDao worddao;
	
	public WordInsertService(WordDao wdao) {
		this.wdao = wdao;
	}
	
	public void insert(WordSet wordSet) {
		worddao.insert(wordSet);
	}
}
