package com.ezen.word.service;

import com.ezen.word.dao.WordDao;
import com.ezen.word.dto.WordSet;

public class WordInsertService {

	private WordDao worddao;
	
	public WordInsertService(WordDao worddao) {
		this.worddao = worddao;
	}
	
	public void insert(WordSet wordSet) {
		worddao.insert(wordSet);
	}
}
