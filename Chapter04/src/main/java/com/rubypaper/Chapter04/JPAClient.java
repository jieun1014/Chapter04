package com.rubypaper.Chapter04;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JPAClient {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Chapter04");
		EntityManager em = emf.createEntityManager();
		
		//트랜잭션 생성
		//EntityTransaction tx = em.getTransaction();
		try {
			//글 1건 등록
//			//트랜잭션 시작
//			tx.begin();
//			
//			Board board = new Board();
//			board.setTitle("JPA 제목");
//			board.setWriter("관리자");
//			board.setContent("JPA 글 등록 잘 됩니다.");
//			board.setCreateDate(new Date());
//			board.setCnt(0L);
//			
//			em.persist(board);
//			
//			//트랜잭션 커밋
//			tx.commit();
			
			//글 상세 조회
			Board searchBoard = em.find(Board.class, 4L);
			System.out.println("---> " + searchBoard);
		} catch (Exception e) {
			e.printStackTrace();
//			//트랜잭션 롤백
//			tx.rollback();
		} finally {
			em.close();
			emf.close();
		}
	} 

}
