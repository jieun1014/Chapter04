package com.rubypaper.Chapter04;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JPAClient {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Chapter04");
		EntityManager em = emf.createEntityManager();
		
		//트랜잭션 생성
		EntityTransaction tx = em.getTransaction();
		try {
//			//글 1건 등록
//			//트랜잭션 시작
			tx.begin();
//			
//			Board board = new Board();
//			board.setTitle("JPA 타이틀22");
//			board.setWriter("관리자");
//			board.setContent("두번째 내용");
//			board.setCreateDate(new Date());
//			board.setCnt(0L);
//			
//			em.persist(board);
//			
//			//글 수정
//			Board boardUpdate = new Board();
//			boardUpdate.setSeq(4L);
//			boardUpdate.setTitle("수정한 타이틀");
//			boardUpdate.setWriter("관리자");
//			boardUpdate.setContent("수정한 내용");
//			boardUpdate.setCreateDate(new Date());
//			boardUpdate.setCnt(0L);
//			
//			em.merge(boardUpdate);
			
//			//글 상세 조회 후 수정
//			Board searchBoard = em.find(Board.class, 1L);
//			searchBoard.setTitle("검색한  게시글의 제목 수정");
			
//			//글 상세 조회 후 삭제
//			Board board = em.find(Board.class, 1L);
//			board.setSeq(1L);
//			em.remove(board);
			
			//글 목록 조회
			String jpql = "select b from Board b order by b.seq desc";
			List<Board> boardList = em.createQuery(jpql, Board.class).getResultList();
			
			for (Board brd : boardList) {
				System.out.println("--> " + brd.toString());
			}
			
			//트랜잭션 커밋
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
//			//트랜잭션 롤백
			tx.rollback();
		} finally {
			em.close();
			emf.close();
		}
	} 

}
